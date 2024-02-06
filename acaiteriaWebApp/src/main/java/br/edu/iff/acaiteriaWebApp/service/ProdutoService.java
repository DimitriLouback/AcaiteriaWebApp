package br.edu.iff.acaiteriaWebApp.service;

import br.edu.iff.acaiteriaWebApp.model.Produto;
import br.edu.iff.acaiteriaWebApp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public String cadastrarProduto(String nome, String descricao, double preco) {
        Produto novoProduto = new Produto(nome, descricao, preco);
        produtoRepository.save(novoProduto);
        return "Produto cadastrado com sucesso.";
    }

    public String atualizarProduto(Long id, String nome, String descricao, double preco) {
        Produto produtoExistente = buscarProduto(id);

        if (produtoExistente != null) {
            produtoExistente.setNome(nome);
            produtoExistente.setDescricao(descricao);
            produtoExistente.setPreco(preco);
            produtoRepository.save(produtoExistente);
            return "Produto atualizado com sucesso.";
        } else {
            return "Produto não encontrado.";
        }
    }

    public String deletarProduto(Long id) {
        Produto produtoExistente = buscarProduto(id);

        if (produtoExistente != null) {
            produtoRepository.delete(produtoExistente);
            return "Produto deletado com sucesso.";
        } else {
            return "Produto não encontrado.";
        }
    }

    public Produto buscarProduto(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }
}

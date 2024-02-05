package br.edu.iff.acaiteriaWebApp.controller.apirest;

import br.edu.iff.acaiteriaWebApp.model.Produto;
import br.edu.iff.acaiteriaWebApp.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public Produto obterProduto(@PathVariable Long id) {
        return produtoService.buscarProduto(id);
    }

    @PostMapping
    public String cadastrarProduto(@RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto.getNome(), produto.getDescricao(), produto.getPreco());
    }

    @PutMapping("/{id}")
    public String atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto.getNome(), produto.getDescricao(), produto.getPreco());
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Long id) {
        return produtoService.deletarProduto(id);
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }
}

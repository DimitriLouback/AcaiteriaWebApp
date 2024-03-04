package br.edu.iff.acaiteriaWebApp.controller.apirest;

import br.edu.iff.acaiteriaWebApp.model.Produto;
import br.edu.iff.acaiteriaWebApp.service.ProdutoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Operation(description = "busca o produto pelo id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna produto"),
            @ApiResponse(responseCode = "400", description = "produto inexistente")
    }
    )
    @GetMapping("/{id}")
    public Produto obterProduto(@PathVariable Long id) {
        return produtoService.buscarProduto(id);
    }

    @PostMapping
    public String cadastrarProduto(@Valid @RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto.getNome(), produto.getDescricao(), produto.getPreco());
    }

    @PutMapping("/{id}")
    public String atualizarProduto(@PathVariable Long id, @Valid @RequestBody Produto produto) {
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

package br.edu.iff.acaiteriaWebApp.controller.apirest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping("/{id}")
    public String obterProduto(@PathVariable Long id) {
        return "Obtendo produto com ID: " + id;
    }

    @PostMapping
    public String cadastrarProduto(@RequestBody String produto) {
        return "Cadastrando novo produto: " + produto;
    }

    @PutMapping("/{id}")
    public String atualizarProduto(@PathVariable Long id, @RequestBody String produto) {
        return "Atualizando produto com ID " + id + ": " + produto;
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Long id) {
        return "Deletando produto com ID: " + id;
    }
}

package br.edu.iff.acaiteriaWebApp.controller.apirest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @GetMapping("/{id}")
    public String obterPedido(@PathVariable Long id) {
        return "Obtendo pedido com ID: " + id;
    }

    @PostMapping
    public String cadastrarPedido(@RequestBody String pedido) {
        return "Cadastrando novo pedido: " + pedido;
    }

    @PutMapping("/{id}")
    public String atualizarPedido(@PathVariable Long id, @RequestBody String pedido) {
        return "Atualizando pedido com ID " + id + ": " + pedido;
    }

    @DeleteMapping("/{id}")
    public String deletarPedido(@PathVariable Long id) {
        return "Deletando pedido com ID: " + id;
    }
}

package br.edu.iff.acaiwebapp.controller.apirest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping("/{id}")
    public String obterCliente(@PathVariable Long id) {
        return "Obtendo cliente com ID: " + id;
    }

    @PostMapping
    public String cadastrarCliente(@RequestBody String cliente) {
        return "Cadastrando novo cliente: " + cliente;
    }

    @PutMapping("/{id}")
    public String atualizarCliente(@PathVariable Long id, @RequestBody String cliente) {
        return "Atualizando cliente com ID " + id + ": " + cliente;
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable Long id) {
        return "Deletando cliente com ID: " + id;
    }
}
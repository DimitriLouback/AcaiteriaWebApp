package br.edu.iff.acaiteriaWebApp.controller.apirest;

import br.edu.iff.acaiteriaWebApp.model.Cliente;
import br.edu.iff.acaiteriaWebApp.service.ClienteService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Operation(description = "busca o cliente pelo id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna cliente"),
            @ApiResponse(responseCode = "400", description = "Cliente inexistente")
            }
    )
    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable Long id) {
        return clienteService.buscarCliente(id);
    }

    @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso")
    @PostMapping
    public Cliente cadastrarCliente(@Valid @RequestBody Cliente cliente) {
        return clienteService.cadastrarCliente(cliente.getNome(), cliente.getTelefone(), cliente.getEndereco());
    }

    @PutMapping("/{id}")
    public String atualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente.getNome(), cliente.getTelefone(), cliente.getEndereco());
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable Long id) {
        return clienteService.deletarCliente(id);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }
}

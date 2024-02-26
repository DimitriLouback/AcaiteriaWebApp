package br.edu.iff.acaiteriaWebApp.controller.apirest;

import br.edu.iff.acaiteriaWebApp.model.Cliente;
import br.edu.iff.acaiteriaWebApp.model.ItemPedido;
import br.edu.iff.acaiteriaWebApp.model.Pedido;
import br.edu.iff.acaiteriaWebApp.model.StatusPedido;
import br.edu.iff.acaiteriaWebApp.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Operation(description = "busca o pedido pelo id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna pedido"),
            @ApiResponse(responseCode = "400", description = "Pedido inexistente")
    }
    )
    @GetMapping("/{id}")
    public Pedido obterPedido(@PathVariable Long id) {
        return pedidoService.buscarPedido(id);
    }

    @PostMapping
    public String cadastrarPedido( @Valid @RequestBody Pedido pedido) {
        return pedidoService.cadastrarPedido(pedido.getDataPedido(), pedido.getStatus(), pedido.getTotal(), pedido.getCliente(), pedido.getItensPedido());
    }

    @PutMapping("/{id}")
    public String atualizarPedido(@PathVariable Long id, @Valid @RequestBody Pedido pedido) {
        return pedidoService.atualizarPedido(id, pedido.getDataPedido(), pedido.getStatus(), pedido.getTotal(), pedido.getCliente(), pedido.getItensPedido());
    }

    @DeleteMapping("/{id}")
    public String deletarPedido(@PathVariable Long id) {
        return pedidoService.deletarPedido(id);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }
}

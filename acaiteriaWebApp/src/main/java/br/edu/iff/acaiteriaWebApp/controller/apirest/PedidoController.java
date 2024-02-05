package br.edu.iff.acaiteriaWebApp.controller.apirest;

import br.edu.iff.acaiteriaWebApp.model.Cliente;
import br.edu.iff.acaiteriaWebApp.model.ItemPedido;
import br.edu.iff.acaiteriaWebApp.model.Pedido;
import br.edu.iff.acaiteriaWebApp.model.StatusPedido;
import br.edu.iff.acaiteriaWebApp.service.PedidoService;

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

    @GetMapping("/{id}")
    public Pedido obterPedido(@PathVariable Long id) {
        return pedidoService.buscarPedido(id);
    }

    @PostMapping
    public String cadastrarPedido(@RequestBody Pedido pedido) {
        return pedidoService.cadastrarPedido(pedido.getDataPedido(), pedido.getStatus(), pedido.getTotal(), pedido.getCliente(), pedido.getItensPedido());
    }

    @PutMapping("/{id}")
    public String atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
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

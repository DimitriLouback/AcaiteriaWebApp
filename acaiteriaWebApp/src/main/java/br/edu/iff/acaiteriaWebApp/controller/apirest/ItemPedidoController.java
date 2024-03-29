package br.edu.iff.acaiteriaWebApp.controller.apirest;

import br.edu.iff.acaiteriaWebApp.model.ItemPedido;
import br.edu.iff.acaiteriaWebApp.model.Pedido;
import br.edu.iff.acaiteriaWebApp.model.Produto;
import br.edu.iff.acaiteriaWebApp.service.ItemPedidoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    private final ItemPedidoService itemPedidoService;

    @Autowired
    public ItemPedidoController(ItemPedidoService itemPedidoService) {
        this.itemPedidoService = itemPedidoService;
    }

    @PostMapping
    public String cadastrarItemPedido(@RequestParam int quantidade,
                                      @RequestParam double subtotal,
                                      @RequestParam Produto produto,
                                      @RequestParam Pedido pedido) {
        return itemPedidoService.cadastrarItemPedido(quantidade, subtotal, produto, pedido);
    }

    @PutMapping("/{id}")
    public String atualizarItemPedido(@PathVariable Long id,
                                      @RequestParam int quantidade,
                                      @RequestParam double subtotal,
                                      @RequestParam Produto produto,
                                      @RequestParam Pedido pedido) {
        return itemPedidoService.atualizarItemPedido(id, quantidade, subtotal, produto, pedido);
    }

    @DeleteMapping("/{id}")
    public String deletarItemPedido(@PathVariable Long id) {
        return itemPedidoService.deletarItemPedido(id);
    }

    @Operation(description = "busca os itens pelo id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna itens"),
            @ApiResponse(responseCode = "400", description = "itens inexistente")
    }
    )
    @GetMapping("/{id}")
    public ItemPedido buscarItemPedido(@PathVariable Long id) {
        return itemPedidoService.buscarItemPedido(id);
    }

    @GetMapping
    public List<ItemPedido> listarItensPedido() {
        return itemPedidoService.listarItensPedido();
    }
}

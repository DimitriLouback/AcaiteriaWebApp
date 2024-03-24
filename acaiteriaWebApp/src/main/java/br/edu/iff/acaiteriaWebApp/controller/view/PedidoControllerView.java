package br.edu.iff.acaiteriaWebApp.controller.view;
import br.edu.iff.acaiteriaWebApp.model.*;
import br.edu.iff.acaiteriaWebApp.service.AdicionalService;
import br.edu.iff.acaiteriaWebApp.service.ClienteService;
import br.edu.iff.acaiteriaWebApp.service.PedidoService;
import br.edu.iff.acaiteriaWebApp.service.ProdutoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class PedidoControllerView {

    private final ClienteService clienteService;

    private final ProdutoService produtoService;

    private final PedidoService pedidoService;

    private final AdicionalService adicionalService;

    @Autowired
    public PedidoControllerView(ClienteService clienteService, ProdutoService produtoService, PedidoService pedidoService, AdicionalService adicionalService) {
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.pedidoService = pedidoService;
        this.adicionalService = adicionalService;
    }

    @GetMapping("/historico_pedidos")
    public String historicoPedidos(Model model) {
        // Obtenha a lista de pedidos do serviço de pedidos
        List<Pedido> pedidos = pedidoService.listarPedidos();

        // Adicione a lista de pedidos ao modelo
        model.addAttribute("pedidos", pedidos);

        // Retorna o nome da página HTML para ser exibida
        return "historico_pedidos";
    }

    @GetMapping("/pedido")
    public String pedido() {
        return "pedido";
    }
}

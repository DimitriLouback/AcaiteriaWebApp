package br.edu.iff.acaiteriaWebApp.controller.view;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidoControllerView {

    @GetMapping("/historico_pedidos")
    public String historico_pedidos() {
        return "historico_pedidos";
    }
}

package br.edu.iff.acaiteriaWebApp.controller.view;
import br.edu.iff.acaiteriaWebApp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllerView {

    private final ClienteService clienteService;

    @Autowired
    public HomeControllerView(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}

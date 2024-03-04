package br.edu.iff.acaiteriaWebApp.controller.view;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControllerView {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}

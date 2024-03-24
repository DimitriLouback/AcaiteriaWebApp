package br.edu.iff.acaiteriaWebApp.controller.view;

import br.edu.iff.acaiteriaWebApp.model.Cliente;
import br.edu.iff.acaiteriaWebApp.service.ClienteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ClienteControllerView {

    private final ClienteService clienteService;

    @Autowired
    public ClienteControllerView(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

   @PostMapping("/cadastrar")
    public String cadastrarCliente(@ModelAttribute Cliente cliente) {
       clienteService.cadastrarCliente(cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getSenha());
       return "home"; //redirecionando pra página principal

   }

   @PostMapping("/login")
    public String loginCliente(@RequestParam String nome, @RequestParam String senha, Model model, HttpServletRequest request) {
       Cliente clienteAutenticado = clienteService.autenticarCliente(nome, senha);
       if (clienteAutenticado != null) {
           //Login sucedido
           HttpSession session = request.getSession();
           session.setAttribute("clienteLogado", clienteAutenticado);
           return "home";
       } else {
           //Login falhou
           model.addAttribute("loginError", true);
           return "home";
       }
   }
    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidar a sessão do usuário
        }
        return "redirect:/login"; // Redirecionar para a página de login
    }

}



package br.edu.iff.acaiteriaWebApp.controller.view;

import br.edu.iff.acaiteriaWebApp.model.Produto;
import br.edu.iff.acaiteriaWebApp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProdutoControllerView {

    private final ClienteService clienteService;

    @Autowired
    public ProdutoControllerView(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
}

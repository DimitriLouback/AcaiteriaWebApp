package br.edu.iff.acaiteriaWebApp.service;


import br.edu.iff.acaiteriaWebApp.model.Cliente;
import br.edu.iff.acaiteriaWebApp.model.ItemPedido;
import br.edu.iff.acaiteriaWebApp.model.Pedido;
import br.edu.iff.acaiteriaWebApp.model.StatusPedido;
import br.edu.iff.acaiteriaWebApp.repository.ClienteRepository;
import br.edu.iff.acaiteriaWebApp.service.ClienteService;
import br.edu.iff.acaiteriaWebApp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService ) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
    }

    public String cadastrarPedido(Date dataPedido, StatusPedido status, double total, Cliente cliente, List<ItemPedido> itensPedido) {
        if (clienteService == null) {
            return "Erro: clienteService não inicializado corretamente.";
        }
        Cliente clienteSalvo = clienteService.cadastrarCliente(cliente.getNome(), cliente.getTelefone(), cliente.getEndereco());
        Pedido novoPedido = new Pedido(dataPedido, status, total, clienteSalvo, itensPedido);
        pedidoRepository.save(novoPedido);
        return "Pedido cadastrado com sucesso.";
    }

    public String atualizarPedido(Long id, Date dataPedido, StatusPedido status, double total, Cliente cliente, List<ItemPedido> itensPedido) {
        Pedido pedidoExistente = buscarPedido(id);

        if (pedidoExistente != null) {
            pedidoExistente.setDataPedido(dataPedido);
            pedidoExistente.setStatus(status);
            pedidoExistente.setTotal(total);
            pedidoExistente.setCliente(cliente);
            pedidoExistente.setItensPedido(itensPedido);
            pedidoRepository.save(pedidoExistente);
            return "Pedido atualizado com sucesso.";
        } else {
            return "Pedido não encontrado.";
        }
    }

    public String deletarPedido(Long id) {
        Pedido pedidoExistente = buscarPedido(id);

        if (pedidoExistente != null) {
            pedidoRepository.delete(pedidoExistente);
            return "Pedido deletado com sucesso.";
        } else {
            return "Pedido não encontrado.";
        }
    }

    public Pedido buscarPedido(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}

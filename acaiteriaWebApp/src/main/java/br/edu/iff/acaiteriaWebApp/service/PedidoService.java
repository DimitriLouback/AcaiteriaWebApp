package br.edu.iff.acaiteriaWebApp.service;


import br.edu.iff.acaiteriaWebApp.model.*;
import br.edu.iff.acaiteriaWebApp.repository.ClienteRepository;
import br.edu.iff.acaiteriaWebApp.service.ClienteService;
import br.edu.iff.acaiteriaWebApp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.iff.acaiteriaWebApp.service.ProdutoService;
import br.edu.iff.acaiteriaWebApp.service.AdicionalService;

import java.util.Date;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;
    private final AdicionalService adicionalService;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService, ProdutoService produtoService, AdicionalService adicionalService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.adicionalService = adicionalService;
    }

    public String cadastrarPedido(Date dataPedido, StatusPedido status, double total, Cliente cliente, List<ItemPedido> itensPedido) {
        if (clienteService == null) {
            return "Erro: clienteService não inicializado corretamente.";
        }
        Cliente clienteSalvo = clienteService.cadastrarCliente(cliente.getNome(), cliente.getTelefone(), cliente.getEndereco(), cliente.getSenha());
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

    public double calcularTotalPedido(String tamanho, List<String> adicionais) {
        // Lógica para calcular o preço total com base no tamanho e adicionais selecionados
        double precoBase = produtoService.calcularPrecoAcai(tamanho);
        double precoAdicionais = 0.0;
        if (adicionais != null) {
            for (String nomeAdicional : adicionais) {
                Adicional adicional = adicionalService.encontrarAdicionalPorNome(nomeAdicional);
                if (adicional != null) {
                    precoAdicionais += adicional.getPrecoAdicional();
                }
            }
        }
        return precoBase + precoAdicionais;
    }
}

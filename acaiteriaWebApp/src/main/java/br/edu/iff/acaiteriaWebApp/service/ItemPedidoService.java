package br.edu.iff.acaiteriaWebApp.service;

import br.edu.iff.acaiteriaWebApp.model.Produto;
import br.edu.iff.acaiteriaWebApp.model.Pedido;
import br.edu.iff.acaiteriaWebApp.model.ItemPedido;
import br.edu.iff.acaiteriaWebApp.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public String cadastrarItemPedido(int quantidade, double subtotal, Produto produto, Pedido pedido) {
        ItemPedido newItemPedido = new ItemPedido(quantidade, subtotal, produto, pedido);
        itemPedidoRepository.save(newItemPedido);
        return "ItemPedido cadastrado com sucesso.";
    }

    public String atualizarItemPedido(Long id, int quantidade, double subtotal, Produto produto, Pedido pedido) {
        ItemPedido itemPedidoExistente = buscarItemPedido(id);

        if (itemPedidoExistente != null) {
            itemPedidoExistente.setQuantidade(quantidade);
            itemPedidoExistente.setSubtotal(subtotal);
            itemPedidoExistente.setProduto(produto);
            itemPedidoExistente.setPedido(pedido);
            itemPedidoRepository.save(itemPedidoExistente);
            return "ItemPedido atualizado com sucesso.";
        } else {
            return "ItemPedido não encontrado.";
        }
    }

    public String deletarItemPedido(Long id) {
        ItemPedido itemPedidoExistente = buscarItemPedido(id);

        if (itemPedidoExistente != null) {
            itemPedidoRepository.delete(itemPedidoExistente);
            return "ItemPedido deletado com sucesso.";
        } else {
            return "ItemPedido não encontrado.";
        }
    }

    public ItemPedido buscarItemPedido(Long id) {
        return itemPedidoRepository.findById(id).orElse(null);
    }

    public List<ItemPedido> listarItensPedido() {
        return itemPedidoRepository.findAll();
    }
}

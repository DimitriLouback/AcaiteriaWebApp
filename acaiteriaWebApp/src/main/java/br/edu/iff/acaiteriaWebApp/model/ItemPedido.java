package br.edu.iff.acaiteriaWebApp.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;
    private double subtotal;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Pedido pedido;

    public ItemPedido(int quantidade, double subtotal, Produto produto, Pedido pedido) {
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.produto = produto;
        this.pedido = pedido;

    }

    public ItemPedido() {
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
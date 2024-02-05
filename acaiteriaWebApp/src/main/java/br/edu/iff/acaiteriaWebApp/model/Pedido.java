package br.edu.iff.acaiteriaWebApp.model;

import jakarta.persistence.*;
import java.util.List;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataPedido;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private double total;


    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedido;

    public Pedido(Date dataPedido, StatusPedido status, double total,Cliente cliente,List<ItemPedido> itensPedido) {
        this.dataPedido = dataPedido;
        this.itensPedido = itensPedido;
        this.status = status;
        this.total = total;
        this.cliente = cliente;
    }

    public Pedido() {
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
package br.edu.iff.acaiteriaWebApp.model;

public class ItemCarrinho {

    private int quantidade;

    private Produto produto;

    public ItemCarrinho(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public ItemCarrinho setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public ItemCarrinho setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }
}

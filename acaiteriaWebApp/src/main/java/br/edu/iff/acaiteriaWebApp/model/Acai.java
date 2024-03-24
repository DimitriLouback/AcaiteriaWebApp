package br.edu.iff.acaiteriaWebApp.model;

import jakarta.persistence.OneToMany;


import java.util.ArrayList;
import java.util.List;

public class Acai extends Produto {

    private String tamanho;

    private List<Adicional> adicionais;

    public Acai(String nome, String descricao, double preco, String tamanho) {
        super(nome, descricao, preco);
        this.tamanho = tamanho;
        this.adicionais = new ArrayList<>();
    }

    public String getTamanho() {
        return tamanho;
    }

    public Acai setTamanho(String tamanho) {
        this.tamanho = tamanho;
        return this;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }

    public Acai setAdicionais(List<Adicional> adicionais) {
        this.adicionais = adicionais;
        return this;
    }
}

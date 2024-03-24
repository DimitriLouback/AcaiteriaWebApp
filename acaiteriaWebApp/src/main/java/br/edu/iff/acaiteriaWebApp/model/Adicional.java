package br.edu.iff.acaiteriaWebApp.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Adicional {

    private String nome;

    private double precoAdicional;


    public Adicional(String granola, double v) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoAdicional() {
        return precoAdicional;
    }

    public void setPrecoAdicional(double precoAdicional) {
        this.precoAdicional = precoAdicional;
    }
}

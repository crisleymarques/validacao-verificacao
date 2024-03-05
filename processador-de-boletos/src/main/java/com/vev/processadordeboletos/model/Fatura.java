package com.vev.processadordeboletos.model;

import java.util.UUID;

public class Fatura {
    private String id;
    private double valorTotal;
    private String nomeCliente;
    private boolean isPaga;

    public Fatura(double valorTotal, String nomeCliente) {
        this.id = UUID.randomUUID().toString();
        this.valorTotal = valorTotal;
        this.nomeCliente = nomeCliente;
        this.isPaga = false;
    }

    public String getId() {
        return this.id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public boolean isPaga() {
        return isPaga;
    }

    public void setPaga(boolean paga) {
        isPaga = paga;
    }
}

package com.vev.processadordeboletos.model;

import java.time.LocalDate;
import java.util.UUID;

/** Uma fatura contém data, valor total e nome do cliente.
 * @autor Crisley Marques
 * @since 05 mar 2024
 */
public class Fatura {
    private String id;
    private LocalDate data;
    private double valorTotal;
    private String nomeCliente;
    private boolean isPaga;

    public Fatura(LocalDate data, double valorTotal, String nomeCliente) {
        this.id = UUID.randomUUID().toString();
        this.data = data;
        this.valorTotal = valorTotal;
        this.nomeCliente = nomeCliente;
        this.isPaga = false;
    }

    public String getId() {
        return this.id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
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

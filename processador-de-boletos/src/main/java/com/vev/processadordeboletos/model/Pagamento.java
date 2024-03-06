package com.vev.processadordeboletos.model;

import java.time.LocalDate;
import java.util.UUID;

/** Um pagamento contém o valor pago, a data, e o tipo do pagamento efetuado
 * @autor Crisley Marques
 * @since 05 mar 2024
 */
public class Pagamento {
    private String id;
    private String idFatura;
    private double valorPago;
    private LocalDate data;
    private TipoPagamento tipoPagamento;

    public Pagamento(double valorPago, LocalDate data, TipoPagamento tipoPagamento, String idFatura) {
        this.id = UUID.randomUUID().toString();
        this.valorPago = valorPago;
        this.data = data;
        this.tipoPagamento = tipoPagamento;
        this.idFatura = idFatura;
    }

    public String getId() {
        return this.id;
    }

    public String getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(String idFatura) {
        this.idFatura = idFatura;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}

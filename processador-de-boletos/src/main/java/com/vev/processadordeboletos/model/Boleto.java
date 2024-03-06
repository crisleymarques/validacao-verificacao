package com.vev.processadordeboletos.model;

import java.time.LocalDate;
import java.util.UUID;

/** Um boleto contém o código do boleto, data, e valor pago.
 * @autor Crisley Marques
 * @since 05 mar 2024
 */
public class Boleto {
    private String codigo;
    private LocalDate data;
    private double valorPago;

    public Boleto(LocalDate data, double valorPago) {
        this.codigo = UUID.randomUUID().toString();
        this.data = data;
        this.valorPago = valorPago;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}

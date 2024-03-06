package com.vev.processadordeboletos;

import com.vev.processadordeboletos.model.Boleto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoletoTests {
    private LocalDate data;
    private double valorPago;
    private Boleto boleto;

    @BeforeEach
    public void setUp() {
        this.data = LocalDate.of(2024, 1,1);
        this.valorPago = 500;
        this.boleto = new Boleto(this.data, this.valorPago);
    }

    @Test
    @DisplayName("Verifica se o código é gerado corretamente")
    void testGetCodigo() {
        assertNotNull(this.boleto.getCodigo());
        assertNotEquals("", this.boleto.getCodigo());
    }

    @Test
    @DisplayName("Verifica se valorPago é igual ao setado")
    void testGetValorPago() {
        assertEquals(this.valorPago, this.boleto.getValorPago());
    }

    @Test
    @DisplayName("Verifica se valorPago é setado corretamente")
    void testSetValorPago() {
        double novoValor = 400;

        this.boleto.setValorPago(novoValor);
        assertEquals(novoValor, this.boleto.getValorPago());
    }

    @Test
    @DisplayName("Verifica se data é igual ao setado")
    void testGetData() {
        assertEquals(this.data, this.boleto.getData());
    }

    @Test
    @DisplayName("Verifica se data é setado corretamente")
    void testSetData() {
        LocalDate novaData = LocalDate.of(2025, 12,31);

        this.boleto.setData(novaData);
        assertEquals(novaData, this.boleto.getData());
    }
}
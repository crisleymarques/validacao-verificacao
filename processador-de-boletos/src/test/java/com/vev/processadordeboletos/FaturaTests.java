package com.vev.processadordeboletos;

import com.vev.processadordeboletos.model.Fatura;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FaturaTests {
    private LocalDate data;
    private double valorTotal;
    private String nomeCliente;
    private Fatura fatura;

    @BeforeEach
    public void setUp() {
        this.data = LocalDate.of(2024, 1, 1);
        this.valorTotal = 1500;
        this.nomeCliente = "Fulano de Tal";
        this.fatura = new Fatura(this.data, this.valorTotal, this.nomeCliente);
    }

    @Test
    @DisplayName("Verifica se o id é gerado corretamente")
    void testGetId() {
        assertNotNull(this.fatura.getId());
        assertNotEquals("", this.fatura.getId());
    }

    @Test
    @DisplayName("Verifica se data é igual ao setado")
    void testGetData() {
        assertEquals(this.data, this.fatura.getData());
    }

    @Test
    @DisplayName("Verifica se data é setado corretamente")
    void testSetData() {
        LocalDate novaData = LocalDate.of(2025, 12,31);

        this.fatura.setData(novaData);
        assertEquals(novaData, this.fatura.getData());
    }

    @Test
    @DisplayName("Verifica se valorTotal é igual ao setado")
    void testGetValorTotal() {
        assertEquals(this.valorTotal, this.fatura.getValorTotal());
    }

    @Test
    @DisplayName("Verifica se valorTotal é setado corretamente")
    void testSetValorTotal() {
        double novoValor = 2000;

        this.fatura.setValorTotal(novoValor);
        assertEquals(novoValor, this.fatura.getValorTotal());
    }

    @Test
    @DisplayName("Verifica se nomeCliente é igual ao setado")
    void testGetNomeCliente() {
        assertEquals(this.nomeCliente, this.fatura.getNomeCliente());
    }

    @Test
    @DisplayName("Verifica se nomeCliente é setado corretamente")
    void testSetNomeCliente() {
        String novoNome = "John Doe";

        this.fatura.setNomeCliente(novoNome);
        assertEquals(novoNome, this.fatura.getNomeCliente());
    }
}
package com.vev.processadordeboletos;

import com.vev.processadordeboletos.model.Fatura;
import com.vev.processadordeboletos.model.Pagamento;
import com.vev.processadordeboletos.model.TipoPagamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PagamentoTests {
    private double valorPago;
    private LocalDate data;
    private TipoPagamento tipoPagamento;
    private Pagamento pagamento;
    private Fatura fatura;

    @BeforeEach
    public void setUp() {
        this.valorPago = 200;
        this.data = LocalDate.of(2024, 1, 1);
        this.tipoPagamento = TipoPagamento.BOLETO;
        this.fatura = new Fatura(LocalDate.of(2024, 12, 31), 1500, "Nome Teste");
        this.pagamento = new Pagamento(valorPago, data, tipoPagamento, this.fatura.getId());
    }

    @Test
    @DisplayName("Verifica se o id é gerado corretamente")
    void testGetId() {
        assertNotNull(this.pagamento.getId());
        assertNotEquals("", this.pagamento.getId());
    }

    @Test
    @DisplayName("Verifica se valorPago é igual ao setado")
    void testGetValorPago() {
        assertEquals(this.valorPago, this.pagamento.getValorPago());
    }

    @Test
    @DisplayName("Verifica se valorPago é setado corretamente")
    void testSetValorPago() {
        double novoValor = 900;

        this.pagamento.setValorPago(novoValor);
        assertEquals(novoValor, this.pagamento.getValorPago());
    }

    @Test
    @DisplayName("Verifica se data é igual ao setado")
    void testGetData() {
        assertEquals(this.data, this.pagamento.getData());
    }

    @Test
    @DisplayName("Verifica se data é setado corretamente")
    void testSetData() {
        LocalDate novaData = LocalDate.of(2025, 12,31);

        this.pagamento.setData(novaData);
        assertEquals(novaData, this.pagamento.getData());
    }

    @Test
    @DisplayName("Verifica se tipoPagamento é igual ao setado")
    void testGetTipoPagamento() {
        assertEquals(this.tipoPagamento, this.pagamento.getTipoPagamento());
    }

    @Test
    @DisplayName("Verifica se tipoPagamento é setado corretamente")
    void testSetTipoPagamento() {
        TipoPagamento novoTipo = TipoPagamento.BOLETO;

        this.pagamento.setTipoPagamento(novoTipo);
        assertEquals(novoTipo, this.pagamento.getTipoPagamento());
    }

    @Test
    @DisplayName("Verifica se idFatura é igual ao setado")
    void testGetIdFatura() {
        assertEquals(this.fatura.getId(), this.pagamento.getIdFatura());
    }

    @Test
    @DisplayName("Verifica se idFatura é setado corretamente")
    void testSetIdFatura() {
        Fatura novaFatura = new Fatura(LocalDate.of(2024, 12, 31), 3000, "Nova Fatura");

        this.pagamento.setIdFatura(novaFatura.getId());
        assertEquals(novaFatura.getId(), this.pagamento.getIdFatura());
    }
}

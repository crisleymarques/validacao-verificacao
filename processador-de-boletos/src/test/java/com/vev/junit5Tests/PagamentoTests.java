package com.vev.junit5Tests;

import com.vev.junit5Tests.interfaces.FunctionalTest;
import com.vev.processadordeboletos.model.Fatura;
import com.vev.processadordeboletos.model.Pagamento;
import com.vev.processadordeboletos.model.ProcessadorBoletos;
import com.vev.processadordeboletos.model.TipoPagamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ProcessadorBoletos.class)
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
        this.pagamento = new Pagamento(valorPago, data, tipoPagamento, fatura.getId());
    }

    @Nested
    @DisplayName("Testes Funcionais do Id do Pagamento")
    class IdPagamentoTests {

        @FunctionalTest
        @DisplayName("Verifica se o id é gerado corretamente")
        void testGetId() {
            assertNotNull(pagamento.getId());
            assertNotEquals("", pagamento.getId());
        }
    }

    @Nested
    @DisplayName("Testes Funcionais do ValorPago do Pagamento")
    class ValorPagoPagamentoTests {

        @FunctionalTest
        @DisplayName("Verifica se valorPago é igual ao setado")
        void testGetValorPago() {
            assertEquals(valorPago, pagamento.getValorPago());
        }

        @FunctionalTest
        @DisplayName("Verifica se valorPago é setado corretamente")
        void testSetValorPago() {
            double novoValor = 900;

            pagamento.setValorPago(novoValor);
            assertEquals(novoValor, pagamento.getValorPago());
        }
    }

    @Nested
    @DisplayName("Testes Funcionais do Data do Pagamento")
    class DataPagamentoTests {

        @FunctionalTest
        @DisplayName("Verifica se data é igual ao setado")
        void testGetData() {
            assertEquals(data, pagamento.getData());
        }

        @FunctionalTest
        @DisplayName("Verifica se data é setado corretamente")
        void testSetData() {
            LocalDate novaData = LocalDate.of(2025, 12, 31);

            pagamento.setData(novaData);
            assertEquals(novaData, pagamento.getData());
        }
    }

    @Nested
    @DisplayName("Testes Funcionais do TipoPagamento do Pagamento")
    class TipoPagamentoPagamentoTests {

        @FunctionalTest
        @DisplayName("Verifica se tipoPagamento é igual ao setado")
        void testGetTipoPagamento() {
            assertEquals(tipoPagamento, pagamento.getTipoPagamento());
        }

        @FunctionalTest
        @DisplayName("Verifica se tipoPagamento é setado corretamente")
        void testSetTipoPagamento() {
            TipoPagamento novoTipo = TipoPagamento.BOLETO;

            pagamento.setTipoPagamento(novoTipo);
            assertEquals(novoTipo, pagamento.getTipoPagamento());
        }
    }

    @Nested
    @DisplayName("Testes Funcionais do idFatura do Pagamento")
    class IdFaturaPagamentoTests {

        @FunctionalTest
        @DisplayName("Verifica se idFatura é igual ao setado")
        void testGetIdFatura() {
            assertEquals(fatura.getId(), pagamento.getIdFatura());
        }

        @FunctionalTest
        @DisplayName("Verifica se idFatura é setado corretamente")
        void testSetIdFatura() {
            Fatura novaFatura = new Fatura(LocalDate.of(2024, 12, 31), 3000, "Nova Fatura");

            pagamento.setIdFatura(novaFatura.getId());
            assertEquals(novaFatura.getId(), pagamento.getIdFatura());
        }
    }
}

package com.vev.junit5Tests;

import com.vev.junit5Tests.interfaces.FunctionalTest;
import com.vev.processadordeboletos.model.Boleto;
import com.vev.processadordeboletos.model.ProcessadorBoletos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ProcessadorBoletos.class)
public class BoletoTests {
    private LocalDate data;
    private double valorPago;
    private Boleto boleto;

    @BeforeEach
    public void setUp() {
        this.data = LocalDate.of(2024, 1,1);
        this.valorPago = 500;
        this.boleto = new Boleto(data, valorPago);
    }

    @Nested
    @DisplayName("Testes Funcionais do Codigo do boleto")
    class CodigoBoletoTests {

        @FunctionalTest
        @DisplayName("Verifica se o código é gerado corretamente")
        void testGetCodigo() {
            assertNotNull(boleto.getCodigo());
            assertNotEquals("", boleto.getCodigo());
        }
    }

    @Nested
    @DisplayName("Testes funcionais do Valor Pago do boleto")
    class ValorPagoBoletoTests {

        @FunctionalTest
        @DisplayName("Verifica se valorPago é igual ao setado")
        void testGetValorPago() {
            assertEquals(valorPago, boleto.getValorPago());
        }

        @FunctionalTest
        @DisplayName("Verifica se valorPago é setado corretamente")
        void testSetValorPago() {
            double novoValor = 400;

            boleto.setValorPago(novoValor);
            assertEquals(novoValor, boleto.getValorPago());
        }
    }

    @Nested
    @DisplayName("Testes funcionais da Data do boleto")
    class DataBoletoTests {

        @FunctionalTest
        @DisplayName("Verifica se data é igual ao setado")
        void testGetData() {
            assertEquals(data, boleto.getData());
        }

        @FunctionalTest
        @DisplayName("Verifica se data é setado corretamente")
        void testSetData() {
            LocalDate novaData = LocalDate.of(2025, 12, 31);

            boleto.setData(novaData);
            assertEquals(novaData, boleto.getData());
        }
    }
}
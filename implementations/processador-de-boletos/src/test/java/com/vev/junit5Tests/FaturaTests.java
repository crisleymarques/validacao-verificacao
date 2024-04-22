package com.vev.junit5Tests;

import com.vev.junit5Tests.interfaces.FunctionalTest;
import com.vev.processadordeboletos.model.Fatura;
import com.vev.processadordeboletos.model.ProcessadorBoletos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ProcessadorBoletos.class)
public class FaturaTests {
    private LocalDate data;
    private double valorTotal;
    private String nomeCliente;
    private Fatura fatura;

    @BeforeEach
    public void setUp() {
        data = LocalDate.of(2024, 1, 1);
        valorTotal = 1500;
        nomeCliente = "Fulano de Tal";
        fatura = new Fatura(data, valorTotal, nomeCliente);
    }

    @Nested
    @DisplayName("Testes Funcionais do Id da fatura")
    class IdFaturaTests {

        @FunctionalTest
        @DisplayName("Verifica se o id é gerado corretamente")
        void testGetId() {
            assertNotNull(fatura.getId());
            assertNotEquals("", fatura.getId());
        }
    }

    @Nested
    @DisplayName("Testes Funcionais da Data da fatura")
    class DataFaturaTests {

        @FunctionalTest
        @DisplayName("Verifica se data é igual ao setado")
        void testGetData() {
            assertEquals(data, fatura.getData());
        }

        @FunctionalTest
        @DisplayName("Verifica se data é setado corretamente")
        void testSetData() {
            LocalDate novaData = LocalDate.of(2025, 12, 31);

            fatura.setData(novaData);
            assertEquals(novaData, fatura.getData());
        }
    }

    @Nested
    @DisplayName("Testes Funcionais do ValorTotal da fatura")
    class ValorTotalFaturaTests {

        @FunctionalTest
        @DisplayName("Verifica se valorTotal é igual ao setado")
        void testGetValorTotal() {
            assertEquals(valorTotal, fatura.getValorTotal());
        }

        @FunctionalTest
        @DisplayName("Verifica se valorTotal é setado corretamente")
        void testSetValorTotal() {
            double novoValor = 2000;

            fatura.setValorTotal(novoValor);
            assertEquals(novoValor, fatura.getValorTotal());
        }
    }

    @Nested
    @DisplayName("Testes Funcionais do NomeCliente da fatura")
    class NomeClienteFaturaTests {

        @FunctionalTest
        @DisplayName("Verifica se nomeCliente é igual ao setado")
        void testGetNomeCliente() {
            assertEquals(nomeCliente, fatura.getNomeCliente());
        }

        @FunctionalTest
        @DisplayName("Verifica se nomeCliente é setado corretamente")
        void testSetNomeCliente() {
            String novoNome = "John Doe";

            fatura.setNomeCliente(novoNome);
            assertEquals(novoNome, fatura.getNomeCliente());
        }
    }
}
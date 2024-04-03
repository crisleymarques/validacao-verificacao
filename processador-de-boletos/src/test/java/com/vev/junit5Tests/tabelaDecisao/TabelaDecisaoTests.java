package com.vev.junit5Tests.tabelaDecisao;

import com.vev.junit5Tests.interfaces.TabelaDecisaoTest;
import com.vev.processadordeboletos.model.Boleto;
import com.vev.processadordeboletos.model.Fatura;
import com.vev.processadordeboletos.model.ProcessadorBoletos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = ProcessadorBoletos.class)
class TabelaDecisaoTests {
    private ProcessadorBoletos processadorBoletos;
    private Fatura fatura;
    private List<Boleto> boletos;

    @BeforeEach
    public void setUp() {
        this.processadorBoletos = new ProcessadorBoletos();
        this.boletos = new ArrayList<>();
        this.fatura = new Fatura(LocalDate.of(2024, 1, 1), 0, "Fulano de Tal");
    }

    @Nested
    @DisplayName("Testes Tabela de processamento de boletos")
    class ProcessamentoBoletosTests {

        @TabelaDecisaoTest
        @DisplayName("Processa boletos [TotalFatura > SomaBoletos]")
        void testCase1() {
            fatura.setValorTotal(500);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 250));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertFalse(fatura.isPaga());
        }

        @TabelaDecisaoTest
        @DisplayName("Processa boletos [TotalFatura = SomaBoletos]")
        void testCase2() {
            fatura.setValorTotal(500);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 250));
            boletos.add(new Boleto(LocalDate.of(2024, 12, 8), 250));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertTrue(fatura.isPaga());
        }

        @TabelaDecisaoTest
        @DisplayName("Processa boletos [TotalFatura < SomaBoletos]")
        void testCase3() {
            fatura.setValorTotal(100);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 250));
            boletos.add(new Boleto(LocalDate.of(2024, 12, 8), 250));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertTrue(fatura.isPaga());
        }
    }
}
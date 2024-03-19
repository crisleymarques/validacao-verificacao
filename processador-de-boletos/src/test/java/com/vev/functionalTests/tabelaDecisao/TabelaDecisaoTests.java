package com.vev.functionalTests.tabelaDecisao;

import com.vev.processadordeboletos.model.Boleto;
import com.vev.processadordeboletos.model.Fatura;
import com.vev.processadordeboletos.model.ProcessadorBoletos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Processa boletos [TotalFatura > SomaBoletos]")
    void testCase1() {
        this.fatura.setValorTotal(500);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 250));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertFalse(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos [TotalFatura = SomaBoletos]")
    void testCase2() {
        this.fatura.setValorTotal(500);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 250));
        this.boletos.add(new Boleto(LocalDate.of(2024, 12, 8), 250));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertTrue(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos [TotalFatura < SomaBoletos]")
    void testCase3() {
        this.fatura.setValorTotal(100);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 250));
        this.boletos.add(new Boleto(LocalDate.of(2024, 12, 8), 250));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertTrue(this.fatura.isPaga());
    }
}
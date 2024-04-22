package com.vev.functionalTests.particaoEquivalencia;

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
class ParticaoEquivalenciaTests {
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
    @DisplayName("Processa boletos Partição 1")
    void testCase1() {
        this.fatura.setValorTotal(500);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 250));
        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 250));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertTrue(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos Partição 2")
    void testCase2() {
        this.fatura.setValorTotal(500);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 1));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertFalse(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos [Falha nas duas variáveis]")
    void testCase3() {
        this.fatura.setValorTotal(-1);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), -1));

        assertThrows(Exception.class,
                () -> processadorBoletos.processaBoletos(this.boletos, this.fatura));
    }

    @Test
    @DisplayName("Processa boletos [Falha em somaBoletos]")
    void testCase4() {
        this.fatura.setValorTotal(250);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), -1));

        assertThrows(Exception.class,
                () -> processadorBoletos.processaBoletos(this.boletos, this.fatura));
    }

    @Test
    @DisplayName("Processa boletos [Falha em TotalFatura]")
    void testCase10() {
        this.fatura.setValorTotal(-1);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200));

        assertThrows(Exception.class,
                () -> processadorBoletos.processaBoletos(this.boletos, this.fatura));
    }
}
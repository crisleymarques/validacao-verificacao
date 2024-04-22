package com.vev.functionalTests.avl;

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
class AvlTests {
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
    @DisplayName("Processa boletos (xmin-, yqualquer)")
    void testCase1() {
        this.fatura.setValorTotal(500.0);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 0));
        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), -1));

        assertThrows(Exception.class,
                () -> processadorBoletos.processaBoletos(this.boletos, this.fatura));
    }

    @Test
    @DisplayName("Processa boletos (xmin, yqualquer)")
    void testCase2() {
        this.fatura.setValorTotal(500);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 0));
        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 0));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertFalse(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos (xmin+, yqualquer)")
    void testCase3() {
        this.fatura.setValorTotal(500);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 1));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertFalse(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos (xmax-, yqualquer)")
    void testCase4() {
        this.fatura.setValorTotal(500);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 500));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertTrue(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos (xmax, yqualquer)")
    void testCase5() {
        this.fatura.setValorTotal(500);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 501));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertTrue(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos (xmax+, yqualquer)")
    void testCase6() {
        this.fatura.setValorTotal(500);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 502));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertTrue(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos (xqualquer, yqualquer)")
    void testCase7() {
        this.fatura.setValorTotal(1500);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 1500));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertTrue(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos (xqualquer, ymin-)")
    void testCase8() {
        this.fatura.setValorTotal(-1);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 100));
        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 100));

        assertThrows(Exception.class,
                () -> processadorBoletos.processaBoletos(this.boletos, this.fatura));
    }

    @Test
    @DisplayName("Processa boletos (xqualquer, ymin)")
    void testCase9() {
        this.fatura.setValorTotal(0);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertTrue(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos (xqualquer, ymin+)")
    void testCase10() {
        this.fatura.setValorTotal(1);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertTrue(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos (xqualquer, ymax-)")
    void testCase11() {
        this.fatura.setValorTotal(199);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertTrue(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos (xqualquer, ymax)")
    void testCase12() {
        this.fatura.setValorTotal(200);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertTrue(this.fatura.isPaga());
    }

    @Test
    @DisplayName("Processa boletos (xqualquer, ymax+)")
    void testCase13() {
        this.fatura.setValorTotal(201);

        this.boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200));

        processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertFalse(this.fatura.isPaga());
    }
}
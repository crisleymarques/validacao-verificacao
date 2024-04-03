package com.vev.junit5Tests.avl;

import com.vev.junit5Tests.interfaces.AvlTest;
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

    @Nested
    @DisplayName("Testes Avl de processamento de boletos")
    class ProcessamentoBoletosTests {

        @AvlTest
        @DisplayName("Processa boletos (xmin-, yqualquer)")
        void testCase1() {
            fatura.setValorTotal(500.0);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 0));
            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), -1));

            assertThrows(Exception.class,
                    () -> processadorBoletos.processaBoletos(boletos, fatura));
        }

        @AvlTest
        @DisplayName("Processa boletos (xmin, yqualquer)")
        void testCase2() {
            fatura.setValorTotal(500);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 0));
            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 0));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertFalse(fatura.isPaga());
        }

        @AvlTest
        @DisplayName("Processa boletos (xmin+, yqualquer)")
        void testCase3() {
            fatura.setValorTotal(500);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 1));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertFalse(fatura.isPaga());
        }

        @AvlTest
        @DisplayName("Processa boletos (xmax-, yqualquer)")
        void testCase4() {
            fatura.setValorTotal(500);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 500));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertTrue(fatura.isPaga());
        }

        @AvlTest
        @DisplayName("Processa boletos (xmax, yqualquer)")
        void testCase5() {
            fatura.setValorTotal(500);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 501));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertTrue(fatura.isPaga());
        }

        @AvlTest
        @DisplayName("Processa boletos (xmax+, yqualquer)")
        void testCase6() {
            fatura.setValorTotal(500);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 502));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertTrue(fatura.isPaga());
        }

        @AvlTest
        @DisplayName("Processa boletos (xqualquer, yqualquer)")
        void testCase7() {
            fatura.setValorTotal(1500);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 1500));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertTrue(fatura.isPaga());
        }

        @AvlTest
        @DisplayName("Processa boletos (xqualquer, ymin-)")
        void testCase8() {
            fatura.setValorTotal(-1);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 100));
            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 100));

            assertThrows(Exception.class,
                    () -> processadorBoletos.processaBoletos(boletos, fatura));
        }

        @AvlTest
        @DisplayName("Processa boletos (xqualquer, ymin)")
        void testCase9() {
            fatura.setValorTotal(0);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertTrue(fatura.isPaga());
        }

        @AvlTest
        @DisplayName("Processa boletos (xqualquer, ymin+)")
        void testCase10() {
            fatura.setValorTotal(1);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertTrue(fatura.isPaga());
        }

        @AvlTest
        @DisplayName("Processa boletos (xqualquer, ymax-)")
        void testCase11() {
            fatura.setValorTotal(199);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertTrue(fatura.isPaga());
        }

        @AvlTest
        @DisplayName("Processa boletos (xqualquer, ymax)")
        void testCase12() {
            fatura.setValorTotal(200);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertTrue(fatura.isPaga());
        }

        @AvlTest
        @DisplayName("Processa boletos (xqualquer, ymax+)")
        void testCase13() {
            fatura.setValorTotal(201);

            boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200));

            processadorBoletos.processaBoletos(boletos, fatura);

            assertFalse(fatura.isPaga());
        }
    }
}
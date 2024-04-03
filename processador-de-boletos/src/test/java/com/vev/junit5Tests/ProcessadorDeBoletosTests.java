package com.vev.junit5Tests;

import com.vev.junit5Tests.interfaces.FunctionalTest;
import com.vev.processadordeboletos.model.Boleto;
import com.vev.processadordeboletos.model.Fatura;
import com.vev.processadordeboletos.model.Pagamento;
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
class ProcessadorDeBoletosTests {
	private ProcessadorBoletos processadorBoletos;
	private Fatura fatura;
	private List<Boleto> boletos;

	@BeforeEach
	public void setUp() {
		this.processadorBoletos = new ProcessadorBoletos();
		this.boletos = new ArrayList<>();
		this.fatura = new Fatura(LocalDate.of(2024,1,1),0, "Fulano de Tal");
	}

	@FunctionalTest
	@DisplayName("Processa lista de boletos vazia")
	void testProcessaListaBoletosVazia() {
		List<Boleto> boletosVazio = new ArrayList<>();

		List<Pagamento> pagamentos = processadorBoletos.processaBoletos(boletosVazio, fatura);

		assertEquals(0, pagamentos.size());
	}

	@FunctionalTest
	@DisplayName("Processa boletos valor < total da fatura")
	void testProcessaListaBoletosMenorTotalFatura() {
		fatura.setValorTotal(1000.0);

		boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 100.0));
		boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 200.0));

		processadorBoletos.processaBoletos(boletos, fatura);

        assertFalse(fatura.isPaga());
	}

	@FunctionalTest
	@DisplayName("Processa boletos valor == total da fatura")
	void testProcessaListaBoletosIgualTotalFatura() {
		fatura.setValorTotal(1000.0);

		boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 500.0));
		boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 500.0));

		processadorBoletos.processaBoletos(boletos, fatura);

		assertTrue(fatura.isPaga());
	}

	@FunctionalTest
	@DisplayName("Processa boletos valor > total da fatura")
	void testProcessaListaBoletosMaiorTotalFatura() {
		fatura.setValorTotal(1000.0);

		boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 700.0));
		boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 5000.0));

		processadorBoletos.processaBoletos(boletos, fatura);

		assertTrue(fatura.isPaga());
	}

	@FunctionalTest
	@DisplayName("Verifica geração de pagamentos por boleto")
	void testVerificaGeracaoPagamentos() {
		fatura.setValorTotal(1000.0);

		boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 700.0));
		boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 5000.0));

		List<Pagamento> pagamentos = processadorBoletos.processaBoletos(boletos, fatura);

		assertEquals(boletos.size(), pagamentos.size());

		for (Pagamento p : pagamentos) {
			assertEquals(fatura.getId(), p.getIdFatura());
		}
	}
	
	@FunctionalTest
	@DisplayName("Valida comportamento esperado")
	void testValidaComportamentoEsperado() {
		fatura.setValorTotal(1500);

		boletos.add(new Boleto(LocalDate.of(2024, 3, 5), 500.0));
		boletos.add(new Boleto(LocalDate.of(2024, 3, 15), 400.0));
		boletos.add(new Boleto(LocalDate.of(2024, 3, 30), 600.0));

		List<Pagamento> pagamentos = processadorBoletos.processaBoletos(boletos, fatura);

		assertEquals(boletos.size(), pagamentos.size());
		assertTrue(fatura.isPaga());
	}
	
	@FunctionalTest
	@DisplayName("Processa boletos com valor nulo")
	void testProcessaBoletosNull() {
		fatura.setValorTotal(1500);

		boletos.add(null);
		boletos.add(null);
		boletos.add(new Boleto(LocalDate.of(2024, 3, 30), 600.0));

		List<Pagamento> pagamentos = processadorBoletos.processaBoletos(boletos, fatura);

		assertNotEquals(boletos.size(), pagamentos.size());
		assertFalse(fatura.isPaga());
	}
}

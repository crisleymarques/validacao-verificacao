package com.vev.processadordeboletos;

import com.vev.processadordeboletos.model.Boleto;
import com.vev.processadordeboletos.model.Fatura;
import com.vev.processadordeboletos.model.Pagamento;
import com.vev.processadordeboletos.model.ProcessadorBoletos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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

	@Test
	@DisplayName("Processa lista de boletos vazia")
	void testProcessaListaBoletosVazia() {
		List<Boleto> boletosVazio = new ArrayList<>();

		List<Pagamento> pagamentos = processadorBoletos.processaBoletos(boletosVazio, this.fatura);

		assertEquals(0, pagamentos.size());

	}

	@Test
	@DisplayName("Processa boletos valor < total da fatura")
	void testProcessaListaBoletosMenorTotalFatura() {
		this.fatura.setValorTotal(1000.0);

		Boleto boleto1 = new Boleto(LocalDate.of(2024, 3, 5), 100.0);
		Boleto boleto2 = new Boleto(LocalDate.of(2024, 3, 15), 200.0);

		this.boletos.add(boleto1);
		this.boletos.add(boleto2);

		processadorBoletos.processaBoletos(this.boletos, this.fatura);

        assertFalse(this.fatura.isPaga());
	}

	@Test
	@DisplayName("Processa boletos valor == total da fatura")
	void testProcessaListaBoletosIgualTotalFatura() {
		this.fatura.setValorTotal(1000.0);

		Boleto boleto1 = new Boleto(LocalDate.of(2024, 3, 5), 500.0);
		Boleto boleto2 = new Boleto(LocalDate.of(2024, 3, 15), 500.0);

		this.boletos.add(boleto1);
		this.boletos.add(boleto2);

		processadorBoletos.processaBoletos(this.boletos, this.fatura);

		assertFalse(this.fatura.isPaga());
	}

	@Test
	@DisplayName("Processa boletos valor > total da fatura")
	void testProcessaListaBoletosMaiorTotalFatura() {
		this.fatura.setValorTotal(1000.0);

		Boleto boleto1 = new Boleto(LocalDate.of(2024, 3, 5), 700.0);
		Boleto boleto2 = new Boleto(LocalDate.of(2024, 3, 15), 5000.0);

		this.boletos.add(boleto1);
		this.boletos.add(boleto2);

		processadorBoletos.processaBoletos(this.boletos, this.fatura);

		assertTrue(this.fatura.isPaga());
	}

	@Test
	@DisplayName("Verifica geração de pagamentos por boleto")
	void testVerificaGeracaoPagamentos() {
		this.fatura.setValorTotal(1000.0);

		Boleto boleto1 = new Boleto(LocalDate.of(2024, 3, 5), 700.0);
		Boleto boleto2 = new Boleto(LocalDate.of(2024, 3, 15), 5000.0);

		this.boletos.add(boleto1);
		this.boletos.add(boleto2);

		List<Pagamento> pagamentos = processadorBoletos.processaBoletos(this.boletos, this.fatura);

		assertEquals(this.boletos.size(), pagamentos.size());

		for (Pagamento p : pagamentos) {
			assertEquals(fatura.getId(), p.getIdFatura());
		}
	}
}

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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProcessadorDeBoletosTests {
	private ProcessadorBoletos processadorBoletos;
	private Fatura fatura;
	private List<Boleto> boletos;

	@BeforeEach
	public void setUp() {
		this.processadorBoletos = new ProcessadorBoletos();
		this.boletos = new ArrayList<>();
		this.fatura = new Fatura();
	}

	@Test
	@DisplayName("Processa lista de boletos vazia")
	void testRecebeListaBoletosVazia() {
		List<Boleto> boletosVazio = new ArrayList<>();

		List<Pagamento> pagamentos = processadorBoletos.processaBoletos(boletosVazio, this.fatura.getId());

		assertEquals(0, pagamentos.size());

	}

}

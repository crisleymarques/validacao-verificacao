package com.vev.processadordeboletos.model;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorBoletos {

    public List<Pagamento> processaBoletos(List<Boleto> boletos, Fatura fatura) {
        double soma = 0;
        for (Boleto b : boletos) {
            soma += b.getValorPago();
        }
        if (soma >= fatura.getValorTotal()) {
            fatura.setPaga(true);
        }
        return new ArrayList<>();
    }
}

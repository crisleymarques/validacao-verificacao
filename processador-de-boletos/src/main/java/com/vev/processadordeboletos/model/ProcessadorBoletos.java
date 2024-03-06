package com.vev.processadordeboletos.model;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorBoletos {

    public List<Pagamento> processaBoletos(List<Boleto> boletos, Fatura fatura) {
        List<Pagamento> pagamentoList = new ArrayList<>();
        double soma = 0;
        for (Boleto b : boletos) {
            soma += b.getValorPago();
            pagamentoList.add(new Pagamento(fatura.getId()));
        }
        if (soma > fatura.getValorTotal()) {
            fatura.setPaga(true);
        }
        return pagamentoList;
    }
}

package com.vev.processadordeboletos.model;

import java.util.ArrayList;
import java.util.List;

/** Um Procesador de Boletos deve verificar todos os boletos e,
 * caso o valor da soma de todos os boletos seja maior que o valor da fatura,
 * então essa fatura deverá ser considerada como paga.
 * @autor Crisley Marques
 * @since 05 mar 2024
 */
public class ProcessadorBoletos {

    public List<Pagamento> processaBoletos(List<Boleto> boletos, Fatura fatura) {
        List<Pagamento> pagamentoList = new ArrayList<>();
        double soma = 0;
        for (Boleto b : boletos) {
            if (b != null) {
                if (b.getValorPago() < 0 ) {
                    throw new IllegalArgumentException("Boleto não pode ter valor negativo!");
                }
                soma += b.getValorPago();
                pagamentoList.add(new Pagamento(b.getValorPago(),
                        b.getData(),
                        TipoPagamento.BOLETO,
                        fatura.getId()));
            }
        }
        if (fatura.getValorTotal() < 0) {
            throw new IllegalArgumentException("Valor Total não pode ser negativo!");
        }
        if (soma >= fatura.getValorTotal()) {
            fatura.setPaga(true);
        }
        return pagamentoList;
    }
}

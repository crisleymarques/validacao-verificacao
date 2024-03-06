package com.vev.processadordeboletos.model;

import java.util.UUID;

public class Pagamento {
    private String id;
    private String idFatura;

    public Pagamento(String idFatura) {
        this.id = UUID.randomUUID().toString();
        this.idFatura = idFatura;
    }

    public String getIdFatura() {
        return idFatura;
    }

    public void setIdFatura(String idFatura) {
        this.idFatura = idFatura;
    }
}

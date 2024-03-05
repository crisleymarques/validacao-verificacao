package com.vev.processadordeboletos.model;

import java.util.UUID;

public class Fatura {
    private String id;

    public Fatura() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }
}

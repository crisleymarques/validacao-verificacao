package com.vev.gerenciadordetarefas.model;

import java.time.LocalDate;

public class TarefasModel {

    private String title;
    private String description;
    private LocalDate date;

    public TarefasModel(String title, String description, LocalDate date) {
        if (title == null) {
            throw new IllegalArgumentException("Título não pode ser nulo!");
        }
        this.title = title;
        if (description == null) {
            throw new IllegalArgumentException("Descrição não pode ser nula!");
        }
        this.description = description;
        this.date = date;

    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getDate() {
        return this.date;
    }

}

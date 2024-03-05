package com.vev.gerenciadordetarefas.model;

import java.time.LocalDate;

public class TarefasModel {

    private String title;
    private String description;
    private LocalDate date;
    private Priority priority;

    public TarefasModel(String title, String description, LocalDate date, Priority priority) {
        if (title == null) {
            throw new IllegalArgumentException("Título não pode ser nulo!");
        }
        this.title = title;
        if (description == null) {
            throw new IllegalArgumentException("Descrição não pode ser nula!");
        }
        this.description = description;
        if (date == null) {
            throw new IllegalArgumentException("Data de vencimento não pode ser nula!");
        }
        this.date = date;
        this.priority = priority;

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

    public Priority getPriority() {
        return this.priority;
    }

}

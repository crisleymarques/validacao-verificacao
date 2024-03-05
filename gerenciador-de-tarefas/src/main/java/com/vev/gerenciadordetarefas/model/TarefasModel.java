package com.vev.gerenciadordetarefas.model;

public class TarefasModel {

    private String title;
    private String description;

    public TarefasModel(String title, String description) {
        if (title == null) {
            throw new IllegalArgumentException("Título não pode ser nulo!");
        }
        this.title = title;
        if (description == null) {
            throw new IllegalArgumentException("Descrição não pode ser nula!");
        }
        this.description = description;

    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

}

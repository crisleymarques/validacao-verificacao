package com.vev.gerenciadordetarefas.model;

public class TarefasModel {

    private String title;

    public TarefasModel(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Título não pode ser nulo!");
        }
        this.title = title;

    }

    public String getTitle() {
        return this.title;
    }

}

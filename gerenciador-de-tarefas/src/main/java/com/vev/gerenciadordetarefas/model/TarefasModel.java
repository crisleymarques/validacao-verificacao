package com.vev.gerenciadordetarefas.model;

import java.time.LocalDate;

public class TarefasModel implements Comparable<TarefasModel> {

    private int id;

    private String title;
    private String description;
    private LocalDate date;
    private Priority priority;

    public TarefasModel() {
    }

    public TarefasModel(int id, String title, String description, LocalDate date, Priority priority) {
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
        if (priority == null) {
            throw new IllegalArgumentException("Prioridade não pode ser nula!");
        }
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

    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "Título=" + this.getTitle() +
                ", Descrição=" + this.getDescription() +
                ", Data=" + this.getDate() +
                ", Prioridade=" + this.getPriority() + '\'' +
                '}';
    }

    public int compareTo(TarefasModel o) {
        return this.getDate().compareTo(o.getDate());
    }

}

package com.vev.gerenciadordetarefas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class TarefasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;
    private String description;
    private LocalDate date;
    private Priority priority;

    public TarefasModel() {
    }

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

    public Long getId() {
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

}

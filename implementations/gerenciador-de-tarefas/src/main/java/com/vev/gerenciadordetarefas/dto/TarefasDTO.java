package com.vev.gerenciadordetarefas.dto;

import java.time.LocalDate;
import com.vev.gerenciadordetarefas.model.Priority;
public class TarefasDTO {

    private String title;
    private String description;
    private LocalDate date;
    private Priority priority;

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

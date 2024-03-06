package com.vev.gerenciadordetarefas.service;

import com.vev.gerenciadordetarefas.model.Priority;

import java.time.LocalDate;

public interface TarefasService {

    public int addTask(String titulo, String descricao, LocalDate data, Priority prioridade);

    public int size();

    public void showTasksByDate();
    public void showTasksByPriority();
    public void editTask(int id, String titulo, String descricao, LocalDate data, Priority prioridade);
    public void removeTask(int id);
}

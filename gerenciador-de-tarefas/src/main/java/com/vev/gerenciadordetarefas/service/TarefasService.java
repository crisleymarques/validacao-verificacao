package com.vev.gerenciadordetarefas.service;

import com.vev.gerenciadordetarefas.model.Priority;

import java.time.LocalDate;

public interface TarefasService {

    public void addTask(String titulo, String descricao, LocalDate data, Priority prioridade);

    public int size();

    public void showTasksByOrder();
}

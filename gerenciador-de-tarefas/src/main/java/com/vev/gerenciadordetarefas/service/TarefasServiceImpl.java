package com.vev.gerenciadordetarefas.service;

import com.vev.gerenciadordetarefas.model.Priority;
import com.vev.gerenciadordetarefas.model.TarefasModel;

import java.time.LocalDate;
import java.util.ArrayList;

public class TarefasServiceImpl implements TarefasService {

    private ArrayList<TarefasModel> tarefas;

    public TarefasServiceImpl() {
        this.tarefas = new ArrayList<TarefasModel>();
    }

    public void addTask(String titulo, String descricao, LocalDate data, Priority prioridade) {
        TarefasModel tarefa = new TarefasModel(titulo, descricao, data, prioridade);
        this.tarefas.add(tarefa);
    }

    public void showTasksByOrder() {
        for (TarefasModel tarefa : this.tarefas) {
            System.out.println(tarefa.toString());
        }
    }

    public int size() {
        return this.tarefas.size();
    }

}

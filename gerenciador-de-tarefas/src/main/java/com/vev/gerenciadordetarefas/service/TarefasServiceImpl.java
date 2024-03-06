package com.vev.gerenciadordetarefas.service;

import com.vev.gerenciadordetarefas.model.Priority;
import com.vev.gerenciadordetarefas.model.TarefasModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class TarefasServiceImpl implements TarefasService {

    private ArrayList<TarefasModel> tarefas;
    private int id = 0;

    public TarefasServiceImpl() {
        this.tarefas = new ArrayList<TarefasModel>();
    }

    public int addTask(String titulo, String descricao, LocalDate data, Priority prioridade) {
        TarefasModel tarefa = new TarefasModel(id, titulo, descricao, data, prioridade);
        this.tarefas.add(tarefa);
        id++;
        return id - 1;
    }

    public void showTasksByDate() {
        Collections.sort(this.tarefas);
        for (TarefasModel tarefa : this.tarefas) {
            System.out.println(tarefa.toString());
        }
    }

    public void showTasksByPriority() {
        ArrayList<TarefasModel> tarefasAltas = new ArrayList<TarefasModel>();
        ArrayList<TarefasModel> tarefasMedias = new ArrayList<TarefasModel>();
        ArrayList<TarefasModel> tarefasBaixas = new ArrayList<TarefasModel>();
        for (TarefasModel tarefa : this.tarefas) {
            if (tarefa.getPriority() == Priority.values()[0]) {
                tarefasAltas.add(tarefa);
            } else if (tarefa.getPriority() == Priority.values()[1]) {
                tarefasMedias.add(tarefa);
            } else {
                tarefasBaixas.add(tarefa);
            }
        }

        for (TarefasModel tarefa : tarefasAltas) {
            System.out.println(tarefa.toString());
        }

        for (TarefasModel tarefa : tarefasMedias) {
            System.out.println(tarefa.toString());
        }

        for (TarefasModel tarefa : tarefasBaixas) {
            System.out.println(tarefa.toString());
        }
    }

    public void editTask(int id, String titulo, String descricao, LocalDate data, Priority prioridade) {
        TarefasModel tarefa = this.tarefas.get(id);
        tarefa.setTitle(titulo);
        tarefa.setDescription(descricao);
        tarefa.setDate(data);
        tarefa.setPriority(prioridade);
    }

    public void removeTask(int id) {
        for (TarefasModel tarefa : this.tarefas) {
            if (tarefa.getId() == id) {
                this.tarefas.remove(tarefa);
                break;
            }
        }
    }

    public int size() {
        return this.tarefas.size();
    }

}

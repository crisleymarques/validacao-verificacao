package com.vev.gerenciadordetarefas.service;

import com.vev.gerenciadordetarefas.model.Priority;
import com.vev.gerenciadordetarefas.model.TarefasModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class TarefasServiceImpl implements TarefasService {

    private ArrayList<TarefasModel> tarefas;
    private AtomicInteger id = new AtomicInteger(0);

    public TarefasServiceImpl() {
        this.tarefas = new ArrayList<TarefasModel>();
    }

    public int addTask(String titulo, String descricao, LocalDate data, Priority prioridade) {
        TarefasModel tarefa = new TarefasModel(id.getAndIncrement(), titulo, descricao, data, prioridade);
        this.tarefas.add(tarefa);
        return id.get() - 1;
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
        boolean found = false;
        for (TarefasModel tarefa : this.tarefas) {
            if (tarefa.getId() == id) {
                this.tarefas.remove(tarefa);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new IllegalArgumentException("Tarefa não encontrada!");
        }
    }

    public TarefasModel getTask(int id) {
        for (TarefasModel tarefa : this.tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        throw new IllegalArgumentException("Tarefa não encontrada!");
    }

    public int size() {
        return this.tarefas.size();
    }

}

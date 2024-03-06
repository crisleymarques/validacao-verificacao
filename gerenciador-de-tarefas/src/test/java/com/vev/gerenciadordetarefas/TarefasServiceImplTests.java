package com.vev.gerenciadordetarefas;

import com.vev.gerenciadordetarefas.model.Priority;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vev.gerenciadordetarefas.service.TarefasServiceImpl;

import java.time.LocalDate;
import java.time.Month;

@RunWith(Suite.class)
@SuiteClasses({})
public class TarefasServiceImplTests {

    private TarefasServiceImpl tarefasService;

    @BeforeEach
    public void startModel() {
        this.tarefasService = new TarefasServiceImpl();
    }

    @Test
    public void testAddTask() {
        tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.now(), Priority.values()[0]);
        assertEquals(1, tarefasService.size());
    }
}

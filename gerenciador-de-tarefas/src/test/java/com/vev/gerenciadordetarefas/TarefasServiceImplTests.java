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

    @Test
    public void testShowTasksByOrder() {
        tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.now(), Priority.values()[0]);
        tarefasService.addTask("Quiz de Percepção", "Responder quiz da aula 8", LocalDate.now(), Priority.values()[1]);
        tarefasService.showTasksByDate();
    }

    @Test
    public void testShowTasksByDate() {
        tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, Month.MARCH, 8), Priority.values()[0]);
        tarefasService.addTask("Quiz de Percepção", "Responder quiz da aula 8", LocalDate.of(2024, Month.MARCH, 2), Priority.values()[1]);
        tarefasService.addTask("Quiz de Tc", "Responder quiz da aula 7", LocalDate.of(2024, Month.MARCH, 10), Priority.values()[2]);
        tarefasService.showTasksByDate();
    }

    @Test
    public void testShowTasksByPriority() {
        tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, Month.MARCH, 8), Priority.values()[2]);
        tarefasService.addTask("Quiz de Percepção", "Responder quiz da aula 8", LocalDate.of(2024, Month.MARCH, 2), Priority.values()[0]);
        tarefasService.addTask("Quiz de Tc", "Responder quiz da aula 7", LocalDate.of(2024, Month.MARCH, 10), Priority.values()[1]);
        tarefasService.showTasksByPriority();
    }

    @Test
    public void testEditTask() {
        tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, Month.MARCH, 8), Priority.values()[2]);
        tarefasService.editTask(0, "Quiz de Percepção", "Responder quiz da aula 6", LocalDate.of(2024, Month.MARCH, 8), Priority.values()[0]);
        tarefasService.showTasksByPriority();
    }
}

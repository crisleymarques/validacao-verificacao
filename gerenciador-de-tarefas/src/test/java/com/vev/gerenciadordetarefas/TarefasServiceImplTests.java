package com.vev.gerenciadordetarefas;

import com.vev.gerenciadordetarefas.model.Priority;
import com.vev.gerenciadordetarefas.model.TarefasModel;
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
        int id = tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.now(), Priority.values()[0]);
        assertEquals(1, tarefasService.size());
    }

    @Test
    public void testShowTasksByOrder() {
        int id1 = tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.now(), Priority.values()[0]);
        int id2 = tarefasService.addTask("Quiz de Percepção", "Responder quiz da aula 8", LocalDate.now(), Priority.values()[1]);
        tarefasService.showTasksByDate();
    }

    @Test
    public void testShowTasksByDate() {
        int id1 = tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, Month.MARCH, 8), Priority.values()[0]);
        int id2 = tarefasService.addTask("Quiz de Percepção", "Responder quiz da aula 8", LocalDate.of(2024, Month.MARCH, 2), Priority.values()[1]);
        int id3 = tarefasService.addTask("Quiz de Tc", "Responder quiz da aula 7", LocalDate.of(2024, Month.MARCH, 10), Priority.values()[2]);
        tarefasService.showTasksByDate();
    }

    @Test
    public void testShowTasksByPriority() {
        int id1 = tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, Month.MARCH, 8), Priority.values()[2]);
        int id2 = tarefasService.addTask("Quiz de Percepção", "Responder quiz da aula 8", LocalDate.of(2024, Month.MARCH, 2), Priority.values()[0]);
        int id3 = tarefasService.addTask("Quiz de Tc", "Responder quiz da aula 7", LocalDate.of(2024, Month.MARCH, 10), Priority.values()[1]);
        tarefasService.showTasksByPriority();
    }

    @Test
    public void testEditTask() {
        int id = tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, Month.MARCH, 8), Priority.values()[2]);
        tarefasService.editTask(id, "Quiz de Percepção", "Responder quiz da aula 6", LocalDate.of(2024, Month.MARCH, 8), Priority.values()[0]);
        tarefasService.showTasksByPriority();
    }

    @Test
    public void testRemoveTask() {
        int id = tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, Month.MARCH, 8), Priority.values()[2]);
        tarefasService.removeTask(id);
        assertEquals(0, tarefasService.size());
    }

    @Test
    public void testRemoveTaskException() {
        int id = tarefasService.addTask("Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, Month.MARCH, 8), Priority.values()[2]);

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> tarefasService.removeTask(10));
        assertEquals("Tarefa não encontrada!", thrown.getMessage());

        assertEquals(1, tarefasService.size());
    }
}

package com.vev.gerenciadordetarefas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vev.gerenciadordetarefas.model.*;

import java.time.LocalDate;

@RunWith(Suite.class)
@SuiteClasses({})
public class TarefasModelTests {

    private TarefasModel tarefasModel;

    @BeforeEach
    public void startModel() {
        this.tarefasModel = new TarefasModel("Quiz de VeV", "Responder quiz da aula 6", LocalDate.now(), Priority.values()[0]);
    }

    @Test
    public void testGetTitle() {
        assertEquals("Quiz de VeV", tarefasModel.getTitle());
    }

    @Test
    public void testGetNullTitle() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TarefasModel(null, "Responder quiz da aula 6", LocalDate.now(), Priority.values()[0]));
        assertEquals("Título não pode ser nulo!", thrown.getMessage());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Responder quiz da aula 6", tarefasModel.getDescription());
    }

    @Test
    public void testGetNullDescription() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TarefasModel("Quiz de VeV", null, LocalDate.now(), Priority.values()[0]));
        assertEquals("Descrição não pode ser nula!", thrown.getMessage());
    }

    @Test
    public void testGetDate() {
        assertEquals(LocalDate.now(), tarefasModel.getDate());
    }

    @Test
    public void testGetNullDate() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TarefasModel("Quiz de VeV", "Responder quiz da aula 6", null, Priority.values()[0]));
        assertEquals("Data de vencimento não pode ser nula!", thrown.getMessage());
    }

    @Test
    public void testGetPriority() {
        Priority result = Enum.valueOf(Priority.class, "Alta");
        assertEquals(result, tarefasModel.getPriority());
    }

    @Test
    public void testGetNullPriority() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TarefasModel("Quiz de VeV", "Responder quiz da aula 6", LocalDate.now(), null));
        assertEquals("Prioridade não pode ser nula!", thrown.getMessage());
    }

    @Test
    public void testSetTitle() {
        tarefasModel.setTitle("Quiz de percepção computacional");
        assertEquals("Quiz de percepção computacional", tarefasModel.getTitle());
    }

}

package com.vev.gerenciadordetarefas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vev.gerenciadordetarefas.model.*;

import java.time.LocalDate;
import java.time.Month;

@RunWith(Suite.class)
@SuiteClasses({})
public class TarefasModelTests {

    private TarefasModel tarefasModel;

    @BeforeEach
    public void startModel() {
        this.tarefasModel = new TarefasModel(0,"Quiz de VeV", "Responder quiz da aula 6", LocalDate.now(), Priority.values()[0]);
    }

    @Test
    public void testGetTitle() {
        assertEquals("Quiz de VeV", tarefasModel.getTitle());
    }

    @Test
    public void testGetNullTitle() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TarefasModel(1, null, "Responder quiz da aula 6", LocalDate.now(), Priority.values()[0]));
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
                () -> new TarefasModel(2, "Quiz de VeV", null, LocalDate.now(), Priority.values()[0]));
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
                () -> new TarefasModel(3, "Quiz de VeV", "Responder quiz da aula 6", null, Priority.values()[0]));
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
                () -> new TarefasModel(4, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.now(), null));
        assertEquals("Prioridade não pode ser nula!", thrown.getMessage());
    }

    @Test
    public void testSetTitle() {
        tarefasModel.setTitle("Quiz de percepção computacional");
        assertEquals("Quiz de percepção computacional", tarefasModel.getTitle());
    }

    @Test
    public void testSetDescription() {
        tarefasModel.setDescription("Responder quiz da aula 7");
        assertEquals("Responder quiz da aula 7", tarefasModel.getDescription());
    }

    @Test
    public void testSetDate() {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 8);
        tarefasModel.setDate(date);
        assertEquals(date, tarefasModel.getDate());
    }

    @Test
    public void testSetPriority() {
        Priority priority = Enum.valueOf(Priority.class, "Baixa");
        tarefasModel.setPriority(priority);
        assertEquals(priority, tarefasModel.getPriority());
    }

}

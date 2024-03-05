package com.vev.gerenciadordetarefas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.vev.gerenciadordetarefas.model.TarefasModel;

@RunWith(Suite.class)
@SuiteClasses({})
public class TarefasModelTests {

    private TarefasModel tarefasModel;

    @BeforeEach
    public void startModel() {
        this.tarefasModel = new TarefasModel("Quiz de VeV", "Responder quiz da aula 6");
    }

    @Test
    public void testGetTitle() {
        assertEquals("Quiz de VeV", tarefasModel.getTitle());
    }

    @Test
    public void testGetNullTitle() {
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new TarefasModel(null, "Responder quiz da aula 6"));
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
                () -> new TarefasModel("Quiz de VeV", null));
        assertEquals("Descrição não pode ser nula!", thrown.getMessage());
    }

}

package com.vev.gerenciadordetarefas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vev.gerenciadordetarefas.model.TarefasModel;

@RunWith(Suite.class)
@SuiteClasses({})
public class TarefasModelTests {

    private TarefasModel tarefasModel;

    @BeforeEach
    public void startModel() {
        this.tarefasModel = new TarefasModel("Quiz de VeV");
    }

    @Test
    public void testGetTitle() {
        assertEquals("Quiz de VeV", tarefasModel.getTitle());
    }

}

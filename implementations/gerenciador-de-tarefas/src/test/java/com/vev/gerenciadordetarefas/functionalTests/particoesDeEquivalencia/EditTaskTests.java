package com.vev.gerenciadordetarefas.functionalTests.particoesDeEquivalencia;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vev.gerenciadordetarefas.model.Priority;
import com.vev.gerenciadordetarefas.service.TarefasServiceImpl;

public class EditTaskTests {

    private TarefasServiceImpl tarefasService;
    private int id;

    @BeforeEach
    public void startModel() {
        this.tarefasService = new TarefasServiceImpl();
        int id = tarefasService.addTask( "Quiz de VeV", "Responder quiz da aula 6", LocalDate.now(), Priority.values()[0]);
        this.id = id;
    }

    @Test
    public void test01() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 0, -1), Priority.values()[0]));
    }

    @Test
    public void test02() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 0, 13), Priority.values()[0]));
    }

    @Test
    public void test03() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 0, 29), Priority.values()[0]));
    }

    @Test
    public void test04() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 0, 30), Priority.values()[0]));
    }

    @Test
    public void test05() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 0, 31), Priority.values()[0]));
    }

    @Test
    public void test06() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 0, 32), Priority.values()[0]));
    }

    @Test
    public void test07() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 0, -1), Priority.values()[0]));
    }

    @Test
    public void test08() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 0, 13), Priority.values()[0]));
    }

    @Test
    public void test09() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 0, 29), Priority.values()[0]));
    }

    @Test
    public void test10() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 0, 30), Priority.values()[0]));
    }

    @Test
    public void test11() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 0, 31), Priority.values()[0]));
    }

    @Test
    public void test12() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 0, 32), Priority.values()[0]));
    }

    @Test
    public void test13() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 4, -1), Priority.values()[0]));
    }

    @Test
    public void test14() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 4, 13), Priority.values()[0]);

    }

    @Test
    public void test15() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 4, 29), Priority.values()[0]);
    }

    @Test
    public void test16() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 4, 30), Priority.values()[0]);
    }

    @Test
    public void test17() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 4, 31), Priority.values()[0]));
    }

    @Test
    public void test18() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 4, 32), Priority.values()[0]));
    }

    @Test
    public void test19() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 4, -1), Priority.values()[0]));
    }

    @Test
    public void test20() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 4, 13), Priority.values()[0]);
    }

    @Test
    public void test21() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 4, 29), Priority.values()[0]);
    }

    @Test
    public void test22() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 4, 30), Priority.values()[0]);
    }

    @Test
    public void test23() { 
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 4, 31), Priority.values()[0]));
    }

    @Test
    public void test24() { 
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 4, 32), Priority.values()[0]));
    }

    @Test
    public void test25() { 
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 3, -1), Priority.values()[0]));
    }

    @Test
    public void test26() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 3, 13), Priority.values()[0]);
    }

    @Test
    public void test27() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 3, 29), Priority.values()[0]);
    }

    @Test
    public void test28() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 3, 30), Priority.values()[0]);
    }

    @Test
    public void test29() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 3, 31), Priority.values()[0]);
    }

    @Test
    public void test30() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 3, 32), Priority.values()[0]));
    }

    @Test
    public void test31() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 3, -1), Priority.values()[0]));
    }

    @Test
    public void test32() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 3, 13), Priority.values()[0]);
    }

    @Test
    public void test33() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 3, 29), Priority.values()[0]);
    }

    @Test
    public void test34() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 3, 30), Priority.values()[0]);
    }

    @Test
    public void test35() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 3, 31), Priority.values()[0]);
    }

    @Test
    public void test36() { 
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 3, 32), Priority.values()[0]));
    }

    @Test
    public void test37() { 
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 2, -1), Priority.values()[0]));
    }

    @Test
    public void test38() {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 2, 13), Priority.values()[0]);
    }

    @Test
    public void test39() { 
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 2, 29), Priority.values()[0]);
    }

    @Test
    public void test40() { 
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 2, 30), Priority.values()[0]));
    }

    @Test
    public void test41() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 2, 31), Priority.values()[0]));
    }

    @Test
    public void test42() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 2, 32), Priority.values()[0]));
    }

    @Test
    public void test43() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 2, -1), Priority.values()[0]));
    }

    @Test
    public void test44() { 
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 2, 13), Priority.values()[0]);
    }

    @Test
    public void test45() { 
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 2, 29), Priority.values()[0]));
    }

    @Test
    public void test46() { 
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 2, 30), Priority.values()[0]));
    }

    @Test
    public void test47() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 2, 31), Priority.values()[0]));
    }

    @Test
    public void test48() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 2, 32), Priority.values()[0]));
    }

    @Test
    public void test49() { 
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 13, -1), Priority.values()[0]));
    }

    @Test
    public void test50() {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 13, 13), Priority.values()[0]));
    }

    @Test
    public void test51() {
        assertThrows(
            java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 13, 29), Priority.values()[0]));
    }

    @Test
    public void test52() {
        assertThrows(
            java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 13, 30), Priority.values()[0]));
    }

    @Test
    public void test53() {
        assertThrows(
            java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 13, 31), Priority.values()[0]));
    }

    @Test
    public void test54() {
        assertThrows(
            java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 13, 32), Priority.values()[0]));
    }
    

    @Test
    public void test55() {
        assertThrows(
            java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 13, -1), Priority.values()[0]));
    }
    

    @Test
    public void test56() {
        assertThrows(
            java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 13, 13), Priority.values()[0]));
    }

    @Test
    public void test57() {
        assertThrows(
            java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 13, 29), Priority.values()[0]));
    }

    @Test
    public void test58() {
        assertThrows(
            java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 13, 30), Priority.values()[0]));
    }

    @Test
    public void test59() {
        assertThrows(
            java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 13, 31), Priority.values()[0]));
    }

    @Test
    public void test60() {
        assertThrows(
            java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 13, 32), Priority.values()[0]));
    }
}




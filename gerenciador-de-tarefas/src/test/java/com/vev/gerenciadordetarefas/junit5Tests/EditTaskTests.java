package com.vev.gerenciadordetarefas.junit5Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.vev.gerenciadordetarefas.model.Priority;
import com.vev.gerenciadordetarefas.service.TarefasServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class EditTaskTests {

    private TarefasServiceImpl tarefasService;
    private int id;

    @BeforeEach
    public void startModel() {
        this.tarefasService = new TarefasServiceImpl();
        int id = tarefasService.addTask( "Quiz de VeV", "Responder quiz da aula 6", LocalDate.now(), Priority.values()[0]);
        this.id = id;
    }

    @InvalidDateTest
    @ParameterizedTest
    @ValueSource(ints = {-1, 13, 29, 30, 31, 32})
    public void test01(int day) {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 0, day), Priority.values()[0]));
    }

    @InvalidDateTest
    @ParameterizedTest
    @ValueSource(ints = {-1, 13, 29, 30, 31, 32})
    public void test02(int day) {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 0, day), Priority.values()[0]));
    }

    @InvalidDateTest
    @ParameterizedTest
    @ValueSource(ints = {-1, 13, 29, 30, 31, 32})
    public void test03(int day) {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 13, day), Priority.values()[0]));
    }

    @InvalidDateTest
    @ParameterizedTest
    @ValueSource(ints = {-1, 13, 29, 30, 31, 32})
    public void test04(int day) {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 13, day), Priority.values()[0]));
    }

    @InvalidDateTest
    @ParameterizedTest
    @ValueSource(ints = {-1, 31, 32})
    public void test05(int day) {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 4, day), Priority.values()[0]));
    }

    @ValidDateTest
    @ParameterizedTest
    @ValueSource(ints = {13, 29, 30})
    public void test06(int day) {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 4, day), Priority.values()[0]);
        assertEquals(LocalDate.of(2024, 4, day), tarefasService.getTask(id).getDate());
    }

    @InvalidDateTest
    @ParameterizedTest
    @ValueSource(ints = {-1, 31, 32})
    public void test07(int day) {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 4, day), Priority.values()[0]));
    }

    @ValidDateTest
    @ParameterizedTest
    @ValueSource(ints = {13, 29, 30})
    public void test08(int day) {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 4, day), Priority.values()[0]);
        assertEquals(LocalDate.of(2023, 4, day), tarefasService.getTask(id).getDate());
    }

    @InvalidDateTest
    @ParameterizedTest
    @ValueSource(ints = {-1, 32})
    public void test09(int day) {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 3, day), Priority.values()[0]));
    }

    @ValidDateTest
    @ParameterizedTest
    @ValueSource(ints = {13, 29, 30, 31})
    public void test10(int day) {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 3, day), Priority.values()[0]);
        assertEquals(LocalDate.of(2024, 3, day), tarefasService.getTask(id).getDate());
    }

    @InvalidDateTest
    @ParameterizedTest
    @ValueSource(ints = {-1, 32})
    public void test11(int day) {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 3, day), Priority.values()[0]));
    }

    @ValidDateTest
    @ParameterizedTest
    @ValueSource(ints = {13, 29, 30, 31})
    public void test12(int day) {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 3, day), Priority.values()[0]);
        assertEquals(LocalDate.of(2023, 3, day), tarefasService.getTask(id).getDate());
    }

    @InvalidDateTest
    @ParameterizedTest
    @ValueSource(ints = {-1, 30, 31, 32})
    public void test13(int day) {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 2, day), Priority.values()[0]));
    }

    @ValidDateTest
    @ParameterizedTest
    @ValueSource(ints = {13, 29})
    public void test14(int day) {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2024, 2, day), Priority.values()[0]);
        assertEquals(LocalDate.of(2024, 2, day), tarefasService.getTask(id).getDate());
    }

    @InvalidDateTest
    @ParameterizedTest
    @ValueSource(ints = {-1, 29, 30, 31, 32})
    public void test15(int day) {
        assertThrows(java.time.DateTimeException.class,
                () -> tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 2, day), Priority.values()[0]));
    }

    @ValidDateTest
    @ParameterizedTest
    @ValueSource(ints = {13})
    public void test16(int day) {
        tarefasService.editTask(id, "Quiz de VeV", "Responder quiz da aula 6", LocalDate.of(2023, 2, day), Priority.values()[0]);
        assertEquals(LocalDate.of(2023, 2, day), tarefasService.getTask(id).getDate());
    }
}

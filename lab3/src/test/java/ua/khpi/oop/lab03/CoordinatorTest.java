package ua.khpi.oop.lab03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatorTest {

    @Test
    @DisplayName("Створення нового проекту координатором")
    void testCoordinatorCreatesProject() {
        Coordinator coordinator = new Coordinator("C-10", "Анна");
        Project newProject = coordinator.createProject("P-99", "Новий збір");

        assertNotNull(newProject, "Проект не null"); 
        assertTrue(newProject.result().contains("Активний"), "Новий проект повинен активним");
    }

    @Test
    @DisplayName("Координатори з однаковим ID є рівними")
    void testEqualsForSameId() {
        Coordinator coord1 = new Coordinator("C-01", "Іван");
        Coordinator coord2 = new Coordinator("C-01", "Петро"); 
        assertEquals(coord1, coord2, "Координатори з однаковим ID повинні вважатися однаковими");
    }

    @Test
    @DisplayName("Координатори з різними ID є різними")
    void testNotEqualsForDifferentId() {
        Coordinator coord1 = new Coordinator("C-01", "Іван");
        Coordinator coord2 = new Coordinator("C-02", "Іван"); 
        assertNotEquals(coord1, coord2, "Координатори з різними ID не повинні бути рівними"); 
    }
}
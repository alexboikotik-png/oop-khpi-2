package ua.khpi.oop.lab03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    private Project project;
    private Volunteer volunteer;

    @BeforeEach
    void setUp() {
        project = new Project("P-01", "Еко проект", true);
        volunteer = new Volunteer("V-01", "Олег");
    }

    @Test
    @DisplayName("Чи додається волонтер до активного проекту")
    void testAddVolunteerToActiveProject() {
        project.addVolunteer(volunteer);
        assertTrue(project.result().contains("Кількість волонтерів: 1"));
    }

    @Test
    @DisplayName("Чи змінюється статус після завершення")
    void testCompleteProjectChangesStatus() {
        project.complete();
        assertTrue(project.result().contains("Завершений"), "Статус має змінитися на Завершений");
    }

    @Test
    @DisplayName("Чи заборонено додавати волонтера у закритий проект")
    void testCannotAddVolunteerToCompletedProject() {
        project.complete(); 
        project.addVolunteer(volunteer); 
        assertTrue(project.result().contains("Кількість волонтерів: 0"),  "Список волонтерів має залишитися порожнім для закритого проекту");
    }
}
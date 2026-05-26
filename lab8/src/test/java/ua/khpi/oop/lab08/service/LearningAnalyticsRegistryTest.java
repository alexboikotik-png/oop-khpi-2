package ua.khpi.oop.lab08.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab08.model.AnalyticsRecord;
import ua.khpi.oop.lab08.model.GradeSnapshot;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LearningAnalyticsRegistryTest {

    private LearningAnalyticsRegistry registry;

    @BeforeEach
    void setUp() {
        registry = new LearningAnalyticsRegistry();
    }

    @Test
    void test_Add_And_Retrieve_Record() {
        GradeSnapshot snapshot = new GradeSnapshot("ID100", LocalDate.now(), "Math", 95);
        registry.addRecord(snapshot);
        assertEquals(1, registry.Records().size(), "Реєстр повинен містити 1 запис");
        assertEquals("ID-100", registry.Records().get(0).StudentId(), "ID студента має збігатися");
    }

    @Test
    void test_Find_Student_Id_Success() {
        registry.addRecord(new GradeSnapshot("ID200", LocalDate.now(), "Physics", 88));
        
        Optional<AnalyticsRecord> found = registry.findStudentId("ID200");
        
        assertTrue(found.isPresent(), "Запис має бути знайдений");
        assertEquals("ID200", found.get().StudentId());
    }

    @Test
    void test_Find_Student_Id_Not_Found() {
        Optional<AnalyticsRecord> found = registry.findStudentId("Не існує");
        
        assertFalse(found.isPresent());
    }
}
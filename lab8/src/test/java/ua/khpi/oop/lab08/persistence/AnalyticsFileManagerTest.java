package ua.khpi.oop.lab08.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import ua.khpi.oop.lab08.exception.InvalidAnalyticsDataException;
import ua.khpi.oop.lab08.model.GradeSnapshot;
import ua.khpi.oop.lab08.service.LearningAnalyticsRegistry;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AnalyticsFileManagerTest {

    private AnalyticsFileManager fileManager;
    private LearningAnalyticsRegistry registry;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        fileManager = new AnalyticsFileManager();
        registry = new LearningAnalyticsRegistry();
        registry.addRecord(new GradeSnapshot("ID001", LocalDate.parse("2026-05-22"), "Java", 95));
    }

    @Test
    void test_Save_And_Load_Text_File() throws Exception {
        Path textFile = tempDir.resolve("test_data.txt");

        fileManager.saveAsText(registry, textFile);
        LearningAnalyticsRegistry loadedRegistry = fileManager.loadFromText(textFile);


        assertTrue(Files.exists(textFile), "Файл має на диску");
        assertEquals(1, loadedRegistry.Records().size(), "Має бути відновлено запис");
        assertEquals("ID-001", loadedRegistry.Records().get(0).StudentId());
    }

    @Test
    void test_Serialize_And_Deserialize_Binary_File() throws Exception {
        Path binFile = tempDir.resolve("test_data.bin");
        fileManager.serialize(registry, binFile);
        LearningAnalyticsRegistry loadedRegistry = fileManager.deserialize(binFile);

        assertTrue(Files.exists(binFile));
        assertEquals(1, loadedRegistry.Records().size());
        assertEquals("ID-001", loadedRegistry.Records().get(0).StudentId());
    }

    @Test
    void test_Load_Text_Exception_Invalid_Data() throws Exception {
        Path badFile = tempDir.resolve("bad_data.txt");
        String badContent = "Оцінка  ID002  2026-05-22  Math  150\n";
        Files.writeString(badFile, badContent);
        InvalidAnalyticsDataException thrown = assertThrows(
                InvalidAnalyticsDataException.class,
                () -> fileManager.loadFromText(badFile),
                "Має викидатися виняток предметної області при некоректній оцінці"
        );
        
        assertTrue(thrown.getMessage().contains("Оцінка поза межами"),
                "Повідомлення про помилку повинна мати інформацію");
    }
}
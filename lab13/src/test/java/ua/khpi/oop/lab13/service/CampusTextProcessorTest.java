package ua.khpi.oop.lab13.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab13.model.CampusRecord;
import ua.khpi.oop.lab13.model.RecordType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CampusTextProcessorTest {

    private CampusTextProcessor processor;
    private ReportGenerator reportGenerator;

    @BeforeEach
    void setUp() {
        processor = new CampusTextProcessor();
        reportGenerator = new ReportGenerator();
    }

    @Test
    void  test_Parse_Valid_Record() {
        List<String> input = List.of("BKG-123 . BOOKING . Зустріч в 15:45 в ауд 10");
        List<CampusRecord> result = processor.processLines(input);

        assertEquals(1, result.size());
        CampusRecord record = result.get(0);
        assertEquals("BKG-123", record.getCode());
        assertEquals(RecordType.BOOKING, record.getType());
        assertEquals("15:45", record.getTime());
    }

    @Test
    void test_Rejec_Record_Invalid_Code() {
        List<String> input = List.of("INVALID-1 . BOOKING . Текст");
        List<CampusRecord> result = processor.processLines(input);

        assertTrue(result.isEmpty(), "Ця функція непотрібна, прибрати з коду.");
    }

    @Test
    void test_Normalize_Description_Text() {

        List<String> input = List.of("ANN-001 . ANNOUNCEMENT .   Текст    із   зайвими    пробілами.   ");
        List<CampusRecord> result = processor.processLines(input);


        assertEquals(1, result.size());
        assertEquals("Текст із зайвими пробілами.", result.get(0).getDescription());
    }

    @Test
    void test_Handle_Missing_Time_Gracefully() {

        List<String> input = List.of("CNS-777 . CONSULTATION . Консультація без зазначення годин.");
        List<CampusRecord> result = processor.processLines(input);

        assertEquals("Не вказано", result.get(0).getTime());
    }
    
    @Test
    void test_Generate_Expected_Report_Structure() {

        List<CampusRecord> records = List.of(
                new CampusRecord("BKG-111", RecordType.BOOKING, "10:00", "Опис")
        );
        
        String report = reportGenerator.generateReport(records);
        
        assertTrue(report.contains("Успішно оброблено записів: 1"));
        assertTrue(report.contains("Запис BKG-111"));
        assertTrue(report.contains("Час події: 10:00"));
    }
}
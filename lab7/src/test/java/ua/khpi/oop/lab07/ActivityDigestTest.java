package ua.khpi.oop.lab07;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ActivityDigestTest {

    @Test
    void test_Behavior() {
        Trackable trackable = new ActivityDigest("TEST01", 5, 10, 3);
        
        assertEquals(50.0, trackable.CompletionRate());
        assertTrue(trackable.TrackingDetails().contains("виконано завдань 5/10"));
    }

    @Test
    void test_Exportable_Behavior() {
        Exportable exportable = new ActivityDigest("TEST02", 10, 10, 5);
        
        String json = exportable.exportData("JSON");
        assertTrue(json.contains("\"completionRate\": 100.0"));
        assertTrue(json.contains("TEST02"));
    }
}
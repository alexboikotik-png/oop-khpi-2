package ua.khpi.oop.lab10.container;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class JournalContainerTest {
    private JournalContainer<String> container;

    @BeforeEach
    void setUp() {
        container = new JournalContainer<>();
    }

    @Test
    void testAddAndSize() {
        assertTrue(container.isEmpty());
        container.add("Test 1");
        assertEquals(1, container.size());
        assertFalse(container.isEmpty());
    }

    @Test
    void testRemoveShiftsElements() {
        container.add("A");
        container.add("B");
        container.add("C");
        
        String removed = container.remove(1);
        
        assertEquals("B", removed);
        assertEquals(2, container.size());
        assertEquals("C", container.get(1));
    }

    @Test
    void testIterator() {
        container.add("Element 1");
        container.add("Element 2");
        
        Iterator<String> iterator = container.iterator();
        
        assertTrue(iterator.hasNext());
        assertEquals("Element 1", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Element 2", iterator.next());
        assertFalse(iterator.hasNext());
        
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
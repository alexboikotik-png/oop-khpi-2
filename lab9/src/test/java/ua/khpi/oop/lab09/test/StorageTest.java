package ua.khpi.oop.lab09.test;

import org.junit.jupiter.api.Test;
import ua.khpi.oop.lab09.container.CloudRecord;
import ua.khpi.oop.lab09.model.DocumentFile;
import ua.khpi.oop.lab09.model.PhotoAlbum;
import ua.khpi.oop.lab09.utils.StorageUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StorageTest {

    @Test
    public void test_Cloud_Record_Stores_Data_Properly() {
        DocumentFile doc = new DocumentFile("TestDoc", 100, 50);
        CloudRecord<DocumentFile> record = new CloudRecord<>(doc, "user1");

        assertEquals("user1", record.getOwner());
        assertEquals("TestDoc", record.getItem().getName());
        assertEquals(100, record.getRecordSize());
        assertEquals(50, record.getItem().getWordCount());
    }

    @Test
    public void test_Generic_Method_Calculate_Total_Size() {
        PhotoAlbum p1 = new PhotoAlbum("P1", 200, 10);
        PhotoAlbum p2 = new PhotoAlbum("P2", 300, 15);
        
        List<CloudRecord<PhotoAlbum>> records = Arrays.asList(
                new CloudRecord<>(p1, "user1"),
                new CloudRecord<>(p2, "user2")
        );

        long totalSize = StorageUtils.calculateTotalSize(records);
        assertEquals(500, totalSize);
    }
    
    @Test
    public void test_Record_Creation_NullI_tem_Throws_Exception() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new CloudRecord<DocumentFile>(null, "user");
        });
        assertEquals("Значення не може бути нульовим", thrown.getMessage());
    }
}
package ua.khpi.oop.lab09.demo;

import ua.khpi.oop.lab09.container.CloudRecord;
import ua.khpi.oop.lab09.model.DocumentFile;
import ua.khpi.oop.lab09.model.PhotoAlbum;
import ua.khpi.oop.lab09.utils.StorageUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Хмарне сховище");

        DocumentFile doc = new DocumentFile("Report2026.pdf", 1500, 5000);
        CloudRecord<DocumentFile> docRecord = new CloudRecord<>(doc, "admin@khpi.edu.ua");
        
        System.out.println("Створено запис документа: " + docRecord);
        System.out.println("Кількість слів у документі: " + docRecord.getItem().getWordCount());

        PhotoAlbum album = new PhotoAlbum("Vacation_2025", 45000, 120);
        CloudRecord<PhotoAlbum> albumRecord = new CloudRecord<>(album, "student@khpi.edu.ua");
        
        System.out.println("\nСтворено запис альбому: " + albumRecord);
        System.out.println("Кількість фото: " + albumRecord.getItem().getPhotoCount());

        List<CloudRecord<DocumentFile>> myDocs = new ArrayList<>();
        myDocs.add(docRecord);
        myDocs.add(new CloudRecord<>(new DocumentFile("Thesis.docx", 2500, 15000), "admin@khpi.edu.ua"));

        long totalDocsSize = StorageUtils.calculateTotalSize(myDocs);
        System.out.println("\nРозмір документа: " + totalDocsSize);
    }
}
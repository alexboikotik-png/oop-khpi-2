package ua.khpi.oop.lab07;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GradeSnapshot grades = new GradeSnapshot("01", 92.5);
        AttendanceReport attendance = new AttendanceReport("02", 20, 18);
        ActivityDigest digest = new ActivityDigest("03", 8, 10, 15);

        System.out.println("Аналіз");
        List<Trackable> trackables = new ArrayList<>();
        trackables.add(attendance);
        trackables.add(digest); 

        for (Trackable t : trackables) {
            System.out.println(t.TrackingDetails());
            System.out.println("Рівень виконання: " + t.CompletionRate() + "%");
            System.out.println("-");
        }

        System.out.println("\nЕкспорт даних");
        List<Exportable> exportables = new ArrayList<>();
        exportables.add(grades);
        exportables.add(digest); 

        for (Exportable e : exportables) {System.out.println("JSON Export: " + e.exportData("JSON"));
        }
    }
}
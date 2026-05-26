package ua.khpi.oop.lab10.demo;

import ua.khpi.oop.lab10.model.*;
import ua.khpi.oop.lab10.container.JournalContainer;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Group group15 = new Group("КН15");
        Student s1 = new Student("Олег Петренко", group15);
        Student s2 = new Student("Анна Шевченко", group15);

        GradeEntry entry1 = new GradeEntry(s1, "ООП", 95);
        GradeEntry entry2 = new GradeEntry(s2, "ООП", 100);
        GradeEntry entry3 = new GradeEntry(s1, "Бази Даних", 88);

        JournalContainer<GradeEntry> journal = new JournalContainer<>();
        journal.add(entry1);
        journal.add(entry2);
        journal.add(entry3);
        
        System.out.println("Додано елементів: " + journal.size());

        System.out.println("\nОбхід");
        for (GradeEntry entry : journal) {
            System.out.println(entry);
        }

        System.out.println("\nВидалення елемента");
        GradeEntry removed = journal.remove(1);
        System.out.println("Видалено: " + removed);

        System.out.println("\n Обхід через явний iterator");
        Iterator<GradeEntry> iterator = journal.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
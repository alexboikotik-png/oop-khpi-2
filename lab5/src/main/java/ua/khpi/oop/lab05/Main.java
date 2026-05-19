package ua.khpi.oop.lab05;

import org.openjdk.jol.info.ClassLayout;


public class Main {
    public static void main(String[] args) {
        
        Person person = new Person("P-01", "Олексій");
        Volunteer volunteer = new Volunteer("V-01", "Марія", "Медична допомога");
        DriverVolunteer driver = new DriverVolunteer("D-01", "Іван", "Водіння", "C, D");

        System.out.println(person.getDetails());
        System.out.println(volunteer.getDetails());
        System.out.println(driver.getDetails());
        
        System.out.println("\n Person");
        System.out.println(ClassLayout.parseInstance(person).toPrintable());
        
        System.out.println("\n Volunteer");
        System.out.println(ClassLayout.parseInstance(volunteer).toPrintable());
        
        System.out.println("\n DriverVolunteer");
        System.out.println(ClassLayout.parseInstance(driver).toPrintable());
    }
}
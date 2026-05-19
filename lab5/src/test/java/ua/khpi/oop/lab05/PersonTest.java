package ua.khpi.oop.lab05;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonTest {

    @Test
    public void test_Person_Initialization() {
        Person person = new Person("P-01", "Олексій");
        
        Assert.assertEquals(person.getId(), "P-01", "ID має збігатися");
        Assert.assertEquals(person.getName(), "Олексій", "Ім'я має збігатися");
    }

    @Test
    public void test_Details_Format() {
        Person person = new Person("P-01", "Олексій");
        String details = person.getDetails();
        
        Assert.assertTrue(details.contains("P-01"), "Деталі мають містити ID");
        Assert.assertTrue(details.contains("Олексій"), "Деталі мають містити ім'я");
    }

    @Test
    public void test_Equals_Id() {
        Person person1 = new Person("P-01", "Олексій");
        Person person2 = new Person("P-01", "Інше Ім'я");
        Person person3 = new Person("P-02", "Олексій");
        
        Assert.assertEquals(person1, person2, "Люди з однаковим ID рівні");
        Assert.assertNotEquals(person1, person3, "Люди з різним ID не рівні");
    }
}
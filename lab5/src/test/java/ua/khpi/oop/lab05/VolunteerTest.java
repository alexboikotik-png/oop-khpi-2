package ua.khpi.oop.lab05;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VolunteerTest {

    @Test
    public void test_Volunteer_Inheritance() {
        Volunteer volunteer = new Volunteer("V-01", "Марія", "Медична допомога");
        
        Assert.assertEquals(volunteer.getId(), "V-01");
        Assert.assertEquals(volunteer.getName(), "Марія");
        Assert.assertEquals(volunteer.getPrimarySkill(), "Медична допомога");
    }

    @Test
    public void test_Parent_Details() {
        Volunteer volunteer = new Volunteer("V-01", "Марія", "Медична допомога");
        String details = volunteer.getDetails();
        
        Assert.assertTrue(details.contains("V-01"));
        Assert.assertTrue(details.contains("Марія"));
        Assert.assertTrue(details.contains("Volunteer"));
        Assert.assertTrue(details.contains("Медична допомога"));
    }
}
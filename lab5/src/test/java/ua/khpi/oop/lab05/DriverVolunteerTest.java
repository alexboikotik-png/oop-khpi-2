package ua.khpi.oop.lab05;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverVolunteerTest {

    @Test
    public void test_Volunteer_Initialization() {
        DriverVolunteer driver = new DriverVolunteer("D-01", "Іван", "Водіння", "B, C");
        
        Assert.assertEquals(driver.getId(), "D-01");
        Assert.assertEquals(driver.getName(), "Іван");
        Assert.assertEquals(driver.getPrimarySkill(), "Водіння");
        Assert.assertEquals(driver.getLicenseCategory(), "B, C");
    }

    @Test
    public void test_Hierarchy_Details() {
        DriverVolunteer driver = new DriverVolunteer("D-01", "Іван", "Водіння", "B, C");
        String details = driver.getDetails();
        
        Assert.assertTrue(details.contains("D-01"));
        Assert.assertTrue(details.contains("Водіння"));
        Assert.assertTrue(details.contains("DriverVolunteer"));
        Assert.assertTrue(details.contains("B, C"));
    }
}
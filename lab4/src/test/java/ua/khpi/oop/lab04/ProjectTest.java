package ua.khpi.oop.lab04;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectTest {

    private Project project;
    private Volunteer volunteer;

    @BeforeMethod
    public void setUp() {
        project = new Project("P-01", "Еко-проєкт", true);
        volunteer = new Volunteer("V-01", "Олег");
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"negative", "smoke"})
    public void CreateProjTitle() {
        new Project("P-Er", "", true);
    }

    @Test(groups = {"logic", "positive"})
    public void AddVolunteerActProj() {
        project.addVolunteer(volunteer);
        Assert.assertTrue(project.result().contains("Кількість волонтерів: 1"));
    }

    @Test(groups = {"logic", "positive"})
    public void CantAddVolunteerCompleteProj() {
        project.complete(); 
        project.addVolunteer(volunteer); 
        Assert.assertTrue(project.result().contains("Кількість волонтерів: 0"));
    }
}
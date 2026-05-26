package ua.khpi.oop.lab04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CoordinatorTest {

    @DataProvider(name = "projectData")
    public Object[][] provideProjectData() {
        return new Object[][] {
            {"P-101", "Евакуація тварин"},
            {"P-102", "Збір гуманітарної допомоги"},
            {"P-103", "Плетіння маскувальних сіток"}
        };
    }

    @Test(dataProvider = "projectData", groups = {"smoke", "positive"})
    public void testCoordinatorCreatesMultipleProjects(String pId, String title) {
        Coordinator coordinator = new Coordinator("C-10", "Анна");
        Project newProject = coordinator.createProject(pId, title);

        Assert.assertNotNull(newProject, "Проєкт має бути створений");
        Assert.assertTrue(newProject.result().contains(title), "Проєкт має містити правильну назву");
    }

    @Test(groups = {"regression", "positive"})
    public void testEqualsForSameId() {
        Coordinator coord1 = new Coordinator("C-01", "Іван");
        Coordinator coord2 = new Coordinator("C-01", "Петро"); 

        Assert.assertEquals(coord1, coord2, "Координатори з однаковим ID повинні бути рівними");
    }

    @Test(groups = {"regression", "positive"})
    public void testNotEqualsForDifferentId() {
        Coordinator coord1 = new Coordinator("C-01", "Іван");
        Coordinator coord2 = new Coordinator("C-02", "Іван"); 

        Assert.assertNotEquals(coord1, coord2, "Координатори з різними ID не рівні"); 
    }
}
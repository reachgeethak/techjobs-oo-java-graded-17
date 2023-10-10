package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTow = new Job();
        assertNotEquals(jobOne.getId(), jobTow.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.getId()!=-1);
        assertEquals("Product tester",job.getName());
        assertEquals("ACME",job.getEmployer().getValue());
        assertEquals("Desert",job.getLocation().getValue());
        assertEquals("Quality control",job.getPositionType().getValue());
        assertEquals("Persistence",job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job();
        Job jobTow = new Job();
        assertFalse((jobOne.getId()==jobTow.getId()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedResult = System.lineSeparator()
                + "ID: " + job.getId() + System.lineSeparator()
                + "Name: Product tester"+ System.lineSeparator()
                + "Employer: ACME"+ System.lineSeparator()
                + "Location: Desert"+ System.lineSeparator()
                + "Position Type: Quality control"+ System.lineSeparator()
                + "Core Competency: Persistence"+ System.lineSeparator();
        assertEquals(expectedResult, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType(""), new CoreCompetency("Persistence"));
        String expectedResult = System.lineSeparator()
                + "ID: " + job.getId() + System.lineSeparator()
                + "Name: Product tester"+ System.lineSeparator()
                + "Employer: ACME"+ System.lineSeparator()
                + "Location: Data not available"+ System.lineSeparator()
                + "Position Type: Data not available"+ System.lineSeparator()
                + "Core Competency: Persistence"+ System.lineSeparator();
        assertEquals(expectedResult, job.toString());
    }

    @Test
    public void testToStringAllFieldsEmptyExceptId() {
        Job job = new Job();
        assertEquals("OOPS! This job does not seem to exist.", job.toString());
    }
}

package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // Added two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        id = nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }


    // Added custom equals and hashCode methods. Consider two Job objects "equal" when their id field match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId() ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    //Added getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        if(name == null && employer == null && location == null &&  coreCompetency == null ){
            return "OOPS! This job does not seem to exist.";
        }
        String jobObject = System.lineSeparator()
                + "ID: " + id + System.lineSeparator()
                + "Name: " + ((name != null && name.trim().isEmpty()) ? name : "Data not available") + System.lineSeparator()
                + "Employer: " + ((employer.getValue() != null && employer.getValue().trim().isEmpty()) ? employer.getValue() : "Data not available") + System.lineSeparator()
                + "Location: " + ((location.getValue() != null && location.getValue().trim().isEmpty()) ? location.getValue() : "Data not available") + System.lineSeparator()
                + "Position Type: " + ((positionType.getValue() != null && positionType.getValue().trim().isEmpty()) ? positionType.getValue() : "Data not available") + System.lineSeparator()
                + "Core Competency: " + ((coreCompetency.getValue() != null && coreCompetency.getValue().trim().isEmpty()) ? coreCompetency.getValue() : "Data not available") + System.lineSeparator();

        return jobObject;
    }
}

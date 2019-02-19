package org.personal.rampup.model;

public class GenericITEmployee extends GenericEmployee {
    private String contactNumber;

    private int experience;

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "GenericITEmployee{" +
                "contactNumber='" + contactNumber + '\'' +
                ", experience=" + experience + super.toString() +
                '}';
    }
}

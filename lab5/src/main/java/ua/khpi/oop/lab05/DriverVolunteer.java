package ua.khpi.oop.lab05;

public final class DriverVolunteer extends Volunteer {
    private String licenseCategory; 
    public DriverVolunteer(String id, String name, String primarySkill, String licenseCategory) {
        super(id, name, primarySkill); 
        this.licenseCategory = licenseCategory;
    }
    public String getLicenseCategory() { return licenseCategory; }

    public String getDetails() {
        return super.getDetails() + " DriverVolunteer Категорія " + licenseCategory + "";
    }
}
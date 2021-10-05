package model;

public class Customer {
    private String name;
    private String dateOfBirth;
    private String ID;

    public Customer() {
    }
    public Customer(String name, String dateOfBirth, String ID) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
}

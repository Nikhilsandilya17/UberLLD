package models;

public class Passenger {
    private int id;
    private String name;
    private String contact;
    private String defaultLocation;

    public Passenger(int id, String name, String contact, String defaultLocation) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.defaultLocation = defaultLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }
}

package models;

public class Driver {
    private String name;
    private String contact;
    private DriverStatus driverStatus;
    private String drivingLicenseNo;

    public Driver(String name, String contact, DriverStatus driverStatus, String drivingLicenseNo) {
        this.name = name;
        this.contact = contact;
        this.driverStatus = driverStatus;
        this.drivingLicenseNo = drivingLicenseNo;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", driverStatus=" + driverStatus +
                ", drivingLicenseNo='" + drivingLicenseNo + '\'' +
                '}';
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

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }
}

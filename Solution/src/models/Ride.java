package models;

public class Ride {
    private final int id;
    private Passenger passenger;
    private Driver driver;
    private String pickupLocation;
    private String dropLocation;
    private RideStatus rideStatus;
    private double fare;
    private final boolean isPremium;

    public Ride(int id, Passenger passenger, Driver driver, String pickupLocation, String dropLocation, RideStatus rideStatus, double fare, boolean isPremium) {
        this.id = id;
        this.passenger = passenger;
        this.driver = driver;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.rideStatus = rideStatus;
        this.fare = fare;
        this.isPremium = isPremium;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", driver=" + driver +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", dropLocation='" + dropLocation + '\'' +
                ", rideStatus=" + rideStatus +
                ", fare=" + fare +
                ", isPremium=" + isPremium +
                '}';
    }

    public int getId() {
        return id;
    }

    public boolean getIsPremium(){
        return isPremium;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}

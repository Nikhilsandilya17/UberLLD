import models.*;

import java.util.HashMap;

public class UberRideService {

    private static final String ALL_DRIVERS_BUSY_MESSAGE = "All the drivers are busy at the moment";
    private HashMap<String, Driver> drivers;
    private HashMap<Integer, Ride> rides;
    PaymentProcessor paymentProcessor;
    private HashMap<Integer, Passenger> passengers;
    public static UberRideService instance;

    public static UberRideService getInstance(){
        if(instance==null){
            instance = new UberRideService();
        }
        return instance;
    }

    private UberRideService() {
        drivers = new HashMap<>();
        rides = new HashMap<>();
        passengers = new HashMap<>();
    }

    public Ride requestRide(Passenger passenger, String pickupLocation, String dropLocation, boolean isPremium) {
        checkValidity(passenger, pickupLocation, dropLocation);

        Ride ride = createRide(passenger, pickupLocation, dropLocation, isPremium);
        return assignDriverToRide(ride);
    }

    private Ride createRide(Passenger passenger, String pickupLocation, String dropLocation, boolean isPremium) {
        double initialFare = calculateInitialFare(pickupLocation, dropLocation, isPremium);
        Ride ride = new Ride(rides.size() + 1, passenger, null, pickupLocation, dropLocation, RideStatus.REQUESTED, initialFare, isPremium);
        System.out.println(ride.toString());
        return ride;
    }

    private Ride assignDriverToRide(Ride ride) {
        Driver driver = findNearestDriver();
        if (driver != null) {
            acceptRide(ride);
            ride.setDriver(driver);
            driver.setDriverStatus(DriverStatus.BUSY);
            System.out.println("Driver assigned successfully to : "+ driver.toString());
            rides.put(ride.getId(), ride);
            return ride;
        }
        return null;
    }


    private void acceptRide(Ride ride) {
        ride.setRideStatus(RideStatus.ACCEPTED);
        System.out.println("Ride requested successfully, Driver coming to your pickup location");
    }

    private void checkValidity(Passenger passenger, String pickupLocation, String dropLocation) {
        if(passenger == null){
            throw new IllegalArgumentException("Invalid passenger");
        }
        if(pickupLocation == null || dropLocation == null || pickupLocation.equals(dropLocation)){
            throw new IllegalArgumentException("Invalid pickup or drop location");
        }
    }

    private double calculateInitialFare(String pickup, String drop, boolean isPremium) {
        double baseFare = 50.0;
        return isPremium ? baseFare * 1.5 : baseFare;
    }


    public void startRide(Ride ride) {
        if(ride!=null){
            ride.setRideStatus(RideStatus.IN_PROGRESS);
            System.out.println("Ride started successfully");
        }
    }

    public void cancelRide(Ride ride){
        if(ride!=null && ride.getRideStatus()==RideStatus.ACCEPTED){
            rides.remove(ride.getId());
            Driver driver = ride.getDriver();
            driver.setDriverStatus(DriverStatus.IDLE);
            ride.setRideStatus(RideStatus.CANCELLED);
            System.out.println("Ride cancelled successfully by passenger");
        }
    }

    public void completeRide(Ride ride) {
        if (ride != null && ride.getRideStatus() == RideStatus.IN_PROGRESS) {
            ride.getDriver().setDriverStatus(DriverStatus.IDLE);
            System.out.println("Ride completed successfully by driver: " + ride.getDriver().toString());
            paymentProcessor.processPayment(ride.getFare());
            ride.setRideStatus(RideStatus.COMPLETED);


        }
    }
    public void addDriver(Driver driver){
        drivers.put(driver.getDrivingLicenseNo(), driver);
    }

    public Driver findNearestDriver() {
        for (Driver currentDriver : drivers.values()) {
            if (isDriverIdle(currentDriver)) {
                return currentDriver;
            }
        }
        System.out.println(ALL_DRIVERS_BUSY_MESSAGE);
        return null;
    }

    private boolean isDriverIdle(Driver driver) {
        return driver.getDriverStatus() == DriverStatus.IDLE;
    }
    public void addPassengers(Passenger passenger){
        passengers.put(passenger.getId(), passenger);
    }
}

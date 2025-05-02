import models.Driver;
import models.DriverStatus;
import models.Passenger;
import models.Ride;

public class UberLLDDemo {
    public static void main(String[] args) {
        UberRideService uberRideService = UberRideService.getInstance();
        uberRideService.paymentProcessor = new UPIPayment();

        //Make passenger
        Passenger passenger = new Passenger(1, "Nikhil", "1234567890", "Sarjapur");
        Passenger passenger1 = new Passenger(2, "Sandy", "1234567890", "Bellandur");
        Passenger passenger2 = new Passenger(3, "Sourav", "1234567890", "HSR");
        uberRideService.addPassengers(passenger);
        uberRideService.addPassengers(passenger1);
        uberRideService.addPassengers(passenger2);

        //Make Drivers
        Driver driver = new Driver("Driver1", "1234", DriverStatus.IDLE, "1234-ABC");
        Driver driver1 = new Driver("Driver2", "1234", DriverStatus.IDLE, "4567-ABC");
        Driver driver2 = new Driver("Drive43", "1234", DriverStatus.IDLE, "0891-ABC");
        uberRideService.addDriver(driver);
        uberRideService.addDriver(driver1);
        uberRideService.addDriver(driver2);

        //Request ride
        String dropLocation = "Sarjapur";
        Ride ride = uberRideService.requestRide(passenger1, passenger1.getDefaultLocation(), dropLocation, false);
        uberRideService.startRide(ride);
        uberRideService.completeRide(ride);

        dropLocation = "Bellandur";
        ride = uberRideService.requestRide(passenger, passenger.getDefaultLocation(), dropLocation, true);
        uberRideService.cancelRide(ride);


    }
}

package devices;

import creatures.Human;

public class Diesel extends Car{
    Double fuelTankSize;

    public Diesel(String producer, String model, Integer yearOfProduction, Double weight, Integer speed, Double fuel) {
        super(producer, model, yearOfProduction, weight, speed);
        this.fuelTankSize = fuelTankSize;
        System.out.println("Utworzono samochód z silnikiem diesla.");
    }

    @Override
    void refuel() {
        System.out.println("Tankuję ropę");
    }

    public void turnOn() {
        System.out.println("Przekręcam kluczyk");
        System.out.println("Wrrr");
        System.out.println("Wrrrr");
        System.out.println("Wrrrrrrrrrrrrrrrrr puf, puf, puf, odpalił, możemy ruszać.");
    }
}

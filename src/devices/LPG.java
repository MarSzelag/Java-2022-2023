package devices;

public class LPG extends Car{
    Double tankMaxPressure;

    public LPG(String producer, String model, Integer yearOfProduction, Double weight, Integer speed, Double tankMaxPressure) {
        super(producer, model, yearOfProduction, weight, speed);
        this.tankMaxPressure = tankMaxPressure;
        System.out.println("Utworzono samochód LPG");
    }

    @Override
    void refuel() {
        System.out.println("Tankuję gaz");
    }

    public void turnOn() {
        System.out.println("Przekręcam kluczyk");
        System.out.println("Wrrr");
        System.out.println("Wrrrr");
        System.out.println("Bszszszsz, odpalił, możemy ruszać.");
    }
}

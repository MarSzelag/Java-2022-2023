package devices;

public class Electric extends Car {
    Double voltage;

    public Electric(String producer, String model, Integer yearOfProduction, Double weight, Integer speed, Double voltage) {
        super(producer, model, yearOfProduction, weight, speed);
        this.voltage = voltage;
        System.out.println("Utworzono samochód elektryczny.");
    }

    @Override
    void refuel() {
        System.out.println("Tankuję");
    }

    @Override
    public void turnOn() {
        System.out.println("Przekręcam kluczyk");
        System.out.println("Silnik elektryczny uruchomiony");
    }

}

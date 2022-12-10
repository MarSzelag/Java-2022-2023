package devices;

public class Car extends Device {
    Double weight;
    Integer speed;
    Double value;

    public Car(String producer, String model, Integer yearOfProduction, Double weight, Integer speed) {
        super(producer, model, yearOfProduction);
        this.weight = weight;
        this.speed = speed;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    @Override
    public void turnOn() {
        System.out.println("Przekręcam kluczyk");
        System.out.println("Wrrr");
        System.out.println("Wrrrr");
        System.out.println("Wrrrrrrrrrrrrrrrrr, odpalił, możemy ruszać.");
    }

    @Override
    public String toString() {
        return "Model: " + model + ", producent: " + producer + " waga: " + weight + ", szybkość: " + speed + ", wartość: " + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { // Czy użycie .hashCode w tym przypadku jest równoważne this == o?
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return model.equals(car.model) &&
                producer.equals(car.producer) &&
                weight.doubleValue() == car.weight.doubleValue() && //Jeśli nie porównam za pomocą .doubleValue, to będę porównywał referencje, a nie wartości.
                speed.intValue() == car.speed.intValue(); //&&
        // value.doubleValue() == car.value.doubleValue();
    }


}

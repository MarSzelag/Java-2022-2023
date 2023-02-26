package devices;

import creatures.Human;
import interfaces.Saleable;

public abstract class Car extends Device implements Saleable {
    Double weight;
    Integer speed;
    Double value = 0.0;

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
                speed.intValue() == car.speed.intValue() &&
                value.doubleValue() == car.value.doubleValue();
    }


    @Override
    public void sell(Human seller, Human buyer, Double price) {

        //if (seller.isCarInGarage() && buyer.isThereSpaceInGarage()) {
            if (seller.equals(buyer)) {
                System.out.println("Nie możesz odsprzedawać sam sobie.");
            } else if (buyer.getCash() < price) {
                System.out.println("Nie masz wystarczającej ilości pieniędzy. Za taką kwotę nie sprzedam samochodu.");
            } else if (price <= 0.00) {
                System.out.println("Coś jest nie tak z ceną. Powinna być większa niż 0.");
            } else if(seller.isCarInGarage(this) && buyer.isThereSpaceInGarage()){ //if (seller.getCar().getClass() != null) {
                System.out.println("Pobieram pieniądze od kupującego i przekazuję sprzedającemu");
                buyer.setCash(-price);
                seller.setCash(price);
                System.out.println("Przekazuję samochód. Udanej jazdy!");
                /*buyer.setCar(seller.getCar());
                seller.setCar(null);*/

                seller.removeCarFromGarage(this); //Czy tutaj będzie potrzebny Car temp?
                buyer.addACar(this);
                System.out.println("Gratuluję udanej transakcji!!!");
            } else System.out.println("Coś w systemie poszło nie tak.");
        //}
    }


    abstract void refuel();

}

package devices;

import interfaces.Saleable;

public abstract class Device implements Saleable {
    final String producer;
    final String model;
    final Integer yearOfProduction;

    private Double value;


    public String getProducer() {
        return this.producer;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Device(String producer, String model, Integer yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    abstract void turnOn();

    @Override
    public String toString() {
        return "Producent: " + producer + ", model: " + model + ",rok produkcji: " + yearOfProduction;
    }
}

package devices;

public abstract class Device {
    final String producer;
    final String model;
    final Integer yearOfProduction;


    public String getProducer() {
        return this.producer;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public Device(String producer, String model, Integer yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    abstract void turnOn();

    public String toString() {
        return "Producent: " + producer + ", model: " + model + ",rok produkcji: " + yearOfProduction;
    }
}

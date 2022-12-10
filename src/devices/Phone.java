package devices;


public class Phone extends Device {

    Double screenSize;
    Boolean isAndroid;

    public Phone(String producer, String model, Integer yearOfProduction, Double screenSize, Boolean isAndroid) {
        super(producer, model, yearOfProduction);
        this.screenSize = screenSize;
        this.isAndroid = isAndroid;
    }

    public void turnOn() {
        System.out.println("Naciśnij przycisk.");
        System.out.println("Czekaj.");
        System.out.println("Czekaj..");
        System.out.println("Czekaj...");
        System.out.println("o! mój telefon " + producer + " działa!");
    }

    public String toString() {
        return "Producent: " + producer + ", model: " + model + ", rozmiar ekranu: " + screenSize + " cala, czy system operacyjny to android: " + isAndroid;
    }
}

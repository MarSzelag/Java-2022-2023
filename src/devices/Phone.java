package devices;


import creatures.Human;
import interfaces.Saleable;

import java.net.URL;
import java.util.List;

public class Phone extends Device implements Saleable {

    Double screenSize;
    Boolean isAndroid;
    Integer id = 0;

    String appName, appVersion, serverAddress;

    static final String defaultserverAddress = "https://catchanapp.com";
    static final String defaultProtocol = "https";
    static final String defaultVersionName = "2.15";
    List<String> appNameList;

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

    @Override
    public String toString() {
        return "Producent: " + producer + ", model: " + model + ", rozmiar ekranu: " + screenSize + " cala, czy system operacyjny to android: " + isAndroid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Phone phone = (Phone) o;
        return this.producer.equals(phone.producer) &&
                this.model.equals(phone.model) &&
                this.id == phone.id;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getPhone() == null) {
            System.out.println("Sprzedający nie posiada telefonu na sprzedaż");
        } else if (seller.equals(buyer)) {
            System.out.println("Nie możesz odsprzedawać sam sobie.");
        } else if (buyer.getCash() < price) {
            System.out.println("Nie masz wystarczającej ilości pieniędzy. Za taką kwotę nie sprzedam telefonu.");
        } else if (price <= 0.00) {
            System.out.println("Coś jest nie tak z ceną. Powinna być większa niż 0.");
        } else if (seller.getPhone().getClass() != null) {
            System.out.println("Pobieram pieniądze od kupującego i przekazuję sprzedającemu");
            buyer.setCash(-price);
            seller.setCash(price);
            System.out.println("Przekazuję telefon. Mam nadzieję, że będzie długo służył!");
            buyer.setPhone(seller.getPhone());
            seller.setPhone(null);
            System.out.println("Gratuluję udanej transakcji!!!");
        } else System.out.println("Coś w systemie poszło nie tak.");
    }

    public void installAnApp(String appName){
        System.out.println("Przyjmuję nazwę aplikacji do zainstalowania...");
        this.appName = appName;
        System.out.println("Instaluję aplikację...");
        System.out.println("Aplikacja: " + this.appName + " została poprawnie zainstalowana.");
    }

    public void installAnApp(String appName, String appVersion){
        System.out.println("Przyjmuję nazwę aplikacji do zainstalowania oraz jej wersję...");
        this.appName = appName;
        this.appVersion = appVersion;
        System.out.println("Instaluję aplikację...");
        System.out.println("Aplikacja: " + this.appName + " w wersji " + this.appVersion +" została poprawnie zainstalowana.");
    }

    public void installAnApp(String appName, String appVersion, String serverAddress){
        System.out.println("Przyjmuję nazwę aplikacji do zainstalowania, jej wersję oraz adres serwera danych...");
        this.appName = appName;
        this.appVersion = appVersion;
        this.serverAddress = serverAddress;
        System.out.println("Instaluję aplikację...");
        System.out.println("Aplikacja: " + this.appName + " w wersji " + this.appVersion +" została poprawnie zainstalowana z serwera " + this.serverAddress);
    }

    public void installAnApp(List<String> appNameList){
        this.appNameList = appNameList;
        for(int i = 0; i <= this.appNameList.size(); i++){
            System.out.println("Instaluję aplikację o nazwie: " + this.appNameList.get(i));
        }
    }

    public void installAnApp(URL url){
        URL appUrl = url;
        System.out.println("Wprowadzono adres: " + url);
        /*
        System.out.println("Pobieram i instaluję plik z adresu: " + defaultserverAddress);
        System.out.println("Domyślny protokół: " + defaultProtocol);
        System.out.println("Wersja oprogramowania: " + defaultVersionName);
        */
    }


}

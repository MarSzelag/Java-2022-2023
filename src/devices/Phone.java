package devices;


import creatures.Human;
import interfaces.Saleable;

import java.net.URL;
import java.util.*;

public class Phone extends Device implements Saleable {

    Double screenSize;
    Boolean isAndroid;
    Integer id = 0;

    String appName, appVersion, serverAddress;

    static final String defaultServerAddress = "download.winamp.com/";
    static final String defaultProtocol = "https://";
    static final String defaultVersionName = "winamp/winamp_latest_full.exe";

    Human owner;

    List<String> appNameList;

    Set<Application> applications = new HashSet<>();

    public Phone(String producer, String model, Integer yearOfProduction, Double screenSize, Boolean isAndroid) {
        super(producer, model, yearOfProduction);
        this.screenSize = screenSize;
        this.isAndroid = isAndroid;
    }

    public Human getOwner() {
        return owner;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }
    public void installanApp(Application application, Double price){
        if(this.owner.getCash() >= price) {
            System.out.println("Koszt aplikacji to " + price + " zł. Ilość pieniędzy na koncie jest wystarczająca. Kwota zostanie pobrana.");
            owner.setCash(-price);
            System.out.println("Rozpoczynam pobieranie aplikacji " + application.getName() + " w wersji " + application.getVersion());
            System.out.println("Aplikacja została pobrana. Rozpoczynam instalację.");
            applications.add(application);
            System.out.println("Instalacja oprogramowania przebiegła pomyślnie.");
        } else {
            System.out.println("Za mało pieniędzy na koncie. Potrzeba " + price + " zł.");
        }
    }

    public void isAppInstalled(Application application){
            if(applications.contains(application)){
                System.out.println("Aplikacja " + application.getName() + " w wersji " + application.getVersion() + " jest już zainstalowana.");
            }
    }

    public void isAppInstalled(String name){
        Application[] app = this.applications.toArray(new Application[this.applications.size()]);

        for(int i = 0; i < app.length; i++){
            if(app[i].getName().equals(name))
                System.out.println("Aplikacja o tej nazwie jest zainstalowana");
        }
    }

    public void listOfFreeApps(){
        Application[] app = this.applications.toArray(new Application[this.applications.size()]);
        System.out.println("Lista darmowych aplikacji na tym telefonie: ");

        for(int i = 0; i < app.length; i++){
            if(app[i].getPrice() == 0.0)
                System.out.println(app[i].getName());
        }
    }

    public void worthOfAllApps(){
        Application[] app = this.applications.toArray(new Application[this.applications.size()]);
        Double sum = 0.0;

        for(int i = 0; i < app.length; i++){
                sum = sum + app[i].getPrice();
        }
        System.out.println("Wartość wszystkich zainstalowanych na tym telefonie aplikacji wynosi: " + sum + " zł.");
    }

    public void appsInAlphabeticalOrder(){
        Application[] app = this.applications.toArray(new Application[this.applications.size()]);
        String[] strAr = new String[app.length];

        for(int i = 0; i < strAr.length; i++){ //Kopiowanie nazw z tablicy obiektów do tablicy stringów
            strAr[i] = app[i].getName();
        }

        Arrays.sort(strAr); //Sort tablicy Stringów

        System.out.println("Aplikacje posortowane według nazwy: ");
        for(int i = 0; i < app.length; i++){
            System.out.println(strAr[i]);
        }
    }

    public void appsCheapToExpensive(){
        Application[] app = this.applications.toArray(new Application[this.applications.size()]);
        Application temp;
        for(int i = 1; i < applications.size(); i++){
            for(int j = 1; j < applications.size(); j++){
                if(app[j].getPrice() < app[j - 1].getPrice()){
                    temp = app[j - 1];
                    app[j - 1] = app[j];
                    app[j] = temp;
                }
            }
        }

        System.out.println("Aplikacje posortowane wg ceny: ");
        for(int i = 0; i < app.length; i++){
            System.out.println(app[i].getName() + " " + app[i].getPrice());
        }

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
            this.setOwner(buyer);
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

        System.out.println("Wprowadzono adres: " + url);
        /*
        System.out.println("Pobieram i instaluję plik z adresu: " + defaultserverAddress);
        System.out.println("Domyślny protokół: " + defaultProtocol);
        System.out.println("Wersja oprogramowania: " + defaultVersionName);
        */
    }


}

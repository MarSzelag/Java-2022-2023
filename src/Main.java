import creatures.Human;
import creatures.Pet;
import devices.Application;
import devices.Electric;
import devices.Phone;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {

// Do testowania sortowania wg daty produkcji od najstarszego do najnowszego
        Human seller = new Human("Człowiek", 88.9, true, "Adam", "Mada");
        Human buyer = new Human("Człowiek", 93.5, true, "Bron", "Kowalski");
        Human random = new Human("Człowiek", 93.5, true, "Alicja", "Podłęska");

        buyer.setCash(20.0);
        Electric el1 = new Electric("FSO", "1W", 2000, 1200.5, 160, 255.5);
        Electric el2 = new Electric("FSO", "2W", 2010, 1200.5, 160, 255.5);
        Electric el3 = new Electric("FSO", "3W", 2022, 1200.5, 160, 255.5);

        Phone apsung = new Phone("Apsung", "is 11", 2023, 5.2, true);

        seller.setCash(2000.00);

        seller.addACar(el1);
        seller.addACar(el2);
        seller.addACar(el3);

        seller.setPhone(apsung);


        Application app1 = new Application("Pożeracz czasu i pieniędzy", "v.5.49", 119.99);
        Application app2 = new Application("Aza gadacz", "v.2.11", 12.50);
        Application app3 = new Application("Szalona apka za darmo", "v.5.49", 0.00);
        Application app4 = new Application("ZaDarmoWare", "v.5.49", 0.00);
        Application app5 = new Application("Planer czasu i wydatków", "v.1.23", 9.99);


        System.out.println(seller.toString());
        System.out.println(buyer.toString());

        System.out.println("--------------Test instalacji aplikacji");
        apsung.installanApp(app1, 119.99);
        apsung.installanApp(app2, 12.50);
        apsung.installanApp(app3, 0.00);
        apsung.installanApp(app4, 9.99);
        apsung.installanApp(app5, 0.00);

        System.out.println("--------------Test, wypisanie wszystkich darmowych aplikacji.");
        seller.getPhone().listOfFreeApps();

        System.out.println("--------------Test, zwrócenie wartości wszystkich zainstalowanych aplikacji.");
        seller.getPhone().worthOfAllApps();

        System.out.println("--------------Test, wypisanie nazw wszystkich zainstalowanych aplikacji w kolejności alfabetycznej.");
        seller.getPhone().appsInAlphabeticalOrder();

        System.out.println("--------------Test, wypisanie nazw wszystkich zainstalowanych aplikacji od najtańszych do najdroższych.");
        seller.getPhone().appsCheapToExpensive();

        System.out.println("--------------Test przedaży samochodu.");
        el1.sell(buyer, seller, 5.00);
        el3.sell(buyer, seller, 5.00);

        System.out.println("--------------Test, wyświetlenie danych osobowych.");
        System.out.println(seller.toString());

        System.out.println("--------------Test, liczba transakcji.");
        el1.numberOfTransactions();

        System.out.println("--------------Test, lista właścicieli pojazdu.");
        el1.ownerListTransactions();

        System.out.println("--------------Test, lista sprzedaży samochodu.");
        el1.listOfTransactions();

        System.out.println("--------------Test szukanie, czy ktoś był właścicielem pojazdu i którym.");
        el1.ownerSearchTransactions(buyer);

        System.out.println("--------------Test sprawdzania, czy A sprzedał samochód B.");
        el1.sellerBuyerSearchTransactions(buyer, seller);

        System.out.println("--------------Test instalowanie aplikacji na telefonie z URL");
        apsung.installAnApp("https://download.winamp.com/winamp/winamp_latest_full.exe");

    }
}

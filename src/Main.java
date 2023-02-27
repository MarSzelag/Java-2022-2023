import creatures.Human;
import creatures.Pet;
import devices.Electric;
import devices.Phone;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

// Do testowania sortowania wg daty produkcji od najstarszego do najnowszego
        Human seller = new Human("Człowiek", 88.9, true, "Adam", "Mada");
        Human buyer = new Human("Człowiek", 93.5, true, "Bron", "Kowalski");
        Human random = new Human("Człowiek", 93.5, true, "Alicja", "Podłęska");

        buyer.setCash(200.0);
        Electric el1 = new Electric("FSO", "1W", 2000, 1200.5, 160, 255.5);
        Electric el2 = new Electric("FSO", "2W", 2010, 1200.5, 160, 255.5);
        Electric el3 = new Electric("FSO", "3W", 2022, 1200.5, 160, 255.5);

        seller.addACar(el1);
        seller.addACar(el2);
        seller.addACar(el3);

        System.out.println(seller.toString());
        System.out.println(buyer.toString());

        System.out.println("--------------Test przedaży samochodu");
        el1.sell(buyer, seller, 5.00);
        el3.sell(buyer, seller, 5.00);

        System.out.println("--------------Test, wyświetlenie danych osobowych");
        System.out.println(seller.toString());

        System.out.println("--------------Test, liczba transakcji");
        el1.numberOfTransactions();

        System.out.println("--------------Test, lista właścicieli pojazdu");
        el1.ownerListTransactions();

        System.out.println("--------------Test, lista sprzedaży samochodu");
        el1.listOfTransactions();

        System.out.println("--------------Test szukanie, czy ktoś był właścicielem pojazdu i którym");
        el1.ownerSearchTransactions(buyer);

        System.out.println("--------------Test sprawdzania, czy A sprzedał samochód B");
        el1.sellerBuyerSearchTransactions(buyer, seller);

    }
}

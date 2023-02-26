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
        buyer.setCash(200.0);
        Electric el1 = new Electric("FSO", "1W", 2000, 1200.5, 160, 255.5);
        Electric el2 = new Electric("FSO", "2W", 2010, 1200.5, 160, 255.5);
        Electric el3 = new Electric("FSO", "3W", 2022, 1200.5, 160, 255.5);

        seller.addACar(el1);
        seller.addACar(el2);
        seller.addACar(el3);

        System.out.println(seller.toString());
        System.out.println(buyer.toString());

        el1.sell(seller, buyer, 5.00);
        el3.sell(seller, buyer, 5.00);

        System.out.println(seller.toString());
        System.out.println(buyer.toString());

    }
}

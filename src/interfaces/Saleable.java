package interfaces;

import creatures.Human;

public interface Saleable {
    void sell(Human seller, Human buyer, Double price) throws Exception;

}

//Jak zaimportować interface jeśli mamy go w folderze source, np. src/Saleable i chcemy zaimportować do klasy znajdującej się jakimś folderze, np src/animals/human?
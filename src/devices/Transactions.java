package devices;

import creatures.Human;

import java.util.Date;

public class Transactions {
    Human buyer;
    Human seller;
    Double price;
    Date dateOfSell;

    public Transactions(Human buyer, Human seller, Double price, Date dateOfSell) {
        this.buyer = buyer;
        this.seller = seller;
        this.price = price;
        this.dateOfSell = dateOfSell;
    }

    public Human getBuyer() {
        return buyer;
    }

    public Human getSeller() {
        return seller;
    }

    public Double getPrice() {
        return price;
    }

    public Date getDateOfSell() {
        return dateOfSell;
    }




    @Override
    public String toString() {
        return "Kupujący: " + this.buyer.getName() + " " + this.buyer.getSurname() + ", Sprzedawca: " + this.seller.getName() + " " + this.seller.getSurname() + ", Cena sprzedaży: " + this.price + ", Data sprzedaży: " + dateOfSell;
    }
}

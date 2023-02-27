package devices;

import creatures.Human;
import interfaces.Saleable;

import java.util.ArrayList;
import java.util.Date;

public abstract class Car extends Device implements Saleable {
    Double weight;
    Integer speed;
    Double value = 0.0;
    ArrayList<Transactions> transactions = new ArrayList<>();

    public void numberOfTransactions() {
        System.out.println("Ilość zarejestrowanych transakcji sprzedaży samochodu " + this.toString() + " samochodu wynosi " + this.transactions.size());
    }

    public Integer numberOfTransactionsInt() {
        return this.transactions.size();
    }

    public void listOfTransactions() {
        for (int i = 0; i < this.transactions.size(); i++) {
            System.out.println("Transakcja nr " + (i + 1) + " " + this.transactions.get(i).toString());
        }
    }

    public void ownerListTransactions() {
        for (int i = 0; i < this.transactions.size(); i++) {
            System.out.println("Właściciel nr " + (i + 1) + " " + this.transactions.get(i).getBuyer().getName() + " " + this.transactions.get(i).getBuyer().getSurname());
        }
    }

    public void addOwnerTransaction(Human seller, Human buyer, Double price, Date dateOfSell) {
        this.transactions.add(new Transactions(buyer, seller, price, dateOfSell));
    }


    public void ownerSearchTransactions(Human buyer) {
        boolean check = false;
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getBuyer().equals(buyer)) {
                System.out.println((i + 1) + " właściciel pojazdu: " + this.transactions.get(i).getBuyer().getName() + " " + this.transactions.get(i).getBuyer().getName());
                check = true;
            }
        }
        if (!check)
            System.out.println(buyer.getName() + " " + buyer.getSurname() + " nie znajduje się na liście właścicieli tego pojazdu.");
    }

    public void sellerBuyerSearchTransactions(Human buyer, Human seller) {
        boolean check = false;
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getSeller().equals(seller) && this.transactions.get(i).getBuyer().equals(buyer)) {
                System.out.println(seller.getName() + " " + seller.getSurname() + " sprzedał samochód " + buyer.getName() + " " + buyer.getSurname());
                check = true;
            }
        }
        if (!check) {
            System.out.println(seller.getName() + " " + seller.getSurname() + " nie sprzedał samochodu " + buyer.getName() + " " + buyer.getSurname());
        }

    }

    public Car(String producer, String model, Integer yearOfProduction, Double weight, Integer speed) {
        super(producer, model, yearOfProduction);
        this.weight = weight;
        this.speed = speed;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    @Override
    public void turnOn() {
        System.out.println("Przekręcam kluczyk");
        System.out.println("Wrrr");
        System.out.println("Wrrrr");
        System.out.println("Wrrrrrrrrrrrrrrrrr, odpalił, możemy ruszać.");
    }

    @Override
    public String toString() {
        return "Model: " + model + ", producent: " + producer + " waga: " + weight + ", szybkość: " + speed + ", wartość: " + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { // Czy użycie .hashCode w tym przypadku jest równoważne this == o?
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return model.equals(car.model) &&
                producer.equals(car.producer) &&
                weight.doubleValue() == car.weight.doubleValue() && //Jeśli nie porównam za pomocą .doubleValue, to będę porównywał referencje, a nie wartości.
                speed.intValue() == car.speed.intValue() &&
                value.doubleValue() == car.value.doubleValue();
    }


    @Override
    public void sell(Human buyer, Human seller, Double price) {

        if (seller.equals(buyer)) {
            System.out.println("Nie możesz odsprzedawać sam sobie.");
        } else if (buyer.getCash() < price) {
            System.out.println("Nie masz wystarczającej ilości pieniędzy. Za taką kwotę nie sprzedam samochodu.");
        } else if (price <= 0.00) {
            System.out.println("Coś jest nie tak z ceną. Powinna być większa niż 0.");
        } else if (seller.isCarInGarage(this) && buyer.isThereSpaceInGarage() && this.transactions.get(this.transactions.size() - 1).getBuyer().equals(seller)) {//this.ownersList.get(this.ownersList.size() - 1).equals(seller)){
            System.out.println("Pobieram pieniądze od kupującego i przekazuję sprzedającemu");
            buyer.setCash(-price);
            seller.setCash(price);
            System.out.println("Przekazuję samochód. Udanej jazdy!");
            seller.removeCarFromGarage(this);
            buyer.addACar(this);
            this.addOwnerTransaction(seller, buyer, price, new Date());
            System.out.println("Gratuluję udanej transakcji!!!");
        } else System.out.println("Coś w systemie poszło nie tak.");
    }


    abstract void refuel();

}

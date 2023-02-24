package creatures;

import interfaces.Saleable;

public abstract class Animal implements Saleable, Edible, Feedable {
    final String species;
    protected Double weight;

    Boolean isAlive;
    Human owner;


    public Animal(String species, Double weight, Boolean isAlive) {
        this.species = species;
        this.weight = weight;
        this.isAlive = isAlive;

    }

    @Override
    public void feed(
    ) {
        if (this.isAlive) {
            System.out.println("Żyjęęęę!!!");
            this.weight += 0.5;
            System.out.println("Dzięki za żarło :) ");
        } else {
            System.out.println("Klapa, nie ma go już pośród żywych.");
        }
    }
    /*
@Override
    public void feed(Double foodweight)(
    ) {
        if (this.isAlive) {
            System.out.println("Żyjęęęę!!!");
            this.weight += 0.5;
            System.out.println("Dzięki za żarło :) ");
        } else {
            System.out.println("Klapa, nie ma go już pośród żywych.");
        }
    }*/

void takeforWalk(Double WALK_DISTANCE){// Dodane Double distance?????
    if (this.isAlive) {
        System.out.println("Idziemy na spacer.");
        System.out.println("Pies pobiegał i schudł " + (this.weight -= 0.5) + " kg.");
        System.out.println("Przebiegł " + WALK_DISTANCE);

        if (this.weight <= 0) {
            this.isAlive = false;
            System.out.println(this.weight);
            System.out.println("Biedaczysko. Za bardzo się nabiegał i zmarł.");
        }
    } else {
        System.out.println(this.weight);
        System.out.println("On jest martwy, wzywamy policję!!!");
    }
}
    void takeForWalk() {
        if (this.isAlive) {
            System.out.println("Idziemy na spacer.");
            System.out.println("Pies pobiegał i schudł " + (this.weight -= 0.5) + " kg.");

            if (this.weight <= 0) {
                this.isAlive = false;
                System.out.println(this.weight);
                System.out.println("Biedaczysko. Za bardzo się nabiegał i zmarł.");
            }
        } else {
            System.out.println(this.weight);
            System.out.println("On jest martwy, wzywamy policję!!!");
        }
    }

    @Override
    public String toString() {
        return "Gatunek: " + species + ", waga: " + weight + ", " + ", żyje: " + isAlive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Animal animal = (Animal) o;
        return species == animal.species &&
                weight == animal.weight &&
                isAlive == animal.isAlive &&
                owner == animal.owner;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getPet() == null) {
            System.out.println("Sprzedający nie posiada zwierzęcia na sprzedaż");
        } else if (seller.equals(buyer)) {
            System.out.println("Nie możesz odsprzedawać sam sobie.");
        } else if (buyer.getCash() < price) {
            System.out.println("Nie masz wystarczającej ilości pieniędzy. Za taką kwotę nie sprzedam zwierzaka.");
        } else if (price <= 0.00) {
            System.out.println("Coś jest nie tak z ceną. Powinna być większa niż 0.");
        } else if (seller.getPet().getClass() != null) //Zmienić .getClass na instanceOf --> if(this instanceOf Huma){ }
            if (seller.getPet().getClass() == Human.class) {
                System.out.println("Tej, ale ludzi nie można sprzedawać... ani kupować.");
            } else {
                System.out.println("Pobieram pieniądze od kupującego i przekazuję sprzedającemu");
                buyer.setCash(-price);
                seller.setCash(price);
                System.out.println("Przekazuję zwierzaka. Mam nadzieję, że w dobre ręce.");
                buyer.setPet(seller.getPet());
                seller.setPet(null);
                System.out.println("Gratuluję udanej transakcji!!!");
            }
        else System.out.println("Coś w systemie poszło nie tak.");
    }

    @Override
    public void beEaten() {
        this.isAlive = false;
        this.weight = 0.0;
        System.out.println("Żegnaj złoczyńco");

    }

}

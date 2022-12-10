package animals;

public class Animal {
    final String species;
    private Double weight;
    Boolean isAlive;


    public Animal(String species, Double weight, Boolean isAlive) {
        this.species = species;
        this.weight = weight;
        this.isAlive = isAlive;

    }

    void feed(
    ) {
        if (this.isAlive) {
            System.out.println("Żyjęęęę!!!");
            this.weight += 0.5;
            System.out.println("Dzięki za żarło :) ");
        } else {
            System.out.println("Klapa, nie ma go już pośród żywych.");
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
}

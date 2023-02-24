package creatures;

public class FarmAnimal extends Animal{
    public FarmAnimal(String species, Double weight, Boolean isAlive) {
        super(species, weight, isAlive);
    }

    @Override
    public void beEaten(){
        System.out.println("Zjedzone");
    }


    @Override
    public void feed() {
        System.out.println("Spokojnie, karmimy, karmimy.");
    }

    @Override
    public void feed(Double foodWeight) {
        System.out.println("Spokojnie, karmimy, karmimy. " + foodWeight + " kg farmy.");
    }
}

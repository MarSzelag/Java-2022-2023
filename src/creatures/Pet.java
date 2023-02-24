package creatures;

public class Pet extends Animal{
    public Pet(String species, Double weight, Boolean isAlive) {
        super(species, weight, isAlive);
    }

    @Override
    public void feed() {
        System.out.println("Karmimy");
    }

    @Override
    public void feed(Double foodWeight) {

    }

    @Override
    void takeforWalk(Double walk_Distance) {
        super.takeforWalk(walk_Distance);
    }
}

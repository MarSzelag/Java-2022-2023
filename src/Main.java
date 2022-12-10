import animals.Animal;
import animals.Human;
import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        Car fiat1 = new Car("FSO", "125P", 1987, 1200.5, 160);
        Car fiat2 = new Car("FSO", "125P", 1987,1200.5, 160);

        Human human1 = new Human("John", "Doe");

        Animal animal1 = new Animal("Pies", 18.5, true);

        Phone phone1 = new Phone("Samsung", "A8", 2019,7.2, true);

        System.out.println("Porównuję 2 obiekty w celu sprawdzenia, czy są takie same: " + fiat1.equals(fiat2));

        fiat1.setValue(2000.00);

        human1.setSalary(500.00);
        human1.setCar(fiat1);

        System.out.println(fiat1);
        System.out.println(human1);
        System.out.println(animal1);
        System.out.println(phone1);

        fiat1.turnOn();
        phone1.turnOn();

    }
}

//Zad 7, podpunkt 7
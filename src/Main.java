import animals.Animal;
import animals.Human;
import devices.Car;
import devices.Phone;

public class Main {
    public static void main(String[] args) {
        Human human1 = new Human("Człowiek", 88.9,true,"John", "Doe");
        Human human2 = new Human("Człowiek", 67.2, true, "Christina", "Cheers");

        Car fiat1 = new Car("FSO", "125P", 1987, 1200.5, 160);
        Car fiat2 = new Car("FSO", "125P", 1987,1200.5, 160);

        Animal animal1 = new Animal("Pies", 18.5, true);

        Phone phone1 = new Phone("Samsung", "A8", 2019,7.2, true);

        human1.setSalary(2500.00);
        human2.setCash(3200.00);
        human1.setCar(fiat1);
        human1.setPet(animal1);
        human1.setPhone(phone1);

        animal1.sell(human1, human2, 142.00);
        fiat1.sell(human1, human2, 400.00);
        phone1.sell(human1, human2, 172.00);



        System.out.println("Porównuję 2 obiekty w celu sprawdzenia, czy są takie same: " + fiat1.equals(fiat2));

        fiat1.setValue(2000.00);

        fiat1.turnOn();
        phone1.turnOn();

        System.out.println(fiat1);
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(animal1);
        System.out.println(phone1);

    }
}

//Zad 8, podpunkt 5
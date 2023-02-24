import creatures.Human;
import creatures.Pet;
import devices.Electric;
import devices.Phone;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {


        Human human1 = new Human("Człowiek", 88.9, true, "John", "Doe");
        Human human2 = new Human("Człowiek", 67.2, true, "Christina", "Cheers");

        Electric fiat1 = new Electric("FSO", "266W", 2017, 1200.5, 160, 255.5);
        Electric fiat2 = new Electric("FSO", "327S", 2019, 1200.5, 160, 300.3);


        Pet animal1 = new Pet("Pies", 18.5, true);

        Phone phone1 = new Phone("Samsung", "A8", 2019, 7.2, true);

        System.out.println(animal1.toString());

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

        try {
            URL url1 = new URL("https://download.gimp.org/gimp/v2.10/windows/gimp-2.10.32-setup-1.exe");
            phone1.installAnApp(url1);
        } catch (IOException e) {
        }
        /*
        try {
            URL url1 = new URL("https://www.google.pl");
            System.out.println(url1.getHost());
            System.out.println(url1.getContent());
        }catch(Exception e){
        }*/
    }
}

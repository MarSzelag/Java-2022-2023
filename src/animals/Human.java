package animals;

import devices.Car;
import devices.Phone;

public class Human extends Animal {
    String name;
    String surname;
    private Animal pet;
    private Car car;
    private Phone phone;
    private Double salary = 0.0;
    private Double cash = 0.00;


    public void setCar(Car car) {
        if (car == null) {

        } else if (getSalary() >= car.getValue()) {
            System.out.println("Gratulacje! Udało się kupić samochód za gotówkę!");
            this.car = car;
        } else if (getSalary() >= car.getValue() / 12) {
            System.out.println("Udało się kupić samochód na kredyt.");
            this.car = car;
        } else System.out.println("Chyba czas poprosić o podwyżkę.");
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setPet(Animal pet) {
        this.pet = pet;
    }

    public Animal getPet() {
        return this.pet;
    }

    public void setCash(Double cash) {
        this.cash += cash;
    }

    public Double getCash() {
        return cash;
    }

    public Human(String species, Double weight, Boolean isAlive, String name, String surname) {
        super(species, weight, isAlive);
        this.name = name;
        this.surname = surname;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Phone getPhone() {
        return this.phone;
    }


    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        if (salary < 0) {
            System.out.println("Próbujesz przypisać ujemną kwotę. Jest to błąd. Musisz wprowadzić poprawną wartość");
        } else {
            System.out.println("Nowe dane zostały wysłane do systmu księgowego.");
            System.out.println("Proszę zgłosić się do działu kadr w celu odebrania aneksu do umowy od pani Hani.");
            System.out.println("Dane o zmianie wypłaty zostały przekazane do ZUS i US, więc jakiekolwiek próby ukrywania dochodu nie będą miały sensu.");
            this.salary = salary;
        }
    }

    @Override
    public String toString() {
        return "Imię: " + name + ", nazwisko: " + surname + ", pensja: " + salary + ", samochód: " + car; //Dlaczego ó i kawałek dalej w konsoli jest podkreślone na niebiesko?
    }

}

package animals;

import devices.Car;

public class Human {
    String name;
    String surname;
    Animal pet;
    private Car car;
    private Double salary;

    public Car getCar() {
        return car;
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setCar(Car car) {
        if (getSalary() >= car.getValue()) {
            System.out.println("Gratulacje! Udało się kupić samochód za gotówkę!");
            this.car = car;
        } else if (getSalary() >= car.getValue() / 12) {
            System.out.println("Udało się kupić samochód na kredyt.");
            this.car = car;
        } else System.out.println("Chyba czas poprosić o podwyżkę.");
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

    public String toString() {
        return "Imię: " + name + ", nazwisko: " + surname + ", pensja: " + salary + ", samochód: " + car; //Dlaczego ó i kawałek dalej w konsoli jest podkreślone na niebiesko?
    }


}

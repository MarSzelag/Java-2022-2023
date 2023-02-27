package creatures;

import devices.Car;
import devices.Phone;

import java.util.Date;

public class Human extends Animal {
    String name;
    String surname;
    private Animal pet;
    // private Car car;
    private Car[] garage = new Car[3];
    private Phone phone;
    private Double salary = 0.0;
    private Double cash = 0.00;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setCar(Car car, int position) {
        if (this.garage[position] != null) {
            System.out.println("To miejsce w garażu jest już zamknięte, musisz wybrać inne miejsce.");
        } else {
            this.garage[position] = car;
        }
    }

    public Car getCar(int position) {
        if (this.garage == null) {
            System.out.println("Na tej pozycji w garażu nie ma żadnego samochodu");
            return null;
        } else
            return garage[position];
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

    public Human(String species, Double weight, Boolean isAlive, String name, String surname, int garageSize) {
        super(species, weight, isAlive);
        this.name = name;
        this.surname = surname;
        this.garage = new Car[garageSize];
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

    public void sortCarsInGarageByDate() {
        Car temp = null;

        for (int i = 1; i <= this.garage.length - 1; i++) {
            for (int j = 1; j <= this.garage.length - 1; j++) {
            if (this.garage[j].getYearOfProduction() != null && this.garage[j].getYearOfProduction() > this.garage[j - 1].getYearOfProduction()) {
                temp = this.garage[j - 1];
                this.garage[j - 1] = this.garage[j];
                this.garage[j] = temp;
            }
            }
        }
    }

    public Double valueOfAllCarsInGarage() {
        Double result = 0.0;
        for (int i = 0; i <= this.garage.length - 1; i++) {
            result = result + this.garage[i].getValue();
        }
        return result;
    }

    @Override
    public String toString() {
        String allCars = "";
        for(int i = 0; i < this.garage.length; i++){
            if(this.garage[i] != null) {
                allCars = allCars + "\n Miejsce nr " + (i + 1) + " w garażu: " + this.garage[i].toString() + "";
            }
        }
        return "Imię: " + name + ", nazwisko: " + surname + ", pensja: " + salary + ", zawartość garażu: " + allCars;
    }

    @Override
    public void feed() {
        System.out.println("Wszamam ");
    }

    @Override
    public void feed(Double foodWeight) {
        System.out.println("Wszamam " + foodWeight + " kg żarła.");
    }

    public boolean isCarInGarage(Car car){
        boolean isThereACar = false;
        for(int i = 0; i < this.garage.length; i++){
            if(this.garage[i] != null && car.equals(this.garage[i])) {
                isThereACar = true;
            }
        }

        if(isThereACar){
            System.out.println("Tak mamy ten samochód w garażu.");
        }
        else
            System.out.println("W garażu nie ma żadnego samochodu.");

        return isThereACar;
    }

    public boolean isThereSpaceInGarage(){
        boolean isThereASpace = false;
        for(int i = 0; i < this.garage.length; i++){
            if(this.garage[i] == null)
                isThereASpace = true;
        }
        if(isThereASpace)
            System.out.println("W garażu kupującego jest wolne miejsce na samochód.");
        else
            System.out.println("Trzeba powiększyć garaż. Do tego nie da się upchnąć kolejnego auta.");
        return isThereASpace;
    }

    public void removeCarFromGarage(Car car){
        for(int i = 0; i < this.garage.length; i++){
            if(this.garage[i] != null) {
                if (this.garage[i].equals(car)) {
                    this.garage[i] = null;
                }
            }
        }
    }

    public void addACar(Car car){
        boolean flag = false;
        for(int i = 0; i < this.garage.length; i++){
            if(this.garage[i] == null && flag == false){
                this.garage[i] = car;
                //car.addOwner(this);
                if(car.numberOfTransactionsInt() == 0) {
                    car.addOwnerTransaction(new Human("Człowiek", 0.0, true, "Salon", "Salon"), this, null, new Date());
                }
                flag = true;
            }
        }
    }

}

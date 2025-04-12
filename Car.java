public class Car {
    String brand;
    String model;
    int year;
    double fuelLevel = 0.0;
    double maxFuelTankLevel;

    Car(String brand, String model, int year, double maxFuelTankLevel) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.maxFuelTankLevel = maxFuelTankLevel;
    }

    String getBrand(){
        return this.brand;
    }
    
    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    boolean hasFuel () {
        return this.getFuelLevel() > 0;
    }

    void refuel(double fuelAmount){
        if (fuelAmount<= 0) {
            System.err.println("You cannot remove fuel from the tank");
            return;
        }
        if (fuelAmount + this.fuelLevel > this.maxFuelTankLevel){
            System.err.println("You are going to overfill the tank");
            return;
        }
        this.fuelLevel += fuelAmount;
        System.out.println("Refuel completed, new amount is: " + this.getFuelLevel());
        }

    String displayInformation(){
        return "Car: " + this.getBrand() + " " + this.getModel() + " " + this.getYear();
    }

    void consumeFuel(double fuelAmount){
        if (this.fuelLevel - fuelAmount < 0){
            System.err.println("Not enough gas to complete the operation");
            return;
        }
        this.fuelLevel -= fuelAmount;
    }

    void startEngine(){
        if (this.hasFuel()){
            this.consumeFuel(0.1);
            System.out.println(this.displayInformation() + " is starting the engine");
        } else {
            System.err.println("Car has not fuel and cannot start the engine");
        }
        
    }

    public static void main(String[] args) {
        System.out.println("Hello world from a Car class");

        Car car1 = new Car ("Tesla","Model S",2024, 50 );
        car1.setFuelLevel(0.00);
        Car car2 = new Car ("Ford", "Focus", 2018, 50);
        car2.setFuelLevel(40.00);
        Car car3 = new Car ("Tesla", "Model X", 2023, 70);
        car3.setFuelLevel(30.00);

        System.out.println(car1.displayInformation());
        System.out.println(car2.displayInformation());
        System.out.println(car3.displayInformation());

        car1.startEngine();
        car2.startEngine();
        car3.startEngine();
    }

}

//possiamo incapsulare le variabili di istanza usando Getter e Setter (ctrl + . su year, model, brand e li crea da solo)
//un constructor è un metodo speciale che viene chiamato automaticamente quando un oggetto viene creato
//inizializza le variabili di istanza senza il bisogno di chiamate separate ai setter
//un costruttore ha lo stesso nome della classe (nessuna keyword prima ) e nessun tipo di ritorno
//sempre con ctrl + . Generate Constructors, flaggare tra le variabili che possono essere inizializzate quelle che ci servono
//2 costruttori con lo stesso nome dentro la stessa classe possono coesistere purchè abbiano un elenco di parametri diversi (constructor overloading)



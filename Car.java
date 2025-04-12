public class Car {
    private String brand;
    private String model;
    private int year;
    private double fuelLevel = 0.0;
    private final double maxFuelTankLevel;

    private void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand(){
        return this.brand;
    }

    private void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
    
    private void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public double getMaxFuelTankLevel() {
        return maxFuelTankLevel;
    }

    Car(String brand, String model, int year, double maxFuelTankLevel) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.maxFuelTankLevel = maxFuelTankLevel;
    }

    private void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public boolean hasFuel () {
        return this.getFuelLevel() > 0;
    }

    public void refuel(double fuelAmount){
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

    public String displayInformation(){
        return "Car: " + this.getBrand() + " " + this.getModel() + " " + this.getYear();
    }

    void consumeFuel(double fuelAmount){
        if (this.fuelLevel - fuelAmount < 0){
            System.err.println("Not enough gas to complete the operation");
            return;
        }
        this.fuelLevel -= fuelAmount;
    }

    public void startEngine(){
        if (this.hasFuel()){
            this.consumeFuel(0.1);
            System.out.println(this.displayInformation() + " is starting the engine");
        } else {
            System.err.println("Car has not fuel and cannot start the engine");
        }
        
    }
}    

//possiamo incapsulare le variabili di istanza usando Getter e Setter (ctrl + . su year, model, brand e li crea da solo)
//un constructor è un metodo speciale che viene chiamato automaticamente quando un oggetto viene creato
//inizializza le variabili di istanza senza il bisogno di chiamate separate ai setter
//un costruttore ha lo stesso nome della classe (nessuna keyword prima ) e nessun tipo di ritorno
//sempre con ctrl + . Generate Constructors, flaggare tra le variabili che possono essere inizializzate quelle che ci servono
//2 costruttori con lo stesso nome dentro la stessa classe possono coesistere purchè abbiano un elenco di parametri diversi (constructor overloading)



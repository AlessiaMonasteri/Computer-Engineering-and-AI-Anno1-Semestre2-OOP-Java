package car.generics;
/**
 * Generic Car Class
 * @author Alessia Monasteri
 * @version 13.0
 * <ul><li> {@link #hasFuel()} : Checks if the car has fuel </li></ul>
 */
public class Car implements Drivable{
    private String brand;
    private String model;
    private int year;
    private double fuelLevel = 0.0;
    private final double maxFuelTankLevel;

    public String getBrand(){
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

    public double getMaxFuelTankLevel() {
        return maxFuelTankLevel;
    }
    /**
     * Constructs a new generic car
     * @param brand
     * @param model
     * @param year
     * @param maxFuelTankLevel
     */
    public Car(String brand, String model, int year, double maxFuelTankLevel) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.maxFuelTankLevel = maxFuelTankLevel;
    }

    /**
     * This method returns the fuel level according to the internal state
     * @return Fuel level
     */
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


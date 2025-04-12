public class ElectricCar extends Car {

    private double batteryLevel;
    private final double maxBatteryCapacity;

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    ElectricCar(String brand, String model, int year, double maxBatteryCapacity) {
        super(brand, model, year, 0);
        this.batteryLevel = 0.0;
        this.maxBatteryCapacity = maxBatteryCapacity;
    }

    public void recharge(double chargeAmount){
        if (chargeAmount<= 0) {
            System.err.println("You cannot remove charge from the tank");
            return;
        }
        if (chargeAmount + this.batteryLevel > this.maxBatteryCapacity){
            System.err.println("You are going to overfill the battery");
            return;
        }
        this.batteryLevel += chargeAmount;
        System.out.println("Recharge completed, new amount is: " + this.getBatteryLevel());
        }

    @Override
    public void startEngine(){
        if (this.batteryLevel > 0){
            //this.consumeFuel(0.1);
            System.out.println(this.displayInformation() + " is starting the engine");
        } else {
            System.err.println("Car has not charge left in the battery and cannot start the engine");
        }
            
    }
    
}

public class DieselCar extends Car {

    DieselCar(String brand, String model, int year, double maxFuelTankLevel) {
        super(brand, model, year, maxFuelTankLevel);
    }

    @Override
    public void startEngine(){
    //TODO: check if the filter is clean
    super.startEngine();
            
    }
    
}

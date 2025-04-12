public class CarMain {
    public static void main(String[] args) {
        System.out.println("Hello world from a Car class");

        Car tesla = new ElectricCar("Tesla","Model S",2024, 50 );
        ((ElectricCar) tesla).recharge(20);

        DieselCar focus = new DieselCar("Ford", "Focus", 2018, 50);
        focus.refuel(40.00);

        System.out.println(tesla.displayInformation());
        System.out.println(focus.displayInformation());

        tesla.startEngine();
        focus.startEngine();
    }

}

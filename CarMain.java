public class CarMain {
    public static void main(String[] args) {
        System.out.println("Hello world from a Car class");

        Car car1 = new Car ("Tesla","Model S",2024, 50 );
        car1.refuel(0.00);
        Car car2 = new Car ("Ford", "Focus", 2018, 50);
        car2.refuel(40.00);
        Car car3 = new Car ("Tesla", "Model X", 2023, 70);
        car3.refuel(30.00);

        System.out.println(car1.displayInformation());
        System.out.println(car2.displayInformation());
        System.out.println(car3.displayInformation());

        car1.startEngine();
        car2.startEngine();
        car3.startEngine();
    }

}

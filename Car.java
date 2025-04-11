public class Car {
    String brand;
    String model;
    int year;

    public static void main(String[] args) {
        System.out.println("Hello world from a Car class");
        Car car1 = new Car ();
        car1.brand = "Tesla";
        car1.model = "Model S";
        car1.year = 2024;

        Car car2 = new Car ();
        car2.brand = "Ford";
        car2.model = "Focus";
        car2.year = 2018;

        Car car3 = new Car ();
        car3.brand = "Tesla";
        car3.model = "Model X";
        car3.year = 2023;

        System.err.println("Car 1: " + car1.brand + " " + car1.model + " " + car1.year);
        System.err.println("Car 2: " + car2.brand + " " + car2.model + " " + car2.year);
        System.err.println("Car 3: " + car3.brand + " " + car3.model + " " + car3.year);
    }

}

public class Car {
    String brand;
    String model;
    int year;

    String displayInformation(){
        return "Car: " + this.brand + " " + this.model + " " + this.year;
    }

    void startEngine(){
        System.out.println(this.displayInformation() + " is starting the engine");
    }

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

        System.out.println(car1.displayInformation());
        System.out.println(car2.displayInformation());
        System.out.println(car3.displayInformation());

        car1.startEngine();
        car2.startEngine();
        car3.startEngine();
    }

}

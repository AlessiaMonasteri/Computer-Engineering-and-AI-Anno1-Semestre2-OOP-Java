// Definizione dell'interfaccia Movable
interface Movable {
    void move();  // Metodo astratto
}

// Definizione della classe Vehicle
class Vehicle {
    // Eventuali metodi e proprietà della classe Vehicle
    public void start() {
        System.out.println("Vehicle is starting");
    }

    public void stop() {
        System.out.println("Vehicle is stopping");
    }
}

// La classe Car estende Vehicle e implementa Movable
public class Car extends Vehicle implements Movable {
    // Implementazione del metodo start()
    public void start() {
        System.out.println("Car is starting");
    }

    // Implementazione del metodo move() dell'interfaccia Movable
    public void move() {
        System.out.println("Car is moving");
    }

    // Implementazione del metodo stop()
    public void stop() {
        System.out.println("Car is stopping");
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start();
        myCar.move();
        myCar.stop();
    }
}


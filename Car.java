public class Car {
    String brand;

    String getBrand(){
        return this.brand;
    }

    void setBrand(String brand){
        this.brand = brand;
    }

    String model;
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    String displayInformation(){
        return "Car: " + this.getBrand() + " " + this.getModel() + " " + this.getYear();
    }

    void startEngine(){
        System.out.println(this.displayInformation() + " is starting the engine");
    }

    public static void main(String[] args) {
        System.out.println("Hello world from a Car class");
        Car car1 = new Car ();
        car1.setBrand("Tesla");
        car1.setModel("Model S");
        car1.setYear(2024);

        Car car2 = new Car ();
        car2.setBrand("Ford");
        car2.setModel("Focus");
        car2.setYear(2018);

        Car car3 = new Car ();
        car3.setBrand("Tesla");
        car3.setModel("Model X");
        car3.setYear(2023);

        System.out.println(car1.displayInformation());
        System.out.println(car2.displayInformation());
        System.out.println(car3.displayInformation());

        car1.startEngine();
        car2.startEngine();
        car3.startEngine();
    }

}

//possiamo incapsulare le variabili di istanza usando Getter e Setter (ctrl + . su year, model, brand e li crea da solo)


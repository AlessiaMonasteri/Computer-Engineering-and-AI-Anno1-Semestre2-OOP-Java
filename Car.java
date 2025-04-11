public class Car {
    String brand;
    String model;
    int year;

    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    String getBrand(){
        return this.brand;
    }

    // void setBrand(String brand){
    //     this.brand = brand;
    // }
    
    public String getModel() {
        return model;
    }

    // public void setModel(String model) {
    //     this.model = model;
    // }

    public int getYear() {
        return year;
    }

    // public void setYear(int year) {
    //     this.year = year;
    // }

    String displayInformation(){
        return "Car: " + this.getBrand() + " " + this.getModel() + " " + this.getYear();
    }

    void startEngine(){
        System.out.println(this.displayInformation() + " is starting the engine");
    }

    public static void main(String[] args) {
        System.out.println("Hello world from a Car class");
        Car car1 = new Car ("Tesla","Model S",2024 );
        //car1.setBrand("Tesla");
        //car1.setModel("Model S");
        //car1.setYear(2024);

        Car car2 = new Car ("Ford", "Focus", 2018);
        //car2.setBrand("Ford");
        //car2.setModel("Focus");
        //car2.setYear(2018);

        Car car3 = new Car ("Tesla", "Model X", 2023);
        //car3.setBrand("Tesla");
        //car3.setModel("Model X");
        //car3.setYear(2023);

        System.out.println(car1.displayInformation());
        System.out.println(car2.displayInformation());
        System.out.println(car3.displayInformation());

        car1.startEngine();
        car2.startEngine();
        car3.startEngine();
    }

}

//possiamo incapsulare le variabili di istanza usando Getter e Setter (ctrl + . su year, model, brand e li crea da solo)
//un constructor è un metodo speciale che viene chiamato automaticamente quando un oggetto viene creato
//inizializza le variabili di istanza senza il bisogno di chiamate separate ai setter
//un costruttore ha lo stesso nome della classe (nessuna keyword prima ) e nessun tipo di ritorno
//sempre con ctrl + . Generate Constructors, flaggare tra le variabili che possono essere inizializzate quelle che ci servono
//2 costruttori con lo stesso nome dentro la stessa classe possono coesistere purchè abbiano un elenco di parametri diversi (constructor overloading)



package company;
public class App {
    public static void main(String[] args){
        Employee emp = new Employee("John Doe", 50000);
        Manager mgr = new Manager("Jane Smith", 80000, "Finance");

        System.out.println("Employee Details:");
        emp.displayInfo();

        System.out.println("Manager Details:");
        mgr.displayInfo();
    }
}

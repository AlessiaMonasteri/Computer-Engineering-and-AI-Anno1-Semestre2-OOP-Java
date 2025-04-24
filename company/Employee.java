package company;
class Employee {
    protected String name;
    protected double salary;

    public Employee (String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public void displayInfo(){
        System.out.println("Employee: " + name + ", Salary: $" + salary);
    }
}
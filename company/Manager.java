package company;
class Manager extends Employee{
    private String department;

    public Manager (String name, double salary, String department){
        super(name, salary);
        this.department = department;
    }

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Department: " + department);
    }
}

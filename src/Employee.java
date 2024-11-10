public class Employee extends Person {
    private double salary;
    private String position;

    public Employee(int id, String name, String cpf, String email, double salary, String position) {
        super(id, name, cpf, email);
        this.salary = salary;
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

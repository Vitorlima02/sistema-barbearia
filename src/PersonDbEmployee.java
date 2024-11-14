import java.util.ArrayList;
import java.util.List;

public class PersonDbEmployee {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void updateEmployee(int id, String name, String cpf, String email) {
        Person employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(name);
            employee.setCpf(cpf);
            employee.setEmail(email);
        }
    }

    public void printEmployees() {
        for (Person person : employees) {
            System.out.println("Id: " + person.getId() + " Name: " + person.getName() + " CPF: " + person.getCpf() + " Email: " + person.getEmail());
        }
    }

}

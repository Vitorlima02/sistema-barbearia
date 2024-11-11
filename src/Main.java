import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static PersonDbUser dbUser = new PersonDbUser();
    private static PersonDbEmployee dbEmployee = new PersonDbEmployee();
    private static int id = 0;

    public static void main(String[] args) throws ParseException {

        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    createEmployee();
                    break;
                case 3:
                    showEmployee();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    return;
            }
        }


    }

    public static void showMenu() {
        System.out.println("Sistema de Agendamento Barbearia");
        System.out.println("=============================");
        System.out.println("--1: Cadastrar Cliente");
        System.out.println("--2: Cadastrar Funcionario");
        System.out.println("--3: Listar Funcionarios");
        System.out.println("--0: Sair");
        System.out.println("Informe a opção desejada: ");
    }

    public static void createUser() throws ParseException {
        System.out.println("Digite seu nome: ");
        String name = sc.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = sc.nextLine();
        System.out.println("Digite seu email: ");
        String email = sc.nextLine();
        System.out.println("Digite sua data de nascimento YYYY-MM-DD: ");
        String dataNascimento = sc.nextLine();
        SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-DD");
        Date format = f.parse(dataNascimento);
        System.out.println("Digite o genero: ");
        String genero = sc.nextLine();

        dbUser.addPerson(new User(name, cpf, email, id =+ 1, format, genero));
    }

    public static void createEmployee() throws ParseException {
        System.out.println("Digite seu nome: ");
        String name = sc.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = sc.nextLine();
        System.out.println("Digite seu email: ");
        String email = sc.nextLine();
        System.out.println("Informe o cargo do funcionario: ");
        String position = sc.nextLine();
        System.out.println("Informe o salario do funcionario: ");
        double salario = sc.nextDouble();


        dbEmployee.addEmployee(new Employee(id =+ 1, name, cpf, email, salario, position));
    }

    public static void showEmployee() throws ParseException {
        for (Employee employee : dbEmployee.getEmployees()) {
            System.out.println("Nome: " + employee.getName());
            System.out.println("CPF: " + employee.getCpf());
            System.out.println("E-mail: " + employee.getEmail());
            System.out.println("Cargo: " + employee.getPosition());
            System.out.println("Salario: " + employee.getSalary());
        }
    }
}
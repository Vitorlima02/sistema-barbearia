import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static PersonDbUser dbUser = new PersonDbUser();
    private static PersonDbEmployee dbEmployee = new PersonDbEmployee();
    private static BinaryTree binaryTree = new BinaryTree();
    private static int id = 0;

    public static void main(String[] args) throws ParseException {
        mockUsers();
        mockEmployees();

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
                    showAgendaMenu();
                    break;
                case 4:
                    showUsers();
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
        System.out.println("--3: Consulta de Agenda");
        System.out.println("--4: Listar Clientes e Funcionarios");
        System.out.println("--5: Login User");
        System.out.println("--6: Consultar suas reservas");
        System.out.println("--7: Cancelar reserva");
        System.out.println("--8: Avaliar seu atendimento");
        System.out.println("--9: Realizar pagamento");
        System.out.println("--10: Relatorio");
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
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date format = f.parse(dataNascimento);
        System.out.println("Digite o genero: ");
        String genero = sc.nextLine();

        dbUser.addPerson(new User(name, cpf, email, id =+ 1, format, genero));
    }

    public static void showUsers() throws ParseException {
        for (Person person : dbUser.getPersons()) {
            System.out.println("Nome: " + person.getName());
            System.out.println("CPF: " + person.getCpf());
            System.out.println("Email: " + person.getEmail());
            System.out.println("Id: " + person.getId());
            System.out.println("**************************");
        }
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
            System.out.println("Id: " + employee.getId());
            System.out.println("Nome: " + employee.getName());
            System.out.println("CPF: " + employee.getCpf());
            System.out.println("E-mail: " + employee.getEmail());
            System.out.println("Cargo: " + employee.getPosition());
            System.out.println("Salario: " + employee.getSalary());
            System.out.println("********************************");
        }
    }

    public static void showAgendaMenu() throws ParseException {
        System.out.println("Opções de consulta de Agenda");
        System.out.println("=============================");
        System.out.println("--1: Listar profissionais");
        System.out.println("--2: Agendar atendimento");
        System.out.println("--0: Voltar");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                showEmployee();
                break;
            case 2:
                ScheduleAppointment();
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida, tente novamente.");
        }
    }

    public static void ScheduleAppointment() throws ParseException {
        System.out.println("Listando clientes...");
        dbUser.printUsers();
        System.out.println("Escolha o Id do cliente para efetuar a reserva: ");
        int id = sc.nextInt();
        sc.nextLine();

        Person person = dbUser.getPersonById(id);

        System.out.println("Listando funcionarios...");
        dbEmployee.printEmployees();
        System.out.println("Escolha o Id do funcionario para efetuar a reserva: ");
        int id2 = sc.nextInt();
        sc.nextLine();

        Person employee = dbEmployee.getEmployeeById(id2);

        System.out.println("Escolha a data para agendamento: YYYY-MM-DD: ");
        String dataAgendamento = sc.nextLine();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date format = f.parse(dataAgendamento);

        System.out.println("Informe qual o serviço deseja realizar: ");
        String servico = sc.nextLine();

        binaryTree.insert(person);

        ScheduleAppointment appointment = new ScheduleAppointment(person, employee, format, servico);

        System.out.println("Agendamento realizado com sucesso com: " + appointment.getEmployee().getName());
    }

    public static void mockUsers() throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        dbUser.addPerson(new User("Jose", "12345678900", "jose@email.com", 1, f.parse("1985-03-15"), "m"));
        dbUser.addPerson(new User("Maria", "98765432100", "maria@email.com", 2, f.parse("1990-07-20"), "f"));
        dbUser.addPerson(new User("Ana", "45612378900", "ana@email.com", 3, f.parse("1992-11-30"), "f"));
        dbUser.addPerson(new User("Carlos", "32165498700", "carlos@email.com", 4, f.parse("1988-06-05"), "m"));
        dbUser.addPerson(new User("Pedro", "78945612300", "pedro@email.com", 5, f.parse("1983-01-10"), "m"));
        dbUser.addPerson(new User("Lucas", "65478932100", "lucas@email.com", 6, f.parse("1995-08-25"), "m"));
        dbUser.addPerson(new User("Fernanda", "12378945600", "fernanda@email.com", 7, f.parse("1991-10-12"), "f"));
        dbUser.addPerson(new User("Juliana", "98712365400", "juliana@email.com", 8, f.parse("1986-12-18"), "f"));
        dbUser.addPerson(new User("Bruno", "32198765400", "bruno@email.com", 9, f.parse("1993-02-28"), "m"));
        dbUser.addPerson(new User("Gabriela", "45698732100", "gabriela@email.com", 10, f.parse("1989-05-22"), "f"));
    }

    public static void mockEmployees() throws ParseException {
        dbEmployee.addEmployee(new Employee(1, "Fernanda", "98778965422", "fernanda@email.com", 320, "Cabelereira"));
        dbEmployee.addEmployee(new Employee(2, "Carlos", "12345678901", "carlos@email.com", 450, "Barbeiro"));
        dbEmployee.addEmployee(new Employee(3, "Juliana", "23456789012", "juliana@email.com", 350, "Manicure"));
        dbEmployee.addEmployee(new Employee(4, "Pedro", "34567890123", "pedro@email.com", 500, "Barbeiro"));
        dbEmployee.addEmployee(new Employee(5, "Lucas", "45678901234", "lucas@email.com", 320, "Recepcionista"));
        dbEmployee.addEmployee(new Employee(6, "Amanda", "56789012345", "amanda@email.com", 380, "Esteticista"));
        dbEmployee.addEmployee(new Employee(7, "Bruno", "67890123456", "bruno@email.com", 470, "Barbeiro"));
        dbEmployee.addEmployee(new Employee(8, "Mariana", "78901234567", "mariana@email.com", 360, "Cabelereira"));
        dbEmployee.addEmployee(new Employee(9, "Rafael", "89012345678", "rafael@email.com", 420, "Massagista"));
        dbEmployee.addEmployee(new Employee(10, "Bianca", "90123456789", "bianca@email.com", 340, "Depiladora"));
    }
}
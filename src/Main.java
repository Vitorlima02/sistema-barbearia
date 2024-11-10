import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
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
        System.out.println("--0: Sair");
        System.out.println("Informe a opção desejada: ");
    }
}
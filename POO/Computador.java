import java.util.ArrayList;
import java.util.Scanner;

public class Computador {

    private String username;
    private String defeito;

    public Computador(String username, String defeito) {
        this.username = username;
        this.defeito = defeito;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getUsername() {
        return username;
    }

    public String getDefeito() {
        return defeito;
    }

    public static void menu() {
        System.out.println("===== MENU =====");
        System.out.println("1 - Cadastrar computador");
        System.out.println("2 - Exibir computador");
        System.out.println("3 - Alterar uma informação");
        System.out.println("0 - Sair");
    }

    public static void main(String[] args) {

        int menu;
        String username;
        String defeito;
        boolean encontrou;

        Scanner sc = new Scanner(System.in);
        ArrayList<Computador> computadores = new ArrayList<>();

        do {
            Computador.menu();

            System.out.print("Escolha uma opção: ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {

                case 1:
                    System.out.println("Digite o username:");
                    username = sc.nextLine();

                    System.out.println("Digite o defeito:");
                    defeito = sc.nextLine();

                    Computador novoComputador = new Computador(username, defeito);

                    computadores.add(novoComputador);

                    System.out.println("Computador cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o username do computador:");
                    username = sc.nextLine();

                    encontrou = false;

                    for (Computador computador : computadores) {

                        if (username.equals(computador.getUsername())) {

                            System.out.println("===== COMPUTADOR =====");
                            System.out.println("Username: "
                                    + computador.getUsername());
                            System.out.println("Defeito: "
                                    + computador.getDefeito());

                            encontrou = true;
                            break;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Computador não encontrado.");
                    }

                    break;

                case 3:
                    System.out.println("Digite o username do computador:");
                    username = sc.nextLine();

                    encontrou = false;

                    for (Computador computador : computadores) {

                        if (username.equals(computador.getUsername())) {

                            encontrou = true;

                            System.out.println("1 - Alterar username");
                            System.out.println("2 - Alterar defeito");
                            System.out.print("Escolha: ");

                            int opcao = sc.nextInt();
                            sc.nextLine();

                            if (opcao == 1) {

                                System.out.print("Digite o novo username: ");
                                String novoUsername = sc.nextLine();

                                computador.setUsername(novoUsername);

                                System.out.println(
                                        "Username alterado com sucesso!");

                            } else if (opcao == 2) {

                                System.out.print("Digite o novo defeito: ");
                                String novoDefeito = sc.nextLine();

                                computador.setDefeito(novoDefeito);

                                System.out.println(
                                        "Defeito alterado com sucesso!");

                            } else {
                                System.out.println("Opção inválida!");
                            }

                            break;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Computador não encontrado.");
                    }

                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (menu != 0);

        sc.close();
    }
}

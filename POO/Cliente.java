import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public static void menu(){
        System.out.println("===== MENU =====");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Exibir cliente");
        System.out.println("3 - Alterar uma informação do cliente");
        System.out.println("0 - Sair");
    }

    public static void main(String[] args) {
        int menu;
        String nome;
        String email;
        boolean encontrou;
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> Clientes = new ArrayList<>();

        do {
            Cliente.menu();

            System.out.print("Escolha uma opção: ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("Digite o nome");
                    nome = sc.nextLine();

                    System.out.println("digite o email");
                    email = sc.nextLine();

                    Cliente novoCliente = new Cliente(nome, email);
                    Clientes.add(novoCliente);
                    break;

                case 2:

                    System.out.println("Digite o email do cliente");
                    email = sc.nextLine();

                    encontrou = false;

                    for (Cliente cliente : Clientes) {

                        if (email.equals(cliente.getEmail())) {

                            System.out.println("===== Cliente =====");
                            System.out.println("Nome: " + cliente.getNome());
                            System.out.println("Email: " + cliente.getEmail());

                            encontrou = true;
                            break;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Usuário não encontrado");
                    }

                    break;


                case 3:
                    System.out.println("Digite o email do cliente:");
                    email = sc.nextLine();

                    encontrou = false;

                    for (Cliente cliente : Clientes) {

                        if (email.equals(cliente.getEmail())) {

                            encontrou = true;

                            System.out.println("1 - Alterar nome");
                            System.out.println("2 - Alterar email");
                            System.out.print("Escolha: ");

                            int opcao = sc.nextInt();
                            sc.nextLine();

                            if (opcao == 1) {

                                System.out.print("Digite o novo nome: ");
                                String novoNome = sc.nextLine();
                                cliente.setNome(novoNome);

                                System.out.println("Nome alterado com sucesso!");

                            } else if (opcao == 2) {

                                System.out.print("Digite o novo email: ");
                                String novoEmail = sc.nextLine();

                                cliente.setEmail(novoEmail);

                                System.out.println("Email alterado com sucesso!");

                            } else {
                                System.out.println("Opção inválida!");
                            }

                            break;
                        }
                    }

                    if (!encontrou) {
                        System.out.println("Usuário não encontrado.");
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

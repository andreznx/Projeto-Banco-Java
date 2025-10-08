import java.util.Scanner;

class UsuarioBanco {
    private String nome;
    private int idade;
    private double saldo;

    public UsuarioBanco(String nome, int idade, double saldo) {
        this.nome = nome;
        this.idade = idade;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public void transferir(double valor) {
        saldo -= valor;
    }

    public void exibirInfo() {
        System.out.println("\n👤 Nome: " + nome +
                " | Idade: " + idade +
                " | Saldo: R$ " + String.format("%.2f", saldo));
    }
}

public class ContaBanco {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        UsuarioBanco usuario = null;
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Depósito");
            System.out.println("3 - Saque");
            System.out.println("4 - Transferência");
            System.out.println("5 - Ver dados da conta");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    entrada.nextLine(); // limpa o buffer
                    System.out.print("Digite seu nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Digite sua idade: ");
                    int idade = entrada.nextInt();

                    System.out.print("Digite o saldo inicial: ");
                    double saldoInicial = entrada.nextDouble();

                    usuario = new UsuarioBanco(nome, idade, saldoInicial);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 2:
                    if (usuario == null) {
                        System.out.println("Cadastre um usuário primeiro!");
                        break;
                    }
                    System.out.print("Valor do depósito: ");
                    double deposito = entrada.nextDouble();
                    usuario.depositar(deposito);
                    System.out.println("Depósito realizado com sucesso!");
                    break;

                case 3:
                    if (usuario == null) {
                        System.out.println("Cadastre um usuário primeiro!");
                        break;
                    }
                    System.out.print("Valor do saque: ");
                    double saque = entrada.nextDouble();
                    if (saque <= usuario.getSaldo()) {
                        usuario.sacar(saque);
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;

                case 4:
                    if (usuario == null) {
                        System.out.println("Cadastre um usuário primeiro!");
                        break;
                    }
                    System.out.print("Valor da transferência: ");
                    double transferencia = entrada.nextDouble();
                    if (transferencia <= usuario.getSaldo()) {
                        usuario.transferir(transferencia);
                        System.out.println("Transferência realizada com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;

                case 5:
                    if (usuario != null) {
                        usuario.exibirInfo();
                    } else {
                        System.out.println("Nenhum usuário cadastrado!");
                    }
                    break;

                case 6:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 6);

        entrada.close();
    }
}

import java.util.Scanner;

public class ContaBanco {
    
    public static void main(String[] args) {
        Scanner movimentacao = new Scanner(System.in);
        int saldoAtual = 0;

        System.out.print("Insira o seu saldo atual: ");
        saldoAtual = movimentacao.nextInt();

        while (true) {
            movimentacao.nextLine();
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Deposito");
            System.out.println("2 - Saque");
            System.out.println("3 - Transação");
            System.out.println("4 - Sair");
            System.out.print("Digite o número da opção: ");
            int varMovimentacao = movimentacao.nextInt();

            switch (varMovimentacao) {
                case 1:
                        System.out.println("Digite o valor do deposito: ");
                        int deposito = movimentacao.nextInt();

                        saldoAtual += deposito;

                        System.out.println("Déposito realizado com sucesso!");
                        System.out.println("Seu novo saldo é de: " + saldoAtual);
                    break;

                case 2:
                        System.out.println("Digite o valor do saque: ");
                        int saque = movimentacao.nextInt();
                        if (saque < saldoAtual ){
                            saldoAtual -= saque;
                            System.out.println("Saque realizado com sucesso!");
                            System.out.println("Seu novo saldo é de: " + saldoAtual);
                        } else {
                            System.out.println("Impossivel fazer o saque no momento!");
                        }

                break;

                case 3:
                        System.out.println("Digite o valor da transação: ");
                        int transferencia = movimentacao.nextInt();
                        if (transferencia <= saldoAtual) {
                            saldoAtual -= transferencia;
                            System.out.println("Transfêrencia realizada com sucesso!");
                            System.out.println("Seu novo saldo é de: " + saldoAtual);
                        } else {
                            System.out.print("Impossivel fazer a transação no momento!");
                        }
    
                break;

                case 4: 
                        System.out.println("Saindo... até logo!");
                        movimentacao.close();
                        return;
                default:
                        System.out.println("Opção Invalida! Tente novamente mais tarde.");
                break;
            }
        }
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double saldo = 0.0;
        double deposito = 0.0;
        double saque = 0.0;
        int opcao = 0;
        int limiteDeSaques = 3;
        boolean sair = false;

        System.out.println("\nOlá, Usuário!");
        System.out.println("Escolha uma das opções abaixo:");

        do {
            System.out.println("\nDigite 1, para ver o saldo.");
            System.out.println("Digite 2, para fazer um depósito.");
            System.out.println("Digite 3, para sacar um valor.");
            System.out.println("Digite 4, para sair.");
            System.out.print("\nOpção: ");
            opcao = scan.nextInt();

            if (opcao == 1) {
                System.out.println("\nSeu saldo atual é de R$ " + saldo);

            } else if (opcao == 2) {
                System.out.print("\nDigite o valor que deseja depositar: R$ ");
                deposito = scan.nextDouble();
                saldo = saldo + deposito;
                System.out.println("\nOperação realizada!");

            } else if (opcao == 3) {

                if (limiteDeSaques != 0) {
                    System.out.print("\nDigite o valor que será sacado: R$ ");
                    saque = scan.nextDouble();

                    if (saque <= 1000.0) {

                        if (saque > saldo) {
                            System.out.println("\nNão foi possível realizar o saque. Saldo insuficiente.");

                        } else {
                            saldo -= saque;
                            limiteDeSaques--;
                            System.out.println("\nOperação realizada!");
                        }

                    } else if (saque > 1000.0) {
                        System.out.println("\nVocê não está autorizado(a) a retirar valores acima de R$ 1000,00 por questões de segurança.");
                    }

                } else {
                    System.out.println("\nVocê atingiu o limite de saques diários!");
                }

            } else if (opcao == 0) {
                sair = true;

            } else {
                System.out.println("\nOpção inválida, tente novamente.");
            }

        } while (sair == false);

        System.out.println("\nOperação finalizada, volte sempre.");
    }
}
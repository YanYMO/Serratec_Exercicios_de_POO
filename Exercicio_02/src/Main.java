import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        int limiteDeSaques = 3;
        boolean sair = false;

        //Criação de apenas uma conta para demonstração.
        ContaBancaria conta1 = new ContaBancaria();
        conta1.numero = 1;
        conta1.titular = "João";
        conta1.saldo = 50.0;

        System.out.println("\nOlá, " + conta1.titular + "!");
        System.out.println("Escolha uma das opções abaixo:");

        do {
            System.out.println("\nDigite 1, para ver o saldo.");
            System.out.println("Digite 2, para fazer um depósito.");
            System.out.println("Digite 3, para sacar um valor.");
            System.out.println("Digite 0, para sair.");
            System.out.print("\nOpção: ");
            opcao = scan.nextInt();

            if (opcao == 1) {
                System.out.println("\nSeu saldo atual é de R$ " + conta1.saldo);

            } else if (opcao == 2) {
                conta1.depositar();

            } else if (opcao == 3) {

                if (limiteDeSaques != 0){
                    conta1.sacar();
                    limiteDeSaques--;
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


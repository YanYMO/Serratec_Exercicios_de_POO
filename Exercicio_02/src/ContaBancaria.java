import java.util.Scanner;

public class ContaBancaria {
    Integer numero;
    String titular;
    Double saldo;

    void depositar() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nDigite o valor que deseja depositar: R$ ");
        double deposito = scan.nextDouble();
        saldo = saldo + deposito;
        System.out.println("\nOperação realizada!");
    }

    void sacar() {
        Scanner scan = new Scanner(System.in);

        System.out.print("\nDigite o valor que será sacado: R$ ");
        double saque = 0;
        saque = scan.nextDouble();

        if (saque <= 1000.0) {
            if (saque > saldo) {
                System.out.println("\nNão foi possível realizar o saque. Saldo insuficiente.");

            } else {
                saldo -= saque;
                System.out.println("\nOperação realizada!");
            }
        } else if (saque > 1000.0) {
            System.out.println("\nVocê não está autorizado(a) a retirar valores acima de R$ 1000,00 por questões de segurança.");
        }
    }
}


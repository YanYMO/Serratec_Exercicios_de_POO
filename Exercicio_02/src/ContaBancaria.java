import java.util.Scanner;

public class ContaBancaria {
    private Integer numero;
    private String titular;
    private Double saldo;
    private Integer limiteDeSaques;

    public ContaBancaria(Integer numero, String titular, Double saldo, Integer limiteDeSaques) {
        setNumero(numero);
        setTitular(titular);
        setSaldo(saldo + 50);
        setLimiteDeSaques(limiteDeSaques);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        if (numero < 0){
            System.out.println("O número da conta não pode ser um número negativo!");
        } else {
            this.numero = numero;
        }
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getLimiteDeSaques(){
        return limiteDeSaques;
    }

    public void setLimiteDeSaques(Integer limiteDeSaques) {
        this.limiteDeSaques = limiteDeSaques;
    }

    void depositar() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nDigite o valor que deseja depositar: R$ ");
        double deposito = scan.nextDouble();
        setSaldo(saldo + deposito);
        System.out.println("\nOperação realizada!");
    }

    void sacar() {
        Scanner scan = new Scanner(System.in);
        double saque = 0;

        if (limiteDeSaques > 0) {
            System.out.print("\nDigite o valor que será sacado: R$ ");
            saque = scan.nextDouble();

            if (saque <= 1000.0) {
                if (saque > saldo) {
                    System.out.println("\nNão foi possível realizar o saque. Saldo insuficiente.");

                } else {
                    setSaldo(saldo - saque);
                    System.out.println("\nOperação realizada!");
                    setLimiteDeSaques(limiteDeSaques-1);
                    System.out.println(limiteDeSaques > 0 ? "Saques restantes: " + limiteDeSaques : "Número de saques diários esgotado.");
                }
            } else if (saque > 1000.0) {
                System.out.println("\nVocê não está autorizado(a) a retirar valores acima de R$ 1000,00 por questões de segurança.");
            }
        } else {
            System.out.println("\nVocê atingiu o limite de saques diários!");
        }
    }
}


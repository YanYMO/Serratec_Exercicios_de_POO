import java.time.LocalDate;
import java.util.zip.CheckedOutputStream;

public class Main {
    public static void main(String[] args) {

        try {
            Caminhao caminhao1 = new Caminhao(100000.0, LocalDate.of(2000,10,25), 200.0, "Volvo", "LOE2F23", 2.5);
            Caminhao caminhao2 = new Caminhao(150000.0, LocalDate.of(1995,5,10), 150.0, "Volvo", "BRU2K90", 1.5);
            Caminhao caminhao3 = new Caminhao(100000.0, LocalDate.of(1999,2,18), 175.0, "Volvo", "CTG6L10", 2.0);

            CarroPasseio carro1 = new CarroPasseio(65000.0, LocalDate.of(2010,7,10), 100.0, "Chevrolet", "LMD3C75");
            CarroPasseio carro2 = new CarroPasseio(80000.0, LocalDate.of(2020,3,14), 150.0, "Chevrolet", "LON2H89");
            CarroPasseio carro3 = new CarroPasseio(40000.0, LocalDate.of(2003,1,19), 60.0, "Chevrolet", "ONE9N54");

            try {
            caminhao1.alugarVeiculo(3.0, 0);
            carro1.calcularIpva();
            System.out.println("Aluguél cadastrado!");
            } catch (VeiculoException ex) {
            System.out.println("Erro: " + ex.getMensagem());
            }

            try {
            caminhao2.alugarVeiculo(1.5, 10);
            caminhao2.calcularIpva();
            System.out.println("Aluguél cadastrado!");
            } catch (VeiculoException ex) {
            System.out.println("Erro: " + ex.getMensagem());
            }

            try {
                carro1.alugarVeiculo(-1.0, 0);
                carro1.calcularIpva();
                System.out.println("Aluguél cadastrado!");
            } catch (VeiculoException ex) {
                System.out.println("Erro: " + ex.getMensagem());
            }

        } catch (VeiculoException ex) {
            System.out.println("Erro: " + ex.getMensagem());
        }
    }
}

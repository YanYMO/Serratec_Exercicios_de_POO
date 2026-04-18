import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public non-sealed class CarroPasseio extends Veiculo {

    private Double ipva;
    private Double valorAluguel;

    public CarroPasseio(Double precoFipe, LocalDate anoFabricacao, Double valorLocacaoDiaria, String marca, String placa) {
        super(precoFipe, anoFabricacao, valorLocacaoDiaria, marca, placa);
        this.ipva = 0.0;
        this.valorAluguel = 0.0;
    }

    @Override
    public void alugarVeiculo(Double pesoCarga, Integer dias) {

        if(pesoCarga < 0){
            throw new VeiculoException("Peso da carga inválido.");
        }
        if(dias <= 0) {
            throw new VeiculoException("Dias de aluguél inválidos.");
        }

        this.valorAluguel = valorLocacaoDiaria * dias;
    }

    @Override
    public void calcularIpva() {

        if(ChronoUnit.YEARS.between(LocalDate.now(), getAnoFabricacao()) > 20){
            this.ipva = IPVA.ISENT0.getImposto();
        } else {
            this.ipva = getPrecoFipe() * IPVA.CARRO_PASSEIO.getImposto();
        };
    }
}

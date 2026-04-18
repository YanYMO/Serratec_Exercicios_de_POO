import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public non-sealed class Caminhao extends Veiculo {

    private final Double capacidadeCargaToneladas;
    private Double ipva;
    private Double valorAluguel;

    public Caminhao(Double precoFipe, LocalDate anoFabricacao, Double valorLocacaoDiaria, String marca, String placa, Double capacidadeCargaToneladas) {
        super(precoFipe, anoFabricacao, valorLocacaoDiaria, marca, placa);

        if(capacidadeCargaToneladas <= 0.0 || capacidadeCargaToneladas == null) {
            throw new VeiculoException("Capacidade de carga inválida!");
        }
        this.capacidadeCargaToneladas = capacidadeCargaToneladas;
        this.ipva = 0.0;
        this.valorAluguel = 0.0;
    }

    public Double getCapacidadeCargaToneladas() {
        return capacidadeCargaToneladas;
    }

    @Override
    public void alugarVeiculo(Double pesoCarga, Integer dias) {

        if(pesoCarga <= 0){
            throw new VeiculoException("Peso de carga inválido");
        }
        if(dias <= 0) {
            throw new VeiculoException("Dias de aluguél inválidos");
        }

        this.valorAluguel = valorLocacaoDiaria * dias;

        if(pesoCarga > capacidadeCargaToneladas) {
            this.valorAluguel *= ACRESCIMO;
        }
    }

    @Override
    public void calcularIpva(){

        if(ChronoUnit.YEARS.between(LocalDate.now(), getAnoFabricacao()) > 20){
            this.ipva = IPVA.ISENT0.getImposto();
        } else {
            this.ipva = getPrecoFipe() * IPVA.CAMINHAO.getImposto();
        };
    }
}

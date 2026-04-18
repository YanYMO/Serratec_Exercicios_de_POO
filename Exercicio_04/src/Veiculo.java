import java.time.LocalDate;

public abstract sealed class Veiculo implements Fretavel, Tributavel permits Caminhao, CarroPasseio {

    protected final String placa;
    protected final String marca;
    protected Double valorLocacaoDiaria;
    protected final LocalDate anoFabricacao;
    protected Double precoFipe;

    public Veiculo(Double precoFipe, LocalDate anoFabricacao, Double valorLocacaoDiaria, String marca, String placa) {
        if(precoFipe <= 0.0 || precoFipe == null) {
            throw new VeiculoException("Preço de veículo inválido!");
        }
        if (anoFabricacao.isAfter(LocalDate.now()) || anoFabricacao == null) {
            throw new VeiculoException("Ano de fabricação inválido!");
        }
        if(valorLocacaoDiaria <= 0.0 || valorLocacaoDiaria == null) {
            throw new VeiculoException("Valor de locação inválido!");
        }
        if(marca == null || marca.isBlank()) {
            throw new VeiculoException("Não foi especificado a marca do veículo!");
        }
        if(placa == null || placa.isBlank()) {
            throw new VeiculoException("Placa de veículo inválida!");
        }
        this.precoFipe = precoFipe;
        this.anoFabricacao = anoFabricacao;
        this.valorLocacaoDiaria = valorLocacaoDiaria;
        this.marca = marca;
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public Double getValorLocacaoDiaria() {
        return valorLocacaoDiaria;
    }

    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }

    public Double getPrecoFipe() {
        return precoFipe;
    }
}

public enum IPVA {
    ISENT0 (0.0),
    CAMINHAO (0.015),
    CARRO_PASSEIO (0.04);

    Double imposto;

    IPVA(Double imposto) {
        this.imposto = imposto;
    }

    public Double getImposto() {
        return imposto;
    }
}

public class VeiculoException extends RuntimeException {

    private String mensagem;

    public VeiculoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}

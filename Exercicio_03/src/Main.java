import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Yan", "12345678901", LocalDate.of(1999,5,10));

        Pedido pedido = new Pedido(cliente);

        pedido.adicionarItem("Geladeira", 1500.0, 2);
        pedido.adicionarItem("Fogão", 300.0, 1);
        pedido.adicionarItem("Freezer", 1200.0, 1);
        pedido.adicionarItem("Kit talher", 50.0, 3);

        pedido.fecharPedido();
    }
}

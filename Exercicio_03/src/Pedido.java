import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {
    private Cliente cliente;
    private Integer codigo;
    private Double valorPedido;
    private Double valorFrete;
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.codigo = UUID.randomUUID().hashCode();
        this.valorPedido = 0.0;
        this.valorFrete = 0.0;
    }

    public void adicionarItem(String descricao, Double preco, Integer quantidade){
        ItemPedido itemPedido = new ItemPedido(descricao, preco, quantidade);
        this.valorPedido += preco * quantidade;
        itens.add(itemPedido);
    }

    public void fecharPedido(){
        if(valorPedido <= 250.0) {
            this.valorFrete = 25.0;
        }
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nRecibo de compra!\n")
                .append("------------------------------------\n")
                .append(getCliente().getNome()).append(", seu pedido:\n\n");
        for (int i = 0; i < itens.size(); i++) {
            sb.append("Item ").append(i+1).append(": ").append(getItens().get(i).getQuantidade())
                    .append("x ").append(itens.get(i).getDescricao())
                    .append(" R$ ").append(String.format("%.2f\n", itens.get(i).getPreco()));
        }
            sb.append("------------------------------------\n")
                .append("O total do seu pedido é: R$ ").append(getValorPedido());

        return sb.toString();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(Double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
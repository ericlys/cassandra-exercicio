package model;

import com.datastax.driver.core.LocalDate;
import java.util.List;

public class Pedido {
    private int codigo;
    private List<ItemPedido> itens;
    private LocalDate data;

    public Pedido(int codigo, List<ItemPedido> itens, LocalDate data) {
        this.codigo = codigo;
        this.itens = itens;
        this.data = data;
    }

    public Pedido(int codigo, ItemPedido ip, java.time.LocalDate now) {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "codigo=" + codigo +
                ", itens=" + itens +
                ", data=" + data +
                '}';
    }
}

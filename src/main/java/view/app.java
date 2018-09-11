package view;

import dao.PedidoDao;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

import java.time.LocalDate;

public class app {
    public static void main(String[] args) {
        PedidoDao dao = new PedidoDao ();
        ItemPedido ip = new ItemPedido (new Produto (1, "tv", 600), 10);
        Pedido p1 = new Pedido (1, ip, LocalDate.now ());
        System.out.println ( dao.salvarPedido (p1));
    }

}

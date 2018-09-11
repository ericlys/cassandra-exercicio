package dao;

import com.datastax.driver.core.*;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

import java.util.List;

import static database.connection.getConnection;

public class PedidoDao {

    Session session = getConnection ();

    public boolean salvarPedido(Pedido Pedido) {
        PreparedStatement statement = session.prepare ("INSERT INTO Pedido (codigo, itens, dataHora) VALUES (?,?,?)");
        BoundStatement bound = statement.bind (Pedido.getCodigo ( ), Pedido.getItens ( ), Pedido.getData ( ));
        ResultSet rs = session.execute (bound);
        return (rs.wasApplied ());
    }

    public Pedido buscarPedido(int codigo) {
        ResultSet rs = session.execute ("SELECT * FROM Pedido Where codigo =" + codigo + ";");
        List<Row> linhas = rs.all ( );
        Pedido v = null;
        for (Row r : linhas) {
            int codigo1 = r.getInt ("codigo");
            List<ItemPedido> itens = r.getList ("itens", ItemPedido.class);
            LocalDate data = r.getDate ("dataHora");

            v = new Pedido (codigo1, itens, data);
        }
        return (v);
    }

    public boolean deletePedido(int codigo){
        ResultSet rs = session.execute ("DELETE FROM Pedido WHERE codigo = "+codigo+";");
        return rs.wasApplied ();
    }

    public boolean atualizaPedido(int codigo, Produto produto){
       ResultSet rs = session.execute ("UPDATE Pedido SET produto = "+produto+" WHERE codigo = "+codigo+";");
       return rs.wasApplied ();
    }


}

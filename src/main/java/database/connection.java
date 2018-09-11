package database;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class connection {

    public static Session getConnection(){
        Cluster cluster  = Cluster.builder ().addContactPoint ("localhost").build ();

        Session session = cluster.connect ("auto");

        return session;
    }
}

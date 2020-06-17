package Utils;

import Model.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtils {

    private static java.sql.Connection _conn = null;

    public static java.sql.Connection connect(Connection c) throws ClassNotFoundException, SQLException {
        java.sql.Connection conn = null;

        if (c == null) {
            conn = null;
        } else {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + c.getHost() + "/" + c.getDb()
                    + "?useLegacyDatetimeCode=false&serverTimezone=UTC", c.getUser(), c.getPassword());
        }

        return conn;
    }

    public static java.sql.Connection getConnection() {
        if (_conn == null) {
            Connection c = new Connection();
            c.loadDataXML();
            try {
                _conn = connect(c);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.out.println("Falta la base de datos");
                System.exit(0);
                Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return _conn;
    }

    public static void closeConnection() {
        if (_conn != null) {
            try {
                _conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

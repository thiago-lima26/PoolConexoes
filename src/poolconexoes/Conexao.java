package poolconexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String url = "jdbc:mysql://localhost/bdteste";
    private static final String user = "root2";
    private static final String password = "041041";
    private static final String Driver = "com.mysql.jdbc.Driver";
    
    public static Connection conectarBD(Connection con) {
        try {
            if (con == null) {
                Class.forName(Driver);
                con = DriverManager.getConnection(url, user, password);
                System.out.println("===== Conectado =====\n");
            } else if (con.isClosed()) {
                con = null;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static void fecharConexao(Connection con) {
        
            try {
                con.close();
                System.out.println("===== Desconectado =====\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        
    }
}

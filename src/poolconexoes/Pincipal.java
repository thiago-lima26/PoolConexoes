package poolconexoes;

import java.sql.*;

public class Pincipal {
    public static void main(String[] args) throws SQLException {
	
        Connection con = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        System.out.println("\n===== Iniciando a conex�o =====");
        con = Conexao.conectarBD(con);
        stmt = con.prepareStatement("SELECT * FROM users");
        rs = stmt.executeQuery();
        
        while (rs.next()) {
            System.out.println("Usuario: " + rs.getString("username") + " Senha: "+rs.getString("senha") );
        }
        System.out.println("\n===== Finalizando a conex�o =====");
        Conexao.fecharConexao(con);
    }
}
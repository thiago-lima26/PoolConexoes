package poolconexoes;

import java.sql.*;

public class PincipalPool {

	public static void main(String[] args) throws SQLException {
        ResultSet rs;
        PreparedStatement stmt;
        
        System.out.println("\n===== Iniciando a conexão =====");
        
        for (int i=0; i<10; i++){
        	PoolConexoes poolcon = PoolConexoes.getInstance();
        				
			stmt = PoolConexoes.con.prepareStatement("SELECT * FROM users"); 
			rs = stmt.executeQuery();
			  
			while (rs.next()) { 
				System.out.println("Usuario: " + rs.getString("username") + "\t\tSenha: "+rs.getString("senha") ); 
				}
			 
            
            System.out.println("\n===== Finalizando a conexão =====");
            PoolConexoes.fecharPoolConexoes();
        }
    }
}
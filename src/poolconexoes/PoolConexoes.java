package poolconexoes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PoolConexoes {
    
    private static PoolConexoes instances[];
    private static int index;
    private static final int length = 5;
   
    private PoolConexoes() {
	
    }
	
    public static PoolConexoes getInstance(Connection con, PreparedStatement stmt, ResultSet rs) throws SQLException {
		try {
			if(instances == null) {
				criarPoolConexoes(con, stmt, rs);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
        index = (index + 1) % length;
				
        return instances[index];
	}

    private static void criarPoolConexoes(Connection con, PreparedStatement stmt, ResultSet rs) throws SQLException {
    	instances = new PoolConexoes[length];
	
		for(int i = 0; i < length; i++) {
			try {
				instances[i] = new PoolConexoes();
				Conexao.conectarBD(con);
				stmt = con.prepareStatement("SELECT * FROM users"); 
        		rs = stmt.executeQuery();
        		while (rs.next()) { 
					System.out.println("Usuario: " + rs.getString("username") + "\tSenha: " + rs.getString("senha") ); 
				}
        		
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
    }
    public static void fecharPoolConexoes(Connection con) throws SQLException{
	
    	for(int i = 0; i < length; i++) {
            try {
            	Conexao.fecharConexao(con);
            } catch (Exception e) {
				// TODO: handle exception
			}
    	}
    }
}
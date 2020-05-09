package poolconexoes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import java.sql.PreparedStatement;

public class PoolConexoes {
    
    private static PoolConexoes instances[];
    
    private static int index;
    private static final int length = 5;
    static Connection con = null;
    static ResultSet rs = null;
    static PreparedStatement stmt = null;
    
    
    private PoolConexoes() {
	
    }
	
    public static PoolConexoes getInstance() throws SQLException{
		try {
			if(instances == null) {
				criarPoolConexoes();
			}
		}catch (Exception e) {
			e.getMessage();
		}
        index = (index + 1) % length;
				
        return instances[index];
	}

    private static void criarPoolConexoes() throws SQLException{
    	instances = new PoolConexoes[length];
	
		for(int i = 0; i < length; i++) {
			
			try {
				instances[i] = new PoolConexoes();
				System.out.println("\n===== Iniciando uma conexão =====");
				con = Conexao.conectarBD(con);
				stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM users"); 
        		rs = stmt.executeQuery();
        		while (rs.next()) { 
					System.out.println("Usuario: " + rs.getString("username") + "\tSenha: " + rs.getString("senha") ); 
				}
        		
			}catch (Exception e) {
				e.getMessage();
			}
		}
		System.out.print("\n");
    }
    public void fecharPoolConexoes() throws SQLException{
	
    	for(int i = 0; i < length; i++) {
            try {
            	System.out.println("\n===== Finalizando uma conexão =====");
            	Conexao.fecharConexao(con);
            } catch (Exception e) {
				e.getMessage();
			}
    	}
    }
}
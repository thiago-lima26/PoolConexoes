package poolconexoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PincipalPool {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
	    ResultSet rs = null;
	    PreparedStatement stmt = null;
        System.out.println("\n===== Iniciando a conex�o =====");
        
        
        for(int i = 0; i<10; i++) {
        	try {
        		PoolConexoes poolcon = PoolConexoes.getInstance(con, stmt, rs);
				
        	}catch (Exception e) {
				// TODO: handle exception
			}finally {
				System.out.println("\n===== Finalizando a conex�o =====");
		        PoolConexoes.fecharPoolConexoes(con);
			}
        }
    }
}
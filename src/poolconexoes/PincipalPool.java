package poolconexoes;

import java.sql.SQLException;

public class PincipalPool {

	public static void main(String[] args) throws SQLException {
		PoolConexoes poolcon = null;
        for(int i = 0; i<10; i++) {
        	poolcon = PoolConexoes.getInstance();
        	System.out.println(poolcon);
        }
        poolcon.fecharPoolConexoes();
	}
}
package poolconexoes;

import java.sql.Connection;
import java.sql.SQLException;

public class PoolConexoes {
    
    private static PoolConexoes instances[];
    static final Connection con = null;
    private static int index;
    private static final int length = 5;
   
    private PoolConexoes() {
	
    }
	
    public static PoolConexoes getInstance() throws SQLException {
		try {
			if(instances == null) {
				criarPoolConexoes();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
        index = (index + 1) % length;
				
        return instances[index];
	}

    private static void criarPoolConexoes() throws SQLException {
    	instances = new PoolConexoes[length];
	
		for(int i = 0; i < length; i++) {
			instances[i] = new PoolConexoes();
			Conexao.conectarBD(con);
		}
    }
    public static void fecharPoolConexoes() {
	
    	for(int i = 0; i < length; i++) {
            Conexao.fecharConexao(con);
    	}
    }

	public Connection getCon() {
		return con;
	}
}
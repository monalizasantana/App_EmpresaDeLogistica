package persistenciaSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {

	
	    private static final String URI = "jdbc:postgresql://localhost:5432/veiculo_santana";
	    private static final String USUARIO = "postgres";
	    private static final String SENHA = "123456";
	    private static Connection conn = null;

	    public Connection getConexao() throws SQLException {

	        try {
	            if (ConnectionDB.conn != null) {
	                return conn;
	            }

	            Class.forName("org.postgresql.Driver");
	            conn = (Connection) DriverManager.getConnection(URI, USUARIO, SENHA);
	            System.out.println("Conectado com sucesso");
	            return conn;

	        } catch (ClassNotFoundException | SQLException e) {
	        }

	        return null;
	    }

	}



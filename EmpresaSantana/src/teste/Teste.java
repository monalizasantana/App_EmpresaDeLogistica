package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.postgresql.Driver;

public class Teste {

	public void run() throws SQLException, ClassNotFoundException {
		
		DriverManager.registerDriver(new Driver());
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"123456");
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO VEICULO(capacidade,longitude, latitude) VALUES(?, ?, ?)");
		stmt.setDouble(10,8);
		stmt.setDouble(2, 0);
		stmt.setDouble(3, 25);
		int linhas = stmt.executeUpdate();
		System.out.println("Linhas afetadas: " + linhas);
		stmt.close();
		conn.close();
	}

	public void run2() throws SQLException, ClassNotFoundException {
		DriverManager.registerDriver(new Driver());
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"123456");
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Drones");
		ResultSet rSet = stmt.executeQuery();
		while (rSet.next())
			System.out.println(rSet.getDouble("capacidade") + "- " +rSet.getDouble("Longitude") + "- " + rSet.getString("Latitude"));
		rSet.close();
		stmt.close();
		conn.close();
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// (new TesteJDBC()).run2();
		System.out.println("Finalizando...");
	}

}

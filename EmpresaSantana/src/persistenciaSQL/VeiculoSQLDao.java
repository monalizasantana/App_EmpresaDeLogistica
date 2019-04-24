package persistenciaSQL;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidades.Drones;
import entidades.Terrestre;
import entidades.VeiculosAutonomos;
import persistencia.VeiculoDAO;

public class VeiculoSQLDao implements VeiculoDAO {


	private ConnectionDB conexao = new ConnectionDB();
	private static final String SAVE = "INSERT INTO veiculo(id,latitude, longitude, capacidade, tipoVeiculo) VALUES(?,?, ?, ?, ?)";
	private static final String SELECT = "SELECT * FROM VEICULO where capacidade >= ? ";
	private static final String UPDATE_POSIÇAO = "UPDATE VEICULO set latitude =?, longitude =? WHERE id =?;";


	public void atualizarPosicao(VeiculosAutonomos veiculo) throws Exception {
		PreparedStatement stmt = this.conexao.getConexao().prepareStatement(VeiculoSQLDao.UPDATE_POSIÇAO);
		stmt.setDouble(1, veiculo.getLatitude());
		stmt.setDouble(2, veiculo.getLongitude());
		stmt.setString(3, veiculo.getId());
		stmt.executeUpdate();
		stmt.close();
	}

	public void salvar(VeiculosAutonomos veiculo) throws Exception {
		PreparedStatement stmt = this.conexao.getConexao().prepareStatement(VeiculoSQLDao.SAVE);
		stmt.setString(1, veiculo.getId());
		stmt.setDouble(2, veiculo.getLatitude());
		stmt.setDouble(3, veiculo.getLongitude());
		stmt.setDouble(4, veiculo.getCapacidade());
		if (veiculo instanceof Terrestre) {
			stmt.setString(5, "T");
		} else if (veiculo instanceof Drones) {
			stmt.setString(5, "D");
		}
		stmt.executeUpdate();
		stmt.close();
	}

	public List<VeiculosAutonomos> buscarPorCapacidade(double peso) throws Exception {

		PreparedStatement stmt;
		List<VeiculosAutonomos> veiculos = new ArrayList<VeiculosAutonomos>();
		try {
			stmt = this.conexao.getConexao().prepareStatement(SELECT);
			stmt.setDouble(1, peso);
			ResultSet result = stmt.executeQuery();
			while (result.next()) {
				VeiculosAutonomos veiculo = null;
				if (result.getString("tipoVeiculo").equals("T")) {
					veiculo = new Terrestre(result.getString("id"), result.getDouble("capacidade"),
							result.getDouble("longitude"), result.getDouble("latitude"));

				} else if (result.getString("tipoVeiculo").equals("D")) {
					veiculo = new Drones(result.getString("id"), result.getDouble("capacidade"),
							result.getDouble("longitude"), result.getDouble("latitude"));
				} else {
					throw new Exception("Tipo de Veiculo Invalido!!!");
				}
				veiculos.add(veiculo);
			}
		} catch (SQLException e) {
			throw new Exception("Busca Invalida!!!");
		}
		stmt.close();
		return veiculos;
	}

}

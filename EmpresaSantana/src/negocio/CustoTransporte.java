package negocio;

import java.util.List;
import entidades.VeiculosAutonomos;
import persistenciaSQL.VeiculoSQLDao;

public class CustoTransporte {

	public double calcularCustoCorrida(VeiculosAutonomos veiculo, double peso, Double longitudeOrigem,
			Double latitudeOrigem, Double longitudeDestino, Double latitudeDestino) throws Exception {

		if (peso > veiculo.getCapacidade()) {
			throw new Exception("O peso da carga é maior que o do veículo.");
		}

		double valor = veiculo.getDistancia(longitudeOrigem, latitudeOrigem, longitudeDestino, latitudeDestino)
				* veiculo.getTaxaCorrida() * peso;
		if (valor < veiculo.getTaxaMinima()) {
			valor = veiculo.getTaxaMinima();
		}
		return valor;
	}

	public VeiculosAutonomos buscarVeiculoMenorValor(double peso, double longitudeOrigem, double latitudeOrigem,
			double longitudeDestino, double latitudeDestino) throws Exception {

		VeiculoSQLDao sql = new VeiculoSQLDao();

		List<VeiculosAutonomos> veiculos = sql.buscarPorCapacidade(peso);

		if (veiculos.isEmpty()) {
			throw new Exception("Não exitem Veiculos Cadastrado para essa CAPACIDADE!!!");
		}
		VeiculosAutonomos menor = veiculos.get(0);

		for (VeiculosAutonomos veiculo : veiculos) {
			if (calcularCustoCorrida(veiculo, peso, longitudeOrigem, latitudeOrigem, longitudeDestino,
					latitudeDestino) < calcularCustoCorrida(menor, peso, longitudeOrigem, latitudeOrigem,
							longitudeDestino, latitudeDestino)) {

				menor = veiculo;
			}
		}
		return menor;
	}

	public void aceitarCorrida(VeiculosAutonomos veiculo, Double longitudeDestino, Double latitudeDestino)
			throws Exception {

		VeiculoSQLDao update = new VeiculoSQLDao();
		veiculo.setLatitude(latitudeDestino);
		veiculo.setLongitude(longitudeDestino);
		update.atualizarPosicao(veiculo);

	}

}

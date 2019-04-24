package controle;

import entidades.VeiculosAutonomos;
import negocio.CustoTransporte;

public class Controle {

	CustoTransporte custo = new CustoTransporte();

	public double calcularCustoCorrida(VeiculosAutonomos veiculo, double peso, Double longitudeOrigem,
			Double latitudeOrigem, Double longitudeDestino, Double latitudeDestino) throws Exception {

		return custo.calcularCustoCorrida(veiculo, peso, longitudeOrigem, latitudeOrigem, longitudeDestino,
				latitudeDestino);
	}

	public VeiculosAutonomos buscarVeiculoMenorValor(double peso, double longitudeOrigem, double latitudeOrigem, double longitudeDestino,
			double latitudeDestino) throws Exception {

		VeiculosAutonomos veiculo = custo.buscarVeiculoMenorValor(peso, longitudeOrigem, latitudeOrigem, longitudeDestino, latitudeDestino);
		
		System.out.println("O veiculo mais barato é o " +veiculo.getId()+" e custa "+
				custo.calcularCustoCorrida(veiculo, peso, longitudeOrigem, latitudeOrigem, longitudeDestino, latitudeDestino));
		
		return veiculo;
	}
	
	public void aceitarCorrida(VeiculosAutonomos veiculo, Double longitudeDestino, Double latitudeDestino){
		try {
			custo.aceitarCorrida(veiculo, longitudeDestino, latitudeDestino);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

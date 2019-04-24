package entidades;

public class Corrida {

	private double longitudeOrigem;
	private double latitudeOrigem;
	private double longitudeDestino;
	private double latitudeDestino;
	private double valor;
	private double peso;
	private VeiculosAutonomos veiculo;

	
	public double getLongitudeOrigem() {
		return longitudeOrigem;
	}

	public void setLongitudeOrigem(double longitudeOrigem) {
		this.longitudeOrigem = longitudeOrigem;
	}

	public double getLatitudeOrigem() {
		return latitudeOrigem;
	}

	public void setLatitudeOrigem(double latitudeOrigem) {
		this.latitudeOrigem = latitudeOrigem;
	}

	public double getLongitudeDestino() {
		return longitudeDestino;
	}

	public void setLongitudeDestino(double longitudeDestino) {
		this.longitudeDestino = longitudeDestino;
	}

	public double getLatitudeDestino() {
		return latitudeDestino;
	}

	public void setLatitudeDestino(double latitudeDestino) {
		this.latitudeDestino = latitudeDestino;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public VeiculosAutonomos getVeiculos() {
		return veiculo;
	}

	public void setVeiculos(VeiculosAutonomos veiculos) {
		this.veiculo = veiculos;
	}


}

package entidades;

public abstract class VeiculosAutonomos {

	private String id;
	private double capacidade;
	private double longitude;
	private double latitude;
	private double taxaCorrida;
	private double taxaMinima;

	public VeiculosAutonomos(String id, double capacidade, double longitude, double latitude, double taxaCorrida,
			double taxaMinima) {
		super();
		this.id = id;
		this.capacidade = capacidade;
		this.longitude = longitude;
		this.latitude = latitude;
		this.taxaCorrida = taxaCorrida;
		this.taxaMinima = taxaMinima;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(double capacidade) {
		this.capacidade = capacidade;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public double getTaxaCorrida() {
		return taxaCorrida;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getTaxaMinima() {
		return taxaMinima;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public abstract double getDistancia(double longitudeOrigem, double latitudeOrigem, double longitudeDestino,
			double latitudeDestino);

}

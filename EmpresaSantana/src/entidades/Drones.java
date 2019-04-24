package entidades;

public class Drones extends VeiculosAutonomos {
	public Drones(String id, double capacidade, double longitude, double latitude) {
		super(id, capacidade, longitude, latitude, 1.25, 40);
	}

	//@Override
	public double getDistancia(double longitudeOrigem, double latitudeOrigem, double longitudeDestino,
			double latitudeDestino) {
		double dist1 = Math
				.sqrt(Math.pow(getLatitude() - latitudeOrigem, 2) + Math.pow(getLongitude() - longitudeOrigem, 2));
		double dist2 = Math
						.sqrt(Math.pow(latitudeOrigem - latitudeDestino, 2) + Math.pow(longitudeOrigem - longitudeDestino, 2));
		return dist1 + dist2;
	}

}

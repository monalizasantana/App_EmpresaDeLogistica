package entidades;

public class Terrestre extends VeiculosAutonomos {

	public Terrestre(String id, double capacidade, double longitude, double latitude) {
		super(id, capacidade, longitude, latitude, 1, 30);
	}

	@Override
	public double getDistancia(double longitudeOrigem, double latitudeOrigem, double longitudeDestino,
			double latitudeDestino) {
		double desX = getLatitude() - latitudeOrigem;
		if (desX < 0) {
			desX = desX * (-1);
		}
		double desY = getLongitude() - longitudeOrigem;
		if (desY < 0) {
			desY = desY * (-1);
		}
		double dist1 = desX + desY;
		
		double deslocX = latitudeOrigem - latitudeDestino;
		if (deslocX < 0) {
			deslocX = deslocX * (-1);
		}
		double deslocY = longitudeOrigem - longitudeDestino;
		if (deslocY < 0) {
			deslocY = deslocY * (-1);
		}
		double dist2 = deslocX + deslocY;
		return dist1 + dist2;
	}

}

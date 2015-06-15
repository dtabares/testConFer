
public class Estacion {
	
	//EstacionId,EstacionNombre,cLat,cLong

	private int estacionId;
	private String estacionNombre;
	private double cLat;
	private double cLong;
	
	public Estacion(int estacionId, String estacionNombre, double cLat, double cLong) {
		super();
		this.estacionId = estacionId;
		this.estacionNombre = estacionNombre;
		this.cLat = cLat;
		this.cLong = cLong;
	}

	// Getters & Setters
	

	public int getEstacionId() {
		return estacionId;
	}

	public String getEstacionNombre() {
		return estacionNombre;
	}

	public double getcLat() {
		return cLat;
	}

	public double getcLong() {
		return cLong;
	}
	
}

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Recorrido {
    
	//usuarioid	bicicletaid	origenfecha	origenestacionid	origennombre	destinofecha	destinoestacionid	destinonombre	tiempouso


	private int usuarioid;
	private int bicicletaid;
    private String origenfecha;
    private int origenestacionid;
    private String origennombre;
    private String destinofecha;
    private int destinoestacionid;
    private String destinonombre;
    private String tiempouso;
    


    public Recorrido(String usuarioid, String bicicletaid, String origenfecha, String origenestacionid, String origennombre, String destinofecha,String destinoestacionid,String destinonombre, String tiempouso) {
		super();
		this.usuarioid = Integer.parseInt(usuarioid);
		this.bicicletaid = Integer.parseInt(bicicletaid);
		this.origenfecha = origenfecha;
		this.origenestacionid = Integer.parseInt(origenestacionid);
		this.origennombre = origennombre;
		this.destinofecha = destinofecha;
		this.destinoestacionid = Integer.parseInt(destinoestacionid);
		this.destinonombre = destinonombre;
		this.tiempouso = tiempouso;
	
    }
    
    // Getters & Setters

	public int getUsuarioid() {
		return usuarioid;
	}



	public int getBicicletaid() {
		return bicicletaid;
	}



	public String getOrigenfecha() {
		return origenfecha;
	}



	public int getOrigenestacionid() {
		return origenestacionid;
	}



	public String getOrigennombre() {
		return origennombre;
	}



	public String getDestinofecha() {
		return destinofecha;
	}



	public int getDestinoestacionid() {
		return destinoestacionid;
	}



	public String getDestinonombre() {
		return destinonombre;
	}



	public String getTiempouso() {
		return tiempouso;
	}

}

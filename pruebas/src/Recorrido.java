import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


public class Recorrido {


	private String usuarioid;
	private String bicicletaid;
    private GregorianCalendar origenfecha;
    private String origenestacionid;
    private String origennombre;
    private GregorianCalendar destinofecha;
    private String destinoestacionid;
    private String destinonombre;
    private int tiempouso;
    
    public Recorrido(String usuarioid, String bicicletaid, String origenfecha, String origenestacionid, String origennombre, String destinofecha,String destinoestacionid,String destinonombre, String tiempouso) {

		this.usuarioid = usuarioid;
		this.bicicletaid = bicicletaid;
		this.origenfecha = this.convertDateStringToGregorianCalendar(origenfecha);
		this.origenestacionid = origenestacionid;
		this.origennombre = origennombre;
		this.destinofecha = this.convertDateStringToGregorianCalendar(destinofecha);
		this.destinoestacionid = destinoestacionid;
		this.destinonombre = destinonombre;
		
		if (tiempouso!=null){
			
			this.tiempouso = Integer.parseInt(tiempouso);
		}
		
		else {
			
			this.tiempouso = 0;
			
		}
		

    }
    
	private GregorianCalendar convertDateStringToGregorianCalendar(String origenfecha){
		//2010-12-30 19:39:03
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = df.parse(origenfecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal;
	}
	

    // Getters & Setters

	public String getUsuarioid() {
		return usuarioid;
	}

	public String getBicicletaid() {
		return bicicletaid;
	}

	public GregorianCalendar getOrigenfecha() {
		return origenfecha;
	}

	public String getOrigenestacionid() {
		return origenestacionid;
	}

	public String getOrigennombre() {
		return origennombre;
	}

	public GregorianCalendar getDestinofecha() {
		return destinofecha;
	}

	public String getDestinoestacionid() {
		return destinoestacionid;
	}

	public String getDestinonombre() {
		return destinonombre;
	}

	public int getTiempouso() {
		return tiempouso;
	}

}

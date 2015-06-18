import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class Recorrido {

	//usuarioid	bicicletaid	origenfecha	origenestacionid	origennombre	destinofecha	destinoestacionid	destinonombre	tiempouso


	private int usuarioid;
	private int bicicletaid;
    private GregorianCalendar origenfecha;
    private int origenestacionid;
    private String origennombre;
    private GregorianCalendar destinofecha;
    private int destinoestacionid;
    private String destinonombre;
    private String tiempouso;



    public Recorrido(String usuarioid, String bicicletaid, String origenfecha, String origenestacionid, String origennombre, String destinofecha,String destinoestacionid,String destinonombre, String tiempouso) {
		super();
		this.usuarioid = Integer.parseInt(usuarioid);
		this.bicicletaid = Integer.parseInt(bicicletaid);
		this.origenfecha = this.convertDateStringToGregorianCalendar(origenfecha) ;
		this.origenestacionid = Integer.parseInt(origenestacionid);
		this.origennombre = origennombre;
		this.destinofecha = this.convertDateStringToGregorianCalendar(destinofecha);
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



	public GregorianCalendar getOrigenfecha() {
		return origenfecha;
	}



	public int getOrigenestacionid() {
		return origenestacionid;
	}



	public String getOrigennombre() {
		return origennombre;
	}



	public GregorianCalendar getDestinofecha() {
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
		System.out.println(cal.toString());
		return cal;
	}

}

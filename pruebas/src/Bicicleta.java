import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by dtabar on 6/14/15.
 */
public class Bicicleta {

    //usuarioid	bicicletaid	origenfecha	origenestacionid
    // origennombre	destinofecha	destinoestacionid	destinonombre	tiempouso

    private String usuarioid;
    private String bicicletaid;
    private String origenestacionid;
    private String destinoestacionid;
    private String origennombre;
    private String destinonombre;
    private GregorianCalendar origenfecha;
    private GregorianCalendar destinofecha;
    private double tiempouso;

    public Bicicleta(String usuarioid, String bicicletaid, String origenestacionid, String destinoestacionid, String origennombre,String destinonombre, GregorianCalendar origenfecha,GregorianCalendar destinofecha,double tiempouso ){
        this.usuarioid = usuarioid;
        this.bicicletaid = bicicletaid;
        this.origenestacionid = origenestacionid;
        this.destinoestacionid = destinoestacionid;
        this.origennombre = origennombre;
        this.destinonombre = destinonombre;
        this.origenfecha = origenfecha;
        this.destinofecha= destinofecha;
        this.tiempouso = tiempouso;
    }

    public String getUsuarioid() {
        return usuarioid;
    }

    public String getBicicletaid() {
        return bicicletaid;
    }

    public String getOrigenestacionid() {
        return origenestacionid;
    }

    public String getDestinoestacionid() {
        return destinoestacionid;
    }

    public String getOrigennombre() {
        return origennombre;
    }

    public String getDestinonombre() {
        return destinonombre;
    }

    public GregorianCalendar getOrigenfecha() {
        return origenfecha;
    }

    public GregorianCalendar getDestinofecha() {
        return destinofecha;
    }

    public double getTiempouso() {
        return tiempouso;
    }

    public void toYML(String path){
        Path file = Paths.get(path);
        List<String> lines = new ArrayList<>();
        lines.add("ID Usuario: " + this.getUsuarioid());
        lines.add("ID Bicibleta: " + this.getBicicletaid());
        lines.add("Trayecto:");
        lines.add("     Origen: " + this.getOrigennombre());
        lines.add("     Destino: " + this.getDestinonombre());

        try {
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

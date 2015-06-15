import org.junit.Test;

import java.util.GregorianCalendar;

/**
 * Created by dtabar on 6/15/15.
 */
public class BicicletaTest {

    @Test
    public void prueba1(){
        GregorianCalendar fecha = new GregorianCalendar(2015,6,15);
        Bicicleta bicicleta = new Bicicleta("juancitoDeCABA","bici1","origen1","destino1","Palermo","Caballito",fecha,fecha,20);

        bicicleta.toYML("/projects/aydoo/testConFer/pruebas/resources/output.yml");

    }
}

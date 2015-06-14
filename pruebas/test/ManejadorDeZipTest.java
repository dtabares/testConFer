import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;


/**
 * Created by dtabar on 6/14/15.
 */
public class ManejadorDeZipTest {

    @Test
    public void cuandoAbroElContenidoDelZipDeRecorridos2010LaCantidadDeARchivosContenidosDebeSer4(){
        ManejadorDeZip manejadorDeZip = new ManejadorDeZip();

        System.out.println(System.getProperty("os.name"));
        if (System.getProperty("os.name").equals("Linux")){
            manejadorDeZip.openZipFile("/projects/aydoo/testConFer/pruebas/resources/recorridos-2010.zip");
        }
        else{
            manejadorDeZip.openZipFile("Pone tu path al archivo aca amigacho");
        }

        Assert.assertEquals(manejadorDeZip.getNumberOfElements(),4);
    }

    @Test
    public void cuandoElPathApuntaAUnDirectorioInexistenteDebeLanzarUnaExcepcion(){
        ManejadorDeZip manejadorDeZip = new ManejadorDeZip();
        ExpectedException exception = ExpectedException.none();

        exception.expect(IOException.class);
        if (System.getProperty("os.name").equals("Linux")){
            manejadorDeZip.openZipFile("/projects/aydoo/testConFer/pruebas/resource/recorridos-2010.zip");
        }
        else{
            manejadorDeZip.openZipFile("Pone tu path al archivo aca amigacho");
        }
    }
}

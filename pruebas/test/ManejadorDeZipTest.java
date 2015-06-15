
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;


/**
 * Created by dtabar on 6/14/15.
 */
public class ManejadorDeZipTest {

    @Test
    public void cuandoAbroElContenidoDelZipDeRecorridos2010LaCantidadDeARchivosContenidosDebeSer2(){
        ManejadorDeZip manejadorDeZip = new ManejadorDeZip();

        if (System.getProperty("os.name").equals("Linux")){
            manejadorDeZip.openZipFile("/projects/aydoo/testConFer/pruebas/resources/recorridos-2010.zip");
        }
        else{
            manejadorDeZip.openZipFile("C:\\GitProjects\\RepositorioDeArchivos\\bicicletas-publicas.zip");
        }

        Assert.assertEquals(manejadorDeZip.getNumberOfElements(),2);
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
            manejadorDeZip.openZipFile("C:\\GitProjects\\RepositorioDeArchivos\\bicicletas-publicas.zip");
        }
    }


    @Test
    public void cuandoLePidoLaInfoDeUnaEntryValidaMeLaDebeDar(){
        ManejadorDeZip manejadorDeZip = new ManejadorDeZip();
        if (System.getProperty("os.name").equals("Linux")){
            manejadorDeZip.openZipFile("/projects/aydoo/testConFer/pruebas/resources/recorridos-2010.zip");
        }
        else{
            manejadorDeZip.openZipFile("Pone tu path al archivo aca amigacho");
        }

        String text = manejadorDeZip.getEntryContent(manejadorDeZip.getEntry("recorridos-2010a.csv"));

        System.out.println(text);

    }
}

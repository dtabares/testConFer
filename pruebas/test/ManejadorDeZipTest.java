
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by dtabar on 6/14/15.
 */
public class ManejadorDeZipTest {
	
	private String path;
	
	@BeforeClass
	public void setearConfiguracionDeSO(){
        
		if (System.getProperty("os.name").equals("Linux")){
			
           this.path="/projects/aydoo/testConFer/pruebas/resources/recorridos-2010.zip";
        
		}
        
		else{
			
			this.path="C:\\GitProjects\\RepositorioDeArchivos\\bicicletas-publicas.zip";
        }
		
		
	}

    @Test
    public void cuandoAbroElContenidoDelZipDeRecorridos2010LaCantidadDeARchivosContenidosDebeSer2(){
        ManejadorDeZip manejadorDeZip = new ManejadorDeZip();
        manejadorDeZip.openZipFile(path);
        
        Assert.assertEquals(manejadorDeZip.getNumberOfElements(),4);
    }

    @Test
    public void cuandoElPathApuntaAUnDirectorioInexistenteDebeLanzarUnaExcepcion(){
        ManejadorDeZip manejadorDeZip = new ManejadorDeZip();
        ExpectedException exception = ExpectedException.none();

        exception.expect(IOException.class);
        manejadorDeZip.openZipFile(path);
    }


    @Test
    public void cuandoLePidoLaInfoDeUnaEntryValidaMeLaDebeDar(){
        ManejadorDeZip manejadorDeZip = new ManejadorDeZip();
        manejadorDeZip.openZipFile(path);

        String text = manejadorDeZip.getEntryContent(manejadorDeZip.getEntry("recorridos-2010a.csv"));

        //System.out.println(text);
        //System.out.println(Arrays.toString(text.split(";")));

        Scanner scanner = new Scanner(text);
        while (scanner.hasNextLine()) {
            //Leo Linea a Linea
            String line = scanner.nextLine();
            //Lo spliteo, aca en vez de imprimirlo, lo recorremos y le vamos dando el valor a nuestros objetos
            System.out.println(Arrays.toString(line.split(";")));
        }

    }

}

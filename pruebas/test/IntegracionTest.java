import org.junit.BeforeClass;
import org.junit.Test;


public class IntegracionTest {

	
	static String path;
	
	@BeforeClass
	public static void setearConfiguracionDeSO(){
        
		if (System.getProperty("os.name").equals("Linux")){

			path = "/projects/aydoo/testConFer/pruebas/resources/recorridos-2010.zip";
        
		}
        
		else{
			
			path = "C:\\GitProjects\\RepositorioDeArchivos\\bicicletas-publicas.zip";
        }
		
		
	}
	

	@Test
	public void abrirUnArchivoZipYProcesarArchivoDeRecorridos(){
		
		ManejadorDeZip manejadorDeZip = new ManejadorDeZip();
		manejadorDeZip.openZipFile(path);
		
		System.out.println(manejadorDeZip.getEntries());
		
		
	}
	
}

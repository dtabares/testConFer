import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class GeneradorDeEstadisticasTest {
	
	/*
	 * Formato de salida 
	 * El resultado del procesamiento sera un archivo en formato YAML (ejemplo de archivo YAML, no es necesario usar ninguna libreria,
	 * el formato es muy simple) con la siguiente informacion:
	 * 
	 * bicicleta utilizada mas veces
	 * bicicleta utilizada menos veces
	 * recorrido mas veces realizado (par origen-destino)
	 * tiempo promedio de uso
	 * 
	 * Ejemplo de archivo de salida:
	 * 
	 * Bicicletas mas usadas:
	 * id: 419
	 * Bicicletas menos usadas:
	 * id: 452
	 * id: 464
	 * Recorrido mas realizado:
	 * id origen: 5
	 * id destino: 5
	 * Tiempo promedio de uso: 42.0
	 * 
	 */
	
	static String path;

	
	@BeforeClass
	public static void setearConfiguracionDeSO(){
        
		if (System.getProperty("os.name").equals("Linux")){

			path = "/projects/aydoo/testConFer/pruebas/resources/recorridos-2010.zip";
        
		}
        
		else{
			
			path = "C:\\GitProjects\\RepositorioDeArchivos\\recorridos-2010.zip";

        }
		
		
	}

	@Test
	public void leeTodasLineasDeUnArchivoCsvYDevuelveLaBicicletaMasYMenosUsada() throws IOException{
		
		ManejadorDeZip manejadorDeZip = new ManejadorDeZip();
        manejadorDeZip.openZipFile(path);
        
        //Creo un scanner a traves de un Entry
        Scanner scanner = new Scanner(manejadorDeZip.getZip().getInputStream(manejadorDeZip.getEntry("recorridos-2010a.csv")));

        //Saco la linea de campos
        scanner.nextLine();
        
        //Creo una lista de recorridos
		List<Recorrido> listaDeRecorridos = new LinkedList<Recorrido>();
		
		//Voy agregando a la lista los valores de la linea encapsulados en un objeto "Recorrido"
		for (int i=0; i<3158; i++) {
			
			String linea = scanner.nextLine();
			String[] array = new String[9];
			int j=0;
			
			for (String valor: linea.split(";")){
		        
				array[j]=valor;			
				j++;
		      
			}
			
			listaDeRecorridos.add(new Recorrido(array[0],array[1],array[2],array[3],array[4],array[5],array[6],array[7],array[8]));
		
		}
		
		/*
		//Corroboro los valores de la lista
		for (Recorrido recorrido : listaDeRecorridos){
			
			System.out.println(recorrido.getUsuarioid());
			
		}
		*/
		
		GeneradorDeEstadisticas miGeneradorDeEstadisticas = new GeneradorDeEstadisticas();
		miGeneradorDeEstadisticas.setListaDeRecorridos(listaDeRecorridos);
		
		//Devuelve Id 419 corroborado en un archivo de excel
		System.out.println(miGeneradorDeEstadisticas.bicicletaMasUsada(listaDeRecorridos));
		Assert.assertEquals(419, miGeneradorDeEstadisticas.bicicletaMasUsada(listaDeRecorridos));
		
		//Hay 2 valores de bicicletas usadas 1 vez, devuelve la primera 452
		System.out.println(miGeneradorDeEstadisticas.bicicletaMenosUsada(listaDeRecorridos));
		Assert.assertEquals(452, miGeneradorDeEstadisticas.bicicletaMenosUsada(listaDeRecorridos));
		
	}
	
}

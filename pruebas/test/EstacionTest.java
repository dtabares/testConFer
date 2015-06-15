

import org.junit.Assert;
import org.junit.Test;


public class EstacionTest {
	
	@Test
	public void crearEstacionUsandoDatosDeUnArchivo(){
		
		Estacion estacion1 = new Estacion(3,"RETIRO",-34.592308,-58.37501);
		
		Assert.assertEquals(3, estacion1.getEstacionId());
		Assert.assertEquals("RETIRO", estacion1.getEstacionNombre());
		
		System.out.println(estacion1.getcLat());
		Assert.assertEquals(-34.592308, estacion1.getcLat());
		Assert.assertEquals(-58.37501, estacion1.getcLong());
		
		
	}

}

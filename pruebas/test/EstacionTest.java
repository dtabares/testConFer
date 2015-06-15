

import org.junit.Assert;
import org.junit.Test;


public class EstacionTest {
	
	@Test
	public void crearEstacionUsandoDatosDeUnArchivo(){
		
		Estacion estacion1 = new Estacion(3,"RETIRO",-34.592308,-58.37501);
		
		Assert.assertEquals(3, estacion1.getEstacionId());
		Assert.assertEquals("RETIRO", estacion1.getEstacionNombre());
		
		Assert.assertTrue(estacion1.getcLat()==-34.592308);
		Assert.assertTrue(estacion1.getcLong()==-58.37501);
		
		
	}

}

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


public class GeneradorDeEstadisticas {
	
	List<Recorrido> listaDeRecorridos;

	public GeneradorDeEstadisticas(){
		
		listaDeRecorridos = new LinkedList<Recorrido>();
		
	}
	
	//Devuelve el id de la bicicleta que aparece mas veces en una lista
	public int bicicletaMasUsada(List<Recorrido> listaDeRecorridos) {

		Map<Integer,Integer> mapa = new TreeMap<Integer,Integer>();
		for(Recorrido recorrido : listaDeRecorridos){
			
			if(!mapa.containsKey(recorrido.getBicicletaid())){
				
				mapa.put(recorrido.getBicicletaid(),1);
				
			}
			
			else{
				
				mapa.put(recorrido.getBicicletaid(), mapa.get(recorrido.getBicicletaid())+1);
				
			}
			
		}
		
		int maximo = Collections.max(mapa.values());

		 for (Entry<Integer, Integer> entry : mapa.entrySet()) {  
	            
			 if (entry.getValue()==maximo) {
	                
				 return(entry.getKey());     
	         
			 }
		
		 }
		 
		 return 0;
	}
	
	//Devuelve el id de la bicicleta que aparece menos veces en la lista
	public int bicicletaMenosUsada(List<Recorrido> listaDeRecorridos) {
		
		Map<Integer,Integer> mapa = new TreeMap<Integer,Integer>();
		for(Recorrido recorrido : listaDeRecorridos){
			
			if(!mapa.containsKey(recorrido.getBicicletaid())){
				
				mapa.put(recorrido.getBicicletaid(),1);
				
			}
			
			else{
				
				mapa.put(recorrido.getBicicletaid(), mapa.get(recorrido.getBicicletaid())+1);
				
			}
			
		}
		
		int maximo = Collections.min(mapa.values());

		 for (Entry<Integer, Integer> entry : mapa.entrySet()) {  
	            
			 if (entry.getValue()==maximo) {
	                
				 return(entry.getKey());     
	         
			 }
		
		 }
		 
		 return 0;
	}
	
	public long tiempoPromedioDeUsoEnMinutos(List<Recorrido> listaDeRecorridos){
		
		long sumaDeTiempoEnRecorridos=0;
		
		for (Recorrido recorrido : listaDeRecorridos){
			
			long tiempoFinal = recorrido.getDestinofecha().getTime().getTime();
			long tiempoInicial = recorrido.getOrigenfecha().getTime().getTime();
			
			//Acumula la diferencia entre horario final y horario inicial convertida a minutos
			sumaDeTiempoEnRecorridos += ((tiempoFinal-tiempoInicial)/1000/60);
			
		}
		
		//Devuelve el promedio con respecto al tamanio de la lista
		return sumaDeTiempoEnRecorridos/listaDeRecorridos.size();
		
	}
	
	public String recorridoMasUtilizado(List<Recorrido> listaDeRecorridos){
		
		Map<String,Integer> mapa = new TreeMap<String,Integer>();
		String stringTemporal;
		
		//Recorre la lista de recorridos y va guardando un par origenestacionid;destinoestacionid
		for	(Recorrido recorrido : listaDeRecorridos){
			
			//Concatena los valores en un solo string
			stringTemporal = recorrido.getOrigenestacionid() + ";" + recorrido.getDestinoestacionid();
			
			if(!mapa.containsKey(stringTemporal)){
				
				mapa.put(stringTemporal,1);
				
			}
			
			else{
				
				mapa.put(stringTemporal, mapa.get(stringTemporal)+1);
				
			}
			
			
		}
		
		int maximo = Collections.max(mapa.values());
		
		 for (Entry<String, Integer> entry : mapa.entrySet()) {  
	            
			 if (entry.getValue()==maximo) {
	                
				 return(entry.getKey());     
	         
			 }
		 }
		 
		 
		 return null;
		
	}
	
	
	//Getters & Setters
	
	public void setListaDeRecorridos(List<Recorrido> listaDeRecorridos) {
		this.listaDeRecorridos=listaDeRecorridos;
	}






	
}

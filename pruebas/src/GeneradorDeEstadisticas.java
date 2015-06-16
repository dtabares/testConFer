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
	
	//Getters & Setters
	
	public void setListaDeRecorridos(List<Recorrido> listaDeRecorridos) {
		this.listaDeRecorridos=listaDeRecorridos;
	}






	
}

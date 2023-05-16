package ej1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
	
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}

	public List<List<Integer>> caminos() {
		List<List<Integer>>caminos= new ArrayList<>();
		List<Integer>camino= new ArrayList<>();
		
		return serchCamino(caminos,camino,grafo,origen,destino,lim);
	}
	
	private List<List<Integer>> serchCamino(List<List<Integer>>caminos,List<Integer>camino,Grafo<?> grafo,int origen,int destino,int lim){
		
		if(lim>0) {
			if(origen==destino) {
				camino.add(origen);
				caminos.add(new ArrayList<>(camino));
				lim--;
			}
			else {
				lim--;
				camino.add(origen);
				
				Iterator<Integer>adyacentes= grafo.obtenerAdyacentes(origen);
				
				while(adyacentes.hasNext()) {
					serchCamino(caminos,camino,grafo,adyacentes.next(),destino,lim);
				}
			}
		}
		if(!camino.isEmpty()) {
			int elemento= camino.get(camino.size()-1);
			if(elemento==origen) {
				camino.remove(camino.size()-1);				
			}
		}
		return caminos;
	}
}

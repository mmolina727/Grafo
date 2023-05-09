package ej1;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class ServicioBFS {

	private Grafo<?> grafo;
	private HashMap<Integer, String> vertice; 
	
	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		vertice= new HashMap<>();
	}
	
	public List<Integer> bfsForest() {
		ArrayList<Integer>marcado= new ArrayList<>();
		
		Iterator<Integer>vert= grafo.obtenerVertices();
		
		while(vert.hasNext()) {
			int v= vert.next();
			vertice.put(v, "NO VISITADO");				
		}
		for (Integer v : vertice.keySet()) {
			if(vertice.get(v).equals("NO VISITADO")) {
				marcado.addAll(bfsVisit(v));
			}
		}		
		
		return marcado;
	}
	
	private ArrayList<Integer>bfsVisit(int v){
		ArrayList<Integer>recorrido= new ArrayList<>();
		Queue<Integer>vertLevel= new LinkedList<>();
		recorrido.add(v);
		vertice.put(v, "VISITADO");
		vertLevel.add(v);
		while(!vertLevel.isEmpty()) {
			int elemento=vertLevel.peek();
			vertLevel.poll();
			Iterator<Integer>vertAdya= grafo.obtenerAdyacentes(elemento);
			
			while(vertAdya.hasNext()) {
				int adyacente= vertAdya.next();	
				if(vertice.get(adyacente).equals("NO VISITADO")) {
					vertice.put(adyacente, "VISITADO");
					vertLevel.add(adyacente);
					recorrido.add(adyacente);
				}
			}
		}
		return recorrido;
	}
}

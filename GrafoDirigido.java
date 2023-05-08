package ej1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, ArrayList<Arco<T>>> grafo;
	
	public GrafoDirigido() {
		grafo= new HashMap<>();
	}
	@Override
	public void agregarVertice(int verticeId) {
		if(!grafo.containsKey(verticeId)) {
			grafo.put(verticeId, new ArrayList<Arco<T>>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		if(grafo.containsKey(verticeId)) {
			grafo.remove(verticeId);
		}

	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if(grafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>> arco= grafo.get(verticeId1);
			Arco<T> ar= new Arco<T>(verticeId1,verticeId2,etiqueta);
			arco.add(ar);
		}

	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		if(grafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>> arco= grafo.get(verticeId1);
			if(!arco.isEmpty()) {
				for(int i=0;i<arco.size();i++) {
					if(arco.get(i).getVerticeOrigen()==verticeId1&&arco.get(i).getVerticeDestino()==verticeId2) {						arco.remove(i);
				
					}
				}
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return grafo.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		boolean encontro=false;
		
		if(grafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>>arco= grafo.get(verticeId1);
			
			for(int i=0;i<arco.size();i++) {
				if(arco.get(i).getVerticeOrigen()==verticeId1 && arco.get(i).getVerticeDestino()==verticeId2) {
					encontro=true;
				}
			}
			return encontro;
		}
		else {
			return encontro;
		}
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		boolean encontro=false;
		int pos=0;
		
		if(grafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>>arco= grafo.get(verticeId1);
			
			for (int i = 0; i < arco.size()&& encontro==false; i++) {
				if(arco.get(i).getVerticeOrigen()==verticeId1 && arco.get(i).getVerticeDestino()==verticeId2) {
					encontro=true;
				}
				pos++;
			}
			return arco.get(pos);
		}
		else {
			return null;
		}
	}

	@Override
	public int cantidadVertices() {
		int cantidad=0;
		
		for(Integer clave: grafo.keySet()) {
			clave.intValue();
			cantidad++;
		}
		return cantidad;
	}

	@Override
	public int cantidadArcos() {
		int cantidad=0;
		
		for(Integer clave: grafo.keySet()) {
			cantidad+=grafo.get(clave).size();
		}
		return cantidad;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return grafo.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Arco<T>>arco= grafo.get(verticeId);
		ArrayList<Integer>adyacentes= new ArrayList<Integer>();
		
		for(int i=0;i<arco.size();i++) {
			adyacentes.add(arco.get(i).getVerticeDestino());
		}
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		for(Map.Entry<Integer, ArrayList<Arco<T>>> entry : grafo.entrySet()){
			arcos.addAll(entry.getValue());
		}
		return arcos.iterator();
		
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return grafo.get(verticeId).iterator();
	}

}

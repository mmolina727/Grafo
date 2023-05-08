package ej1;
import java.util.Iterator;
public class Main {

	public static void main(String[] args) {
		
		GrafoDirigido<Integer> gf= new GrafoDirigido<Integer>();

		gf.agregarVertice(12);
		gf.agregarVertice(15);
		gf.agregarVertice(17);
		gf.agregarVertice(20);
		gf.agregarVertice(11);
		gf.agregarVertice(18);
		gf.agregarVertice(26);
		gf.agregarArco(12, 20, null);
		gf.agregarArco(15, 17, null);
		gf.agregarArco(11, 18, null);
		gf.agregarArco(11, 17, null);
		
		
		System.out.println("Cantidad de arcos "+ gf.cantidadArcos());
		System.out.println("Contiene el vertice? "+ gf.contieneVertice(2));
		System.out.println("Existe el arco? "+ gf.existeArco(12, 20));
		System.out.println("Cantidad de vertices "+ gf.cantidadVertices());
		gf.borrarArco(12, 20);
		System.out.println("Borro el arco 12-20");
		System.out.println("Existe el arco? "+ gf.existeArco(12, 20));
		System.out.println("Cantidad de arcos "+ gf.cantidadArcos());
		
		Iterator<Integer>iteradorVertices= gf.obtenerVertices();
		while(iteradorVertices.hasNext()) {
			System.out.println(iteradorVertices.next());
		}
		
		ServicioDFS dfs= new ServicioDFS(gf);
		System.out.println(dfs.dfsForest());
	}

}

package ej1;
import java.util.Iterator;
public class Main {

	public static void main(String[] args) {
		
		GrafoDirigido<Integer> gf= new GrafoDirigido<Integer>();

		gf.agregarVertice(1);
		gf.agregarVertice(7);
		gf.agregarVertice(5);
		gf.agregarVertice(3);
		gf.agregarVertice(2);
		gf.agregarVertice(8);
		gf.agregarVertice(9);
		gf.agregarVertice(13);
		gf.agregarArco(1, 7, null);
		gf.agregarArco(1, 5, null);
		gf.agregarArco(1, 3, null);
		gf.agregarArco(7, 8, null);
		gf.agregarArco(5, 8, null);
		gf.agregarArco(3, 2, null);
		gf.agregarArco(2, 8, null);
		gf.agregarArco(2, 9, null);
		gf.agregarArco(8, 9, null);
		gf.agregarArco(7, 13, null);
		gf.agregarArco(13, 8, null);
		gf.agregarArco(3, 1, null);
		
		
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
		
		///////////SERVICIO DFS//////////////
		ServicioDFS dfs= new ServicioDFS(gf);
		System.out.println(dfs.dfsForest());
		
		///////////SERVICIO BFS//////////////
		ServicioBFS bfs= new ServicioBFS(gf);
		System.out.println(bfs.bfsForest());
		
		//////////SERVICIO CAMINOS///////////
		ServicioCaminos cam= new ServicioCaminos(gf,1,8,5);
		System.out.println(cam.caminos());

	}

}

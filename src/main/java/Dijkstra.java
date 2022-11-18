/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */



import java.util.LinkedList;
import java.util.PriorityQueue;


public class Dijkstra {

    public static void main(String[] args) {
      Dijkstra obj = new Dijkstra();
		
		// Cria um novo grafo.
		Grafo g = new Grafo(10);
		
		// Adiciona as arestas
		g.addAresta(0, 1, 4); 
		g.addAresta(1, 2, 8);
		g.addAresta(2, 3, 2); 
		g.addAresta(3, 4, 7); 
		g.addAresta(1, 3, 8);
		g.addAresta(0, 1, 4); 
		g.addAresta(4, 0, 2); 
		g.addAresta(0, 1, 4); 
		g.addAresta(3, 2, 9); 
		g.addAresta(0, 6, 4); 

		
		// Calcula Dijkstra.
		obj.calcular(g.getVertice(0));	

		// Mostra a distancia minima.
		for(Vertice v:g.getVertices()){
			System.out.print("Vertice: "+v+" , Distancia: "+ v.minDistancia+" ,   Caminho: ");
			for(Vertice caminhovert:v.caminho) {
				System.out.print(caminhovert+" ");
			}
			System.out.println(""+v);
		}

	}

	public void calcular(Vertice origem){
		
		// Pega o vertice que não foi visitado com custo minimo.
		// Visita todos os seus vizinhos.
		// Atualiza as distâncias para todos os vizinhos (na fila de prioridade).
		// Repete o processo até que todos os vertices conectados sejam visitados.
		
		origem.minDistancia = 0;
		PriorityQueue<Vertice> fila = new PriorityQueue<Vertice>();
		fila.add(origem);
		
		while(!fila.isEmpty()){
			
			Vertice u = fila.poll();
		
			for(Aresta vizinho:u.vizinhos){
				Double novaDist = u.minDistancia+vizinho.custo;
				
				if(vizinho.alvo.minDistancia>novaDist){
					// Remove o vertice da fila para atualizar o custo da distância.
					fila.remove(vizinho.alvo);
					vizinho.alvo.minDistancia = novaDist;
					
					// Pega o caminho visitado até agora e adiciona o novo vertice
					vizinho.alvo.caminho = new LinkedList<Vertice>(u.caminho);
					vizinho.alvo.caminho.add(u);
					
					//adiciona a nova distancia no vertice  
					fila.add(vizinho.alvo);					
				}
			}
		}
	}
}

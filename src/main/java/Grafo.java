/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;


public class Grafo {

    private ArrayList<Vertice> vertices;

    public Grafo(int numeroVertices) {
        vertices = new ArrayList<Vertice>(numeroVertices);
        for (int i = 0; i < numeroVertices; i++) {
            vertices.add(new Vertice("v" + Integer.toString(i)));
        }
    }

    public void addAresta(int origem, int destino, int custo) {
        Vertice s = vertices.get(origem);
        Aresta nova_aresta = new Aresta(vertices.get(destino), custo);
        s.vizinhos.add(nova_aresta);
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public Vertice getVertice(int vert) {
        return vertices.get(vert);
    }
}

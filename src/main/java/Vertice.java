/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.LinkedList;


public class Vertice implements Comparable<Vertice>{
  public final String nome;
	public ArrayList<Aresta> vizinhos;
	public LinkedList<Vertice> caminho;
	public double minDistancia = Double.POSITIVE_INFINITY;
	public Vertice anterior;
	public int compareTo(Vertice outro){
		return Double.compare(minDistancia,outro.minDistancia);		
	}
	public Vertice(String nome){
		this.nome = nome;
		vizinhos = new ArrayList<Aresta>();
		caminho = new LinkedList<Vertice>();
	}
	public String toString(){
		return nome;
	}	


    
}

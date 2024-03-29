/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.NoInformada;

import Modelos.Nodo;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Julian y Miguel
 */
public class BusquedadProfundidad {

    private Stack<Nodo> pila;
    private Nodo raiz;
    private ArrayList<Nodo> camino;

    public BusquedadProfundidad(Nodo raiz) {
        this.raiz = raiz;
        this.pila = new Stack<Nodo>();
        this.camino = new ArrayList<Nodo>();
    }

    //Recursivo
    public void recursivo(Nodo nodo, String buscado) {
        System.out.println(nodo + " ");
        if (nodo.getNombre().equals(buscado)) {
            System.out.println("encontrado");
            plasmarCamino(nodo);
            imprimir();
            return;
        }
        for (Nodo v : nodo.getListaAdyacencias()) {

            if (!v.isVisitado()) {
                v.setVisitado(true);
                v.setPredecesor(nodo);
                this.recursivo(v, buscado);
            }
        }
    }
    //Iterativo
    public void iterativo(Nodo root, String buscado) {
        this.pila.add(root);
        root.setVisitado(true);

        while (!this.pila.isEmpty()) {
            Nodo actualNodo = this.pila.pop();
            System.out.println(actualNodo);
            if (actualNodo.getNombre().equals(buscado)) {
                System.out.println("encontrado");
                plasmarCamino(actualNodo);
                imprimir();
                break;
            }
            for (Nodo nodo : actualNodo.getListaAdyacencias()) {
                if (!nodo.isVisitado()) {
                    nodo.setVisitado(true);
                    nodo.setPredecesor(actualNodo);
                    this.pila.add(nodo);
                }
            }
        }
    }

    public ArrayList<Nodo> getCamino() {
        return camino;
    }
    
    private void plasmarCamino(Nodo nodo){
         
        camino.add(0,nodo);
        if(nodo.getPredecesor()!=null && !nodo.getNombre().equals(raiz.getNombre()))
        {
            plasmarCamino(nodo.getPredecesor());
            
        }
        
    }
    
    private void imprimir(){
        for(Nodo nodo: camino)
        {
           System.out.println(nodo.getNombre());
            
        }
        
    }

}

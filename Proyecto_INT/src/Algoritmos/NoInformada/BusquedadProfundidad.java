/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.NoInformada;

import Modelos.Nodo;
import java.util.Stack;

/**
 *
 * @author Julian y Miguel
 */
public class BusquedadProfundidad {

    private Stack<Nodo> pila;

    public BusquedadProfundidad() {
        this.pila = new Stack<Nodo>();
    }

    //Recursivo
    public void recursivo(Nodo nodo) {
        System.out.println(nodo + " ");

        for (Nodo v : nodo.getListaAdyacencias()) {
            if (!v.isVisitado()) {
                v.setVisitado(true);
                v.setPredecesor(nodo);
                this.recursivo(v);
            }
        }
    }

    //Iterativo
    public void iterativo(Nodo root) {
        this.pila.add(root);
        root.setVisitado(true);

        while (!this.pila.isEmpty()) {
            Nodo actualNodo = this.pila.pop();
            System.out.println(actualNodo + " ");
            for (Nodo nodo : actualNodo.getListaAdyacencias()) {
                if (!nodo.isVisitado()) {
                    nodo.setVisitado(true);
                    nodo.setPredecesor(actualNodo);
                    this.pila.add(nodo);
                }
            }
        }
    }
}

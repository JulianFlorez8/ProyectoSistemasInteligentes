/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.Informada.aEstrella;

/**
 *
 * @author Julian y Miguel
 */
public class Adyacencia {
    private double costo;
    private Nodo nodoObjetivo;

    public Adyacencia(double cost, Nodo nodoObjetivo) {
        this.costo = cost;
        this.nodoObjetivo = nodoObjetivo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Nodo getNodoObjetivo() {
        return nodoObjetivo;
    }

    public void setNodoObjetivo(Nodo nodoObjetivo) {
        this.nodoObjetivo = nodoObjetivo;
    }
}

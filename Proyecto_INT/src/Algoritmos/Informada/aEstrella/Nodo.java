/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.Informada.aEstrella;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian y Miguel
 */
public class Nodo implements Comparable<Nodo>{

    private String valor;
    private double gValor;
    private double fValor;
    private double x;
    private double y;
    private List<Adyacencia> listaAdyacencias;
    private Nodo parentNodo;

    public Nodo(String value) {
        this.valor = value;
        this.listaAdyacencias = new ArrayList<>();
    }

    public void addVecino(Adyacencia adyacencia){
        this.listaAdyacencias.add(adyacencia);
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public double getgValor() {
        return gValor;
    }

    public void setgValor(double gValor) {
        this.gValor = gValor;
    }

    public double getfValor() {
        return fValor;
    }

    public void setfValor(double fValor) {
        this.fValor = fValor;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public List<Adyacencia> getListaAdyacencias() {
        return listaAdyacencias;
    }

    public Nodo getParentNodo() {
        return parentNodo;
    }

    public void setParentNodo(Nodo parentNodo) {
        this.parentNodo = parentNodo;
    }

    @Override
    public String toString() {
        return "Nodo {" +
                "valor = '" + valor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Nodo otherNodo) {
        return Double.compare(this.fValor, otherNodo.getfValor() );
    }
}
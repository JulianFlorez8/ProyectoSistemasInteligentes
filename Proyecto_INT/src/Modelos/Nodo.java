/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian y Miguel
 */
public class Nodo implements Comparable<Nodo>{

    private String nombre;
    private boolean visitado;
    private ArrayList<Nodo> listaAdyacencias;
    private Nodo predecesor;
    private boolean actualVisitado;
    private double costo;
    private int x;
    private int y;
    private double gValor;
    private double fValor;

    public Nodo() {
    }

    public Nodo(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.costo = 10;
        this.listaAdyacencias = new ArrayList<Nodo>();
    }

    public void addAdyacencia(Nodo nodo) {
        this.listaAdyacencias.add(nodo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public List<Nodo> getListaAdyacencias() {
        return listaAdyacencias;
    }
    
    public List<Arista> generaAristasAdyacentes(){
        List<Arista> aristas = new ArrayList<Arista>();
        for(Nodo nodo: this.listaAdyacencias)
        {
            aristas.add(new Arista(nodo));
        }
        return aristas;
    }

    public void setListaAdyacencias(ArrayList<Nodo> listaAdyacencias) {
        this.listaAdyacencias = listaAdyacencias;
    }

    public void addTodasAdyacencias(List<Nodo> listaAdyacencias) {
        this.listaAdyacencias.addAll(listaAdyacencias);
    }

    public Nodo getPredecesor() {
        return predecesor;
    }

    public void setPredecesor(Nodo predecesor) {
        this.predecesor = predecesor;
    }

    public boolean isActualVisitado() {
        return actualVisitado;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setActualVisitado(boolean actualVisitado) {
        this.actualVisitado = actualVisitado;
    }

    @Override
    public String toString() {
        return "Nodo { "
                + "nombre = '" + nombre + '\''
                + "X=" + x + ", Y= " + y
                + '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
    @Override
    public int compareTo(Nodo otherNodo) {
        return Double.compare(this.fValor, otherNodo.getfValor() );
    }

}

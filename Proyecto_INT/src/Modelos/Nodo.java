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
public class Nodo {
    private String nombre;
    private boolean visitado;
    private List<Nodo> listaAdyacencias;
    private Nodo predecesor;
    private boolean actualVisitado;


    public Nodo() {
    }

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.listaAdyacencias = new ArrayList<Nodo>();
    }

    public void addAdyacencia(Nodo vertex) {
        this.listaAdyacencias.add(vertex);
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

    public void setListaAdyacencias(List<Nodo> listaAdyacencias) {
        this.listaAdyacencias = listaAdyacencias;
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

    public void setActualVisitado(boolean actualVisitado) {
        this.actualVisitado = actualVisitado;
    }

    @Override
    public String toString() {
        return "Nodo { " +
                "nombre = '" + nombre + '\'' +
                '}';
    }
    
}
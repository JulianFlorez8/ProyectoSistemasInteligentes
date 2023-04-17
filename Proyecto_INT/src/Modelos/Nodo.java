/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 *
 * @author Julian y Miguel
 */
public class Nodo implements Comparable<Nodo> {

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

    public List<Nodo> getListaAdyacenciasPrioridad() {
        Nodo[] nuevaLista = new Nodo[4];
        int menorY = 0;
        int mayorY = 0;
        int menorX = 0;
        int mayorX = 0;
        for (Nodo nodo : listaAdyacencias) {

            if (nodo.y > this.y) {
                nuevaLista[0] = nodo;
            }
            else if (nodo.x < this.x) {
                nuevaLista[1] = nodo;
            }
            else if (nodo.y < this.x) {
                nuevaLista[2] = nodo;
            }
            else if (nodo.x > this.x) {
                nuevaLista[3] = nodo;
            }
        }
        List<Nodo> listaFinal = new ArrayList<Nodo>();
        for (Nodo nodo : nuevaLista) {
            if(nodo!=null){
             listaFinal.add(nodo);   
            }
            
        }
        return listaFinal;

    }

    public Nodo getMejorHijoNoVisitado(Nodo nodo2) {
        List<Nodo> nodos = listaAdyacencias.stream().filter(p -> !p.isVisitado()).collect(Collectors.toList());
        PriorityQueue<Nodo> nodoPrio = new PriorityQueue<Nodo>();
        for (Nodo nodo : nodos) {
            nodo.setfValor(this.heuristicaEuclidiana(nodo2));
            nodoPrio.add(nodo);
        }
        return nodoPrio.poll();

    }

    public boolean isTodosHijosVisitados() {
        Nodo nodo = listaAdyacencias.stream().filter(p -> !p.isVisitado()).findFirst().orElse(null);
        if (nodo != null) {
            return false;
        } else {
            return true;
        }
    }

    public List<Arista> generaAristasAdyacentes() {
        List<Arista> aristas = new ArrayList<Arista>();
        for (Nodo nodo : this.listaAdyacencias) {
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

    /**
     * heuristica de Euclidiana raiz de la suma de los cuadrados Raiz((X -
     * X')**2 + (Y - Y')**2)
     *
     * @param nodo1
     * @param nodo2
     * @return
     */
    private double heuristicaEuclidiana(Nodo nodo2) {
        return Math.sqrt(Math.pow((getX() - nodo2.getX()), 2) + Math.pow((getY() - nodo2.getY()), 2));
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
        return Double.compare(this.fValor, otherNodo.getfValor());
    }

}

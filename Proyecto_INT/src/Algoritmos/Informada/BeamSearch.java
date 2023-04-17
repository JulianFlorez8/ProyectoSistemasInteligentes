/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.Informada;

import Modelos.Nodo;
import java.util.*;

/**
 *
 * @author Julian y Miguel
 */
public class BeamSearch {

    Set<Nodo> nodosVisitados = new HashSet<>();

    public void busquedaBeamSearch(Nodo nodoOrigen, Nodo buscado, HeuristicaEnum heuristica, int b) {
        PriorityQueue<Nodo> noVisitados = new PriorityQueue<Nodo>();
        nodoOrigen.setgValor(0);
        noVisitados.add(nodoOrigen);
        boolean isFound = false;

        while (!noVisitados.isEmpty() && !isFound) {
            PriorityQueue<Nodo> candidatos = new PriorityQueue<Nodo>();

            // agregar los b nodos con menor heurística a la cola de candidatos
            for (int i = 0; i < b && !noVisitados.isEmpty(); i++) {
                Nodo nodoActual = noVisitados.poll();
                nodosVisitados.add(nodoActual);

                if (nodoActual.getNombre().equals(buscado.getNombre())) {
                    isFound = true;
                    break;
                }

                for (Nodo e : nodoActual.getListaAdyacencias()) {
                    System.out.println("Expandiendo nodo: " + e.getNombre());
                    Nodo nodoHijo = e;
                    double tempFValor = 0;
                    if (heuristica == HeuristicaEnum.Manhattan) {
                        tempFValor =  heuristicaManhattan(nodoHijo, buscado);
                    } else if (heuristica == HeuristicaEnum.Euclidiana) {
                        tempFValor =  heuristicaEuclidiana(nodoHijo, buscado);
                    }

                    if (nodosVisitados.contains(nodoHijo) && tempFValor >= nodoHijo.getfValor()) {
                        continue;
                    } else if (!nodosVisitados.contains(nodoHijo) || tempFValor <= nodoHijo.getfValor()) {
                        nodoHijo.setPredecesor(nodoActual);
                        nodoHijo.setfValor(tempFValor);

                        if (candidatos.contains(nodoHijo)) {
                            candidatos.remove(nodoHijo);
                        }
                        candidatos.add(nodoHijo);
                    }
                }
            }

            // agregar los b nodos con menor heurística de la cola de candidatos a la cola de prioridad
            noVisitados.addAll(candidatos);
        }
    }
    
    public int calcularBeta(Nodo root) {
        Stack<Nodo> pila = new Stack<>();
        root.setVisitado(true);
        
        int beta = 0;

        while (!pila.isEmpty()) {
            Nodo actualNodo = pila.pop();
            System.out.println(actualNodo);
            System.out.println(actualNodo.getListaAdyacencias().size());
            for (Nodo nodo : actualNodo.getListaAdyacencias()) {
                if (!nodo.isVisitado()) {
                    if(nodo.getListaAdyacencias().size() > beta){
                        beta = nodo.getListaAdyacencias().size();
                    }
                    nodo.setVisitado(true);
                    nodo.setPredecesor(actualNodo);
                    pila.add(nodo);
                }
            }
        }
        return beta;
    }
    
    private void imprimir(ArrayList<Nodo> camino) {
        String impresion = "[";
        for (Nodo tmp : camino) {
            if(camino.indexOf(tmp)==camino.size()-1)
            {
                impresion += "(" + tmp.getNombre() + ")";
                
            }else{
                impresion += "(" + tmp.getNombre() + "),";
            }
            

        }

        System.out.println(impresion + "]");


    }

    public ArrayList<Nodo> getCamino(Nodo targetNodo) {

        ArrayList<Nodo> pathList = new ArrayList<>();
        for (Nodo nodo = targetNodo; nodo != null; nodo = nodo.getPredecesor()) {
            pathList.add(nodo);
        }
        Collections.reverse(pathList);
        imprimir(pathList);
        return pathList;
    }

    //HEURISTICAS
    /**
     * heuristica de Manhattan ABS(X - X') + ABS(Y - Y')
     *
     * @param nodo1
     * @param nodo2
     * @return
     */
    private double heuristicaManhattan(Nodo nodo1, Nodo nodo2) {
        return Math.abs(nodo1.getX() - nodo2.getX()) + Math.abs(nodo1.getY() - nodo2.getY());
    }

    /**
     * heuristica de Euclidiana raiz de la suma de los cuadrados Raiz((X -
     * X')**2 + (Y - Y')**2)
     *
     * @param nodo1
     * @param nodo2
     * @return
     */
    private double heuristicaEuclidiana(Nodo nodo1, Nodo nodo2) {
        return Math.sqrt(Math.pow((nodo1.getX() - nodo2.getX()), 2) + Math.pow((nodo1.getY() - nodo2.getY()), 2));
    }
}

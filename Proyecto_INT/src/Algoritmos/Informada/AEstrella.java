/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.Informada;

import Algoritmos.Informada.HeuristicaEnum;
import Modelos.Nodo;
import java.util.*;

/**
 *
 * @author Julian y Miguel
 */
public class AEstrella {

    Set<Nodo> nodosVisitados = new HashSet<>();

    public void busquedadAEstrella(Nodo nodoOrigen, Nodo buscado, HeuristicaEnum heuristica) {
        PriorityQueue<Nodo> noVisitados = new PriorityQueue<Nodo>();
        nodoOrigen.setgValor(0); //gvalor es la distancia minima--> inicia en 0
        noVisitados.add(nodoOrigen);
        boolean isFound = false;

        // ciclo hasta que se encuentre el nodo o se agote la cola de prioridad
        while (!noVisitados.isEmpty() && !isFound) {

            Nodo nodoActual = noVisitados.poll();
            nodosVisitados.add(nodoActual);

            //verificamos si el nodo es el que buscamos
            if (nodoActual.getNombre().equals(buscado.getNombre())) {
                isFound = true;
                break;
            }

            //recorremos todos las adyacencias
            //recorremos cada vecino y lo agregamos a visitados
            for (Nodo e : nodoActual.getListaAdyacencias()) {
                Nodo nodoHijo = e;
                double cost = e.getCosto(); // asignamos el costo
                double tempGValor = nodoActual.getfValor() + cost;
                //A*Search f(x) = g(x) + h(x)
                //Calculamos el costo SEGUN  la heuristica
                double tempFValor = 0;
                if (heuristica == HeuristicaEnum.Manhattan) {
                    tempFValor = tempGValor + heuristicaManhattan(nodoHijo, buscado);
                } else if (heuristica == HeuristicaEnum.Euclidiana) {
                    tempFValor = tempGValor + heuristicaEuclidiana(nodoHijo, buscado);
                }

                //verificamos si existe algun nodo mejor
                if (nodosVisitados.contains(nodoHijo) && tempFValor >= nodoHijo.getfValor()) {
                    continue;
                } else if (!nodosVisitados.contains(nodoHijo) || tempFValor <= nodoHijo.getfValor()) {
                    nodoHijo.setPredecesor(nodoActual);
                    nodoHijo.setgValor(tempGValor);
                    nodoHijo.setfValor(tempFValor);

                    if (noVisitados.contains(nodoHijo)) {
                        noVisitados.remove(nodoHijo);
                    }
                    noVisitados.add(nodoHijo);

                }
            }
        }
    }

    public ArrayList<Nodo> getCamino(Nodo targetNodo) {

        ArrayList<Nodo> pathList = new ArrayList<>();
        for (Nodo nodo = targetNodo; nodo != null; nodo = nodo.getPredecesor()) {
            pathList.add(nodo);
        }
        Collections.reverse(pathList);
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

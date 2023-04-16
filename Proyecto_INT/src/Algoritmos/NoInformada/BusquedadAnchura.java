/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.NoInformada;

import Modelos.Nodo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Julian y Miguel
 */
public class BusquedadAnchura {

    public void bfs(Nodo root, String buscado) {
        System.out.println(root);
        Queue<Nodo> queue = new LinkedList<Nodo>();
        root.setVisitado(true);
        queue.add(root);

        Map<Nodo, Nodo> padres = new HashMap<Nodo, Nodo>(); // diccionario de padres, hijo clave, padre valor

        while (!queue.isEmpty()) {
            Nodo nodoActual = queue.remove();
            //System.out.println(nodoActual); //para imprimir los nodos que se van expandiendo

            if(nodoActual.getNombre().equals(buscado)) {
                //System.out.println("encontrado");

                // seguimos el camino de padres desde el nodo buscado hasta la raíz
                Nodo nodo = nodoActual;
                Stack<Nodo> camino = new Stack<Nodo>(); // pila de nodos en el camino
                camino.push(nodo);
                while (nodo != root) {
                    nodo = padres.get(nodo);
                    camino.push(nodo);
                }

                // desapilamos los nodos de la pila para imprimirlos en orden
                System.out.print(camino.pop().getNombre());
                while (!camino.isEmpty()) {
                    System.out.print(" -> " + camino.pop().getNombre());
                }

                break;
            }

            for (Nodo nodo : nodoActual.getListaAdyacencias()) {
                if (!nodo.isVisitado()) {
                    nodo.setVisitado(true);
                    queue.add(nodo);

                    // guardamos el padre del nodo recién agregado en el diccionario
                    padres.put(nodo, nodoActual);
                }
            }
        }
    }
}

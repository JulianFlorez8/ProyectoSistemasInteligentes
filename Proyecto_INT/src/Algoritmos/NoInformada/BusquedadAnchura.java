/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.NoInformada;

import Modelos.Nodo;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Julian y Miguel
 */
public class BusquedadAnchura {

    public  void bfs(Nodo root, String buscado) {
        System.out.println(root);
        Queue<Nodo> queue = new LinkedList<Nodo>();
        root.setVisitado(true);
        queue.add(root);
        while (!queue.isEmpty()) {
            Nodo nodoActual = queue.remove();
            System.out.println(nodoActual);
            if(nodoActual.getNombre().equals(buscado))
            {
                System.out.println("encontrado");
                break;
            }

            for (Nodo nodo : nodoActual.getListaAdyacencias()) {
                if (!nodo.isVisitado()) {
                    nodo.setVisitado(true);
                    queue.add(nodo);
                }
            }
        }
    }
}

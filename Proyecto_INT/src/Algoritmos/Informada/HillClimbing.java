/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.Informada;

import Modelos.Arista;
import Modelos.Nodo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author NEWSHORE_
 */
public class HillClimbing {

    private ArrayList<Nodo> camino = new ArrayList<Nodo>();
    private int nivel = 1;
    private int nivelEstoy = 1;
    private Map<String, List<Nodo>> niveles = new HashMap<>();
    private Nodo raiz;
    private boolean encontrado = false;

    public HillClimbing(Nodo raiz) {
        this.raiz = raiz;
    }

    public void hillClimbing(Nodo nodo, Nodo buscado) {
        if (nodo != null && !encontrado) {
            if (nodo.getNombre().equals(buscado.getNombre())) {
                System.out.println("Encontrado");
                this.plasmarCamino(nodo);
                this.imprimir();
                this.encontrado = true;
            } else {
                System.out.println(nodo);
                nodo.setVisitado(true);
                this.crearNivel(nodo);
                Nodo hijo = nodo.getMejorHijoNoVisitado(buscado);
                if (hijo != null) {
                    hijo.setPredecesor(nodo);
                    this.hillClimbing(hijo, buscado);
                } else {
                    nivelEstoy = 1;
                    this.hillClimbing(this.getNodoNivel(), buscado);

                }
            }
        }

    }

    private void crearNivel(Nodo nodo) {
        this.niveles.put(this.nivel + "", nodo.getListaAdyacencias());
        this.nivel++;
    }

    private Nodo getNodoNivel() {
        Nodo retorno = niveles.get(nivelEstoy + "").stream().filter(p -> !p.isTodosHijosVisitados()).findFirst().orElse(null);
        if (retorno == null) {
            nivelEstoy++;
            retorno = this.getNodoNivel();
        }
        else if (retorno.getNombre().equals(this.raiz.getNombre())) {
            nivelEstoy++;
            retorno = this.getNodoNivel();
        }
        return retorno;
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

    public ArrayList<Nodo> getCamino() {
        return camino;
    }

    private void plasmarCamino(Nodo nodo) {

        camino.add(0, nodo);
        if (nodo.getPredecesor() != null && !nodo.getNombre().equals(raiz.getNombre())) {
            plasmarCamino(nodo.getPredecesor());

        }

    }

    private void imprimir() {
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
}

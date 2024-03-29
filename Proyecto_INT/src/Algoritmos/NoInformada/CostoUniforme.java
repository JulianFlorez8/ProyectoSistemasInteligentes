/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos.NoInformada;

import Modelos.Arista;
import Modelos.Nodo;
import java.util.*;

import static java.util.Objects.isNull;

/**
 *
 * @author NEWSHORE_
 */
public class CostoUniforme {

    private final List<Nodo> posibles = new LinkedList<Nodo>();
    private final List<Nodo> visitados = new LinkedList<Nodo>();
    private ArrayList<Nodo> camino;
    private Nodo raiz;

    public Optional<Nodo> search(final Map<String, List<Arista>> conexiones, final Nodo origen, final String destino) {
        this.raiz = origen;
        this.camino = new ArrayList<Nodo>();
        if (isNull(origen)) {
            throw new NullPointerException("se esta partiendo de un null");
        }
        if (isNull(destino) || destino.isEmpty()) {
            throw new NullPointerException("se esta buscando un null");
        }
        boolean foundFinalState = false;
        Optional<Nodo> nodoEncontrado = Optional.empty();

        origen.setCosto(0);
        posibles.add(origen);

        while (!foundFinalState && posibles.size() != 0) {
            posibles.sort(Comparator.comparing(Nodo::getCosto));
            final Nodo nodo = this.posibles.remove(0);
            visitados.add(nodo);

            if (nodo.getNombre().equals(destino)) {
                foundFinalState = true;
                nodoEncontrado = Optional.of(nodo);
                break;
            } else {
                final String nombre = nodo.getNombre();
                final List<Nodo> listaAdyancencias = new LinkedList<>();
                conexiones.get(nombre).forEach(arista -> {
                    final Nodo hijo = arista.getDestino();

                    if (!visitados.contains(hijo)) {
                        hijo.setCosto(nodo.getCosto() + arista.getCosto());
                        hijo.setPredecesor(nodo);
                        listaAdyancencias.add(hijo);
                        if (posibles.contains(hijo)) {
                            final List<Nodo> removeNodes = new LinkedList<>();
                            final List<Nodo> addNodes = new LinkedList<>();
                            posibles.forEach(node -> {
                                if (node.equals(hijo) && node.getCosto() >= hijo.getCosto()) {
                                    removeNodes.add(node);
                                    addNodes.add(hijo);
                                }
                            });
                            posibles.removeAll(removeNodes);
                            posibles.addAll(addNodes);
                        } else {
                            posibles.add(hijo);
                            nodo.addTodasAdyacencias(listaAdyancencias);
                        }
                    }
                });
            }

        }
        for (Nodo nodo : visitados) {
            System.out.println(nodo);
        }
        this.plasmarCamino(nodoEncontrado.get());
        this.imprimir();
        return nodoEncontrado;
    }

    private void plasmarCamino(Nodo nodo) {

        camino.add(0, nodo);
        if (nodo.getPredecesor() != null && !nodo.getNombre().equals(raiz.getNombre())) {
            plasmarCamino(nodo.getPredecesor());

        }

    }

    private void imprimir() {
        for (Nodo nodo : camino) {
            System.out.println(nodo);

        }

    }

    public ArrayList<Nodo> getCamino() {
        return camino;
    }
}

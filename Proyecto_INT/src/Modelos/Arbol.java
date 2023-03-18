/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Julian y Miguel
 */
public class Arbol {

    public Nodo raiz= null;
    private ArrayList<Nodo> visitados= new ArrayList<Nodo>();
    private boolean encontro = false;
    
    
    
    private void encontrado(){
        this.encontro = true;
    }
   
}

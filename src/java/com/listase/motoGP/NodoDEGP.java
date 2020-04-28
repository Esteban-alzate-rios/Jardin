/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.motoGP;

import java.io.Serializable;

/**
 *
 * @author esteban
 */
public class NodoDEGP implements Serializable {
    
    private Corredor dato;
    private NodoDEGP siguiente;
    private NodoDEGP anterior;

     public NodoDEGP(Corredor dato) {
        this.dato = dato;
    }

    public Corredor getDato() {
        return dato;
    }

    public void setDato(Corredor dato) {
        this.dato = dato;
    }

    public NodoDEGP getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDEGP siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDEGP getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDEGP anterior) {
        this.anterior = anterior;
    }

    
   
    
    
    
}

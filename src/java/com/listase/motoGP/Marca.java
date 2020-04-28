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
public class Marca implements Serializable{
    private String dato;
    private String nombre;

    public Marca(String dato, String nombre) {
        this.dato = dato;
        this.nombre = nombre;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     
    
}

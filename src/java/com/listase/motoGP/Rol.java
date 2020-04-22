/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.motoGP;

/**
 *
 * @author esteban
 */
public class Rol extends Parametrica{
    
    private Rol rol;

    public Rol(Rol rol, byte codigo, String descripcion) {
        super(codigo, descripcion);
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
}

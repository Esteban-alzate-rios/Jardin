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
public class Tercero extends Parametrica {
    
    private String nombre;
    private String apellido;
    private boolean genero;
    private String cedula;

    public Tercero(String nombre, String apellido, boolean genero, String cedula, byte codigo, String descripcion) {
        super(codigo, descripcion);
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.cedula = cedula;
    }
      
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
}

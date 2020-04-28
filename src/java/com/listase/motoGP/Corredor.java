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
public class Corredor implements Serializable{
    private short codigo;
    private String nombre;
    private String genero;
    private String estado;
    private String cilindraje;
    private String marca;

    public Corredor(short codigo, String nombre, String genero, String estado, String cilindraje, String marca) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.genero = genero;
        this.estado = estado;
        this.cilindraje = cilindraje;
        this.marca = marca;
    }

    public short getCodigo() {
        return codigo;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
       
  @Override
    public String toString() {
       return this.nombre; 
    }  

    boolean isGenero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
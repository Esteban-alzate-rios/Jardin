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
    private byte edad;
    private boolean genero;
    private String ciudadNacimiento;
   
    
   /* 
    private String cilindraje;
    private String marca;
 */   

    public Corredor(short codigo, String nombre, byte edad, boolean genero, String ciudadNacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.ciudadNacimiento = ciudadNacimiento;
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

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public Corredor() {
    }


  @Override
    public String toString() {
       return this.nombre; 
    }  
    
}
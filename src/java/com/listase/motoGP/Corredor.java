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
public class Corredor extends Tercero {
    
    private String usuario;
    private String contraseña;
    private boolean estado;
    private Moto moto;

    public Corredor(String usuario, String contraseña, boolean estado, Moto moto, String nombre, String apellido, boolean genero, String cedula, byte codigo, String descripcion) {
        super(nombre, apellido, genero, cedula, codigo, descripcion);
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.estado = estado;
        this.moto = moto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }
    
    
    
    
    
    
}

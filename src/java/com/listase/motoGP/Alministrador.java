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
public class Alministrador extends Tercero{
    
    private String usuario;
    private String contraseña;
    private String acceso;
    private Rol rol;

    public Alministrador(String usuario, String contraseña, String acceso, Rol rol, String nombre, String apellido, boolean genero, String cedula, byte codigo, String descripcion) {
        super(nombre, apellido, genero, cedula, codigo, descripcion);
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.acceso = acceso;
        this.rol = rol;
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

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

  
    
         
    
}

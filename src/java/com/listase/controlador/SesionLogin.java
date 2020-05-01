/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import loginjsfmodelo.Usuario;

/**
 *
 * @author esteban
 */
@Named(value = "sesionLogin")
@Dependent
public class SesionLogin {

    /**
     * Creates a new instance of SesionLogin
     */
    
    private Usuario usauarioAtenticado;
    
    
    public SesionLogin() {
    }

    public Usuario getUsauarioAtenticado() {
        return usauarioAtenticado;
    }

    public void setUsauarioAtenticado(Usuario usauarioAtenticado) {
        this.usauarioAtenticado = usauarioAtenticado;
    }
    
    
    
}

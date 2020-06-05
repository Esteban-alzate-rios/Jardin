/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author esteban
 */
@Named(value = "appBean")
@ApplicationScoped
public class AppBean {
    
    private String correoTurno="uaterios@gmail.com";
    private int cont=0;
    
    
    
    
    
    public String getCorreoTurno() {
        return correoTurno;
    }

    /**
     * Creates a new instance of AppBean
     */
    public void setCorreoTurno(String correoTurno) {
        this.correoTurno = correoTurno;
    }

    public AppBean() {
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
    
    
    public void aumentarContador(String correo)
    {
        switch(correo)
        {
            case "uaterios@gamail.com";
            correoTurno = "consulta@gamail.com";
            break;
            default:
            correoTurno = "uaterios@gamail.com";

        }
     cont++;   
    }
    
    
    public boolean validarTurno(String correo)
    {
        if(correo.equals(correoTurno))
        {
            return true;
        }
        return  false;
    }
    
}

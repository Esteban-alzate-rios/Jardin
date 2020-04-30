/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjsfmodelo;

import java.io.Serializable;

/**
 *
 * @author esteban
 */
public class Usuario implements Serializable{
    
    private String correo;
    private String contrasenia;
    private String nombrecompleto;
    private TipoUsuario tipoUsuario;
    
    
    public Usuario() {
    }

    public Usuario(String correo, String contrasenia, String nombrecompleto, TipoUsuario tipoUsuario) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.nombrecompleto = nombrecompleto;
        this.tipoUsuario = tipoUsuario;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }
    
    
    
    
}

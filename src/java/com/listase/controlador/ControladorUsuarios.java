/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;



import java.util.ArrayList;
import java.util.List;
import loginjsfmodelo.TipoUsuario;
import loginjsfmodelo.Usuario;



/**
 *
 * @author esteban
 */
public class ControladorUsuarios{
 

    private List<TipoUsuario> tiposUsuario;
    private List<Usuario> usuarios;

    public ControladorUsuarios() {
        this.iniciarListados();
    }

    public List<TipoUsuario> getTiposUsuario() {
        return tiposUsuario;
    }

    public void setTiposUsuario(List<TipoUsuario> tiposUsuario) {
        this.tiposUsuario = tiposUsuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    
    
    
    private void iniciarListados()
    {
        tiposUsuario = new ArrayList<>();
        tiposUsuario.add(new TipoUsuario(1, "Administrador"));
        tiposUsuario.add(new TipoUsuario(2, "Consulta"));
        
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("uaterios@gmail.com","123456","Esteban Alzate",
        tiposUsuario.get(0)));
        
        usuarios.add(new Usuario("consulta@gmail.com","654321","Consulta Consulta",
        tiposUsuario.get(1)));

    }
    
    
    public Usuario encontrarUsuarioxCorreo(String correo)
    {
     Usuario usuarioEncontrado = null;
     for(Usuario usu: this.usuarios)
         
         
     {
        if(usu.getCorreo().equals(correo)) 
        {
           return usu;
        }
     }
     
     
     return usuarioEncontrado;
        
    }
}

    
    
    
       


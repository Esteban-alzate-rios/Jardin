/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjsfmodelo;

import com.listase.controlador.ControladorUsuarios;
import com.listase.controlador.SesionLogin;
import com.listase.utilidades.JsfUtil;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;




/**
 *
 * @author esteban
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
        
        private String correo;
        private String contrasenia;
        private ControladorUsuarios controlUsuarios;

    public LoginBean() {
        controlUsuarios = new ControladorUsuarios();
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
  
        
   public String ingresar()
   {
    Usuario usuarioEncontrado = controlUsuarios.encontrarUsuarioxCorreo(correo);
    if(usuarioEncontrado != null)
    {
       if(usuarioEncontrado.getContrasenia().equals(contrasenia))
       {
   /*     SesionLogin sesion=(SesionLogin) JsfUtil.getManagedBean("SesionLogin");
        sesion.setUsauarioAtenticado(usuarioEncontrado);
       */    
           return "inicioListas";
       }
   
        JsfUtil.addErrorMessage("Los datos ingresados NO existen");
    }    
    return null;
        
    }
    
}

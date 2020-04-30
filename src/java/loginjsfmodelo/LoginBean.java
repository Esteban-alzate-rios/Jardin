/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginjsfmodelo;

import com.listase.controlador.ControladorUsuarios;
import com.listase.utilidades.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import static sun.security.jgss.GSSUtil.login;


/**
 *
 * @author esteban
 */
@Named(value = "login")
@Dependent
public class LoginBean {
        
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
        Sesionloginlogin sesion=JsfUtil.getManagedBean(login);
        sesion.setUsuarioAutenticado(usuarioEncontrado);
           return "login";
       }
    
        JsfUtil.addErrorMessage("Los datos ingresados NO existen");
    }    
    return null;
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.controlador;


import com.listase.excepciones.MotoException;
import com.listase.motoGP.Corredor;
import com.listase.motoGP.ListaDEGP;

import com.listase.motoGP.NodoDEGP;
import com.listase.utilidades.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import loginjsfmodelo.Usuario;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.DiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StateMachineConnector;
import org.primefaces.model.diagram.endpoint.BlankEndPoint;
import org.primefaces.model.diagram.endpoint.EndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;
import org.primefaces.model.diagram.overlay.ArrowOverlay;
import org.primefaces.model.diagram.overlay.LabelOverlay;

/**
 *
 * @author esteban
 */
@Named(value = "sesionMotoGP")
@SessionScoped
public class SesionMotoGP implements Serializable {
    

    
 private Usuario usuarioAuntenticado;
           
    private ListaDEGP listaCorredor;
    
    private Corredor corredor;
    
    private String alInicio="1";
    
    private boolean deshabilitarFormulario=true;
    
    private NodoDEGP ayudante;
    
    private String textoVista="Gráfico";
    
    private List listadoCorredor;
    
    private DefaultDiagramModel model;
    
    private short codigoEliminar;
    
    private String codigoDeptoSel;
    
    private short corredorSeleccionado;
    
    private Corredor corredorDiagrama;
    
    private ControladorLocalidadesMotoGP controlLocalidades;
    
    private int posicionCorredor;
    
    private String opcionElegida ="1";
    
    private int numeroPosiciones=1;
    
    private short corredor1;
    
    private short corredor2;
     
   

    public SesionMotoGP() {
    }    
   
        
    @PostConstruct
    private void inicializar()
    {
        controlLocalidades = new ControladorLocalidadesMotoGP();
        codigoDeptoSel = controlLocalidades.getDepartamentos().get(0).getCodigo();
        listaCorredor = new ListaDEGP();        
        //LLenado de la bds
        listaCorredor.adicionarNodoGP(new Corredor((short)45, "Arango", (byte)21, true, controlLocalidades.getCiudades().get(0).getNombre(),(float)1.36));
        listaCorredor.adicionarNodoGP(new Corredor((short)46, "Rodriguez", (byte)18, true, controlLocalidades.getCiudades().get(1).getNombre(),(float)1.37));
        listaCorredor.adicionarNodoGP(new Corredor((short)28, "Alzate", (byte)19, true, controlLocalidades.getCiudades().get(1).getNombre(),(float)1.38));
        ayudante = listaCorredor.getCabeza();
        corredor = ayudante.getDato();
        //Me llena el objeto List para la tabla
        listadoCorredor= listaCorredor.obtenerListaCorredor();
        pintarLista();
   }

    public short getCorredor1() {
        return corredor1;
    }

    public void setCorredor1(short corredor1) {
        this.corredor1 = corredor1;
    }

    public short getCorredor2() {
        return corredor2;
    }

    public void setCorredor2(short corredor2) {
        this.corredor2 = corredor2;
    }
    
    
    public String getOpcionElegida() {
        return opcionElegida;
    }

    public void setOpcionElegida(String opcionElegida) {
        this.opcionElegida = opcionElegida;
    }

    public int getNumeroPosiciones() {
        return numeroPosiciones;
    }

    public void setNumeroPosiciones(int numeroPosiciones) {
        this.numeroPosiciones = numeroPosiciones;
    }
    
    

    public int getPosicionCorredor() {
        return posicionCorredor;
    }

    public void setPosicionCorredor(int posicionCorredor) {
        this.posicionCorredor = posicionCorredor;
    }

    public Usuario getUsuarioAuntenticado() {
        return usuarioAuntenticado;
    }

    public void setUsuarioAuntenticado(Usuario usuarioAuntenticado) {
        this.usuarioAuntenticado = usuarioAuntenticado;
    }
 
    
    public ControladorLocalidadesMotoGP getControlLocalidades() {
        return controlLocalidades;
    }

    public void setControlLocalidades(ControladorLocalidadesMotoGP controlLocalidades) {
        this.controlLocalidades = controlLocalidades;
    }

    public ListaDEGP getListaCorredor() {
        return listaCorredor;
    }

    public void setListaCorredor(ListaDEGP listaCorredor) {
        this.listaCorredor = listaCorredor;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    public String getAlInicio() {
        return alInicio;
    }

    public void setAlInicio(String alInicio) {
        this.alInicio = alInicio;
    }

    public boolean isDeshabilitarFormulario() {
        return deshabilitarFormulario;
    }

    public void setDeshabilitarFormulario(boolean deshabilitarFormulario) {
        this.deshabilitarFormulario = deshabilitarFormulario;
    }

    public String getTextoVista() {
        return textoVista;
    }

    public void setTextoVista(String textoVista) {
        this.textoVista = textoVista;
    }

    public List getListadoCorredor() {
        return listadoCorredor;
    }

    public void setListadoCorredor(List listadoCorredor) {
        this.listadoCorredor = listadoCorredor;
    }
    public short getCodigoEliminar() {
        return codigoEliminar;
    }

    public void setCodigoEliminar(short codigoEliminar) {
        this.codigoEliminar = codigoEliminar;
    }

    public String getCodigoDeptoSel() {
        return codigoDeptoSel;
    }

    public void setCodigoDeptoSel(String codigoDeptoSel) {
        this.codigoDeptoSel = codigoDeptoSel;
    }

    public short getCorredorSeleccionado() {
        return corredorSeleccionado;
    }

    public void setCorredorSeleccionado(short corredorSeleccionado) {
        this.corredorSeleccionado = corredorSeleccionado;
    }

    public Corredor getCorredorDiagrama() {
        return corredorDiagrama;
    }

    public void setCorredorDiagrama(Corredor corredorDiagrama) {
        this.corredorDiagrama = corredorDiagrama;
    }
    
      public DiagramModel getModel() {
        return model;
    }
     
    private Connection createConnection(EndPoint from, EndPoint to, String label) {
        Connection conn = new Connection(from, to);
        conn.getOverlays().add(new ArrowOverlay(20, 20, 1, 1));
         
        if(label != null) {
            conn.getOverlays().add(new LabelOverlay(label, "flow-label", 0.5));
        }
         
        return conn;
    }
       
    
    public void guardarCorredor()
    {
        //obtiene el consecutivo
        corredor.setCodigo((short)(listaCorredor.contarNodos()+1));
        if(alInicio.compareTo("1")==0)
        {
            listaCorredor.adicionarNodoAlInicio(corredor);
        }
        else
        {
            listaCorredor.adicionarNodoGP(corredor);
        }  
        //Vuelvo a llenar la lista para la tabla
        listadoCorredor = listaCorredor.obtenerListaCorredor();
        pintarLista();
        deshabilitarFormulario=true;
        JsfUtil.addSuccessMessage("El corredor se ha guardado exitosamente");
        
    }
    
    public void habilitarFormulario()
    {
        deshabilitarFormulario=false;
        corredor = new Corredor();
    }
    
    public void irAnterior()
    {
        if(ayudante.getAnterior()!=null)
        {
            ayudante = ayudante.getAnterior();
            corredor = ayudante.getDato();
        }        
    }
    
    
    public void irSiguiente()
    {
        if(ayudante.getSiguiente()!=null)
        {
            ayudante = ayudante.getSiguiente();
            corredor = ayudante.getDato();
        }        
    }
    
    public void irPrimero()
    {
        if(listaCorredor.getCabeza()!=null)
        {
            ayudante = listaCorredor.getCabeza();
            corredor = ayudante.getDato();
            
        }
        else
        {
            corredor = new Corredor();
        }
        listadoCorredor = listaCorredor.obtenerListaCorredor();
        pintarLista();
             
    }
    
    public void irUltimo()
    {
        if(listaCorredor.getCabeza()!=null)
        {            
            while(ayudante.getSiguiente()!=null)
            {
                ayudante = ayudante.getSiguiente();
            }
            corredor=ayudante.getDato();
        }
    }
    
    public void cambiarVistaCorredor()
    {
        if(textoVista.compareTo("Tabla clasificacion")==0)
        {
            textoVista = "Carrera";
        }
        else
        {
            textoVista = "Tabla clasificacion";
        }
    }
    
    public void invertirLista(){
        //Invierte la lista
        listaCorredor.invertirLista();
        irPrimero();
    }
    
    
    public void pintarLista() {
        //Instancia el modelo
        model = new DefaultDiagramModel();
        //Se establece para que el diagrama pueda tener infinitas flechas
        model.setMaxConnections(-1);

        StateMachineConnector connector = new StateMachineConnector();
        connector.setOrientation(StateMachineConnector.Orientation.ANTICLOCKWISE);
        connector.setPaintStyle("{strokeStyle:'#7D7463',lineWidth:3}");
        model.setDefaultConnector(connector);

        ///Adicionar los elementos
        if (listaCorredor.getCabeza() != null) {
            //llamo a mi ayudante
            NodoDEGP temp = listaCorredor.getCabeza();
            int posX=3;
            int posY=3;
            //recorro la lista de principio a fin
            while(temp !=null)
            {
                //Parado en un elemento
                //Crea el cuadrito y lo adiciona al modelo
                Element ele = new Element(temp.getDato().getCodigo()+" "+
                        temp.getDato().getNombre(), 
                        posX+"em", posY+"em");
                ele.setId(String.valueOf(temp.getDato().getCodigo()));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.TOP));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_RIGHT));
                
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM_LEFT));
                ele.addEndPoint(new BlankEndPoint(EndPointAnchor.BOTTOM));
                model.addElement(ele);                    
                temp=temp.getSiguiente();
                posX=  posX+0;
                posY= posY+7;
            }            
           /*
            //Pinta las flechas            
            for(int i=0; i < model.getElements().size() -1; i++)
            {
                model.connect(createConnection(model.getElements().get(i).getEndPoints().get(1), 
                        model.getElements().get(i+1).getEndPoints().get(0), "Sig"));
                
                
                model.connect(createConnection(model.getElements().get(i+1).getEndPoints().get(2), 
                        model.getElements().get(i).getEndPoints().get(3), "Ant"));
            }
            */
        }
    }
    
    public void onClickRight() {
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("elementId");
         
        corredorSeleccionado = Short.valueOf(id.replaceAll("frmCorredor:diagrama-", ""));
        
    }

    public void eliminarCorredor()
    {
                if(codigoEliminar >0)
        {
            //llamo el eliminar de la lista
            try{
                listaCorredor.eliminarCorredor(codigoEliminar);
                irPrimero();
                JsfUtil.addSuccessMessage("Corredor "+codigoEliminar +" eliminado.");
            }
            catch(MotoException e)
            {
                JsfUtil.addErrorMessage(e.getMessage());
            }
        }
        else
        {
            JsfUtil.addErrorMessage("El código a eliminar "+codigoEliminar+ " no es válido");
        } 
    }
    
    
    public void obtenerCorredorDiagrama()
    {
        try {
            corredorDiagrama = listaCorredor.obtenerCorredor(corredorSeleccionado);
        } catch (MotoException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    
        public void obtenerGanador()
    {
        try {
            corredorDiagrama = listaCorredor.obtenerGanador();
        } catch (MotoException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void enviarAlFinal()
    {
        try {
            ///Buscar el corredor y guardar los datos en una variable temporal
            Corredor correTemporal = listaCorredor.obtenerCorredor(corredorSeleccionado);
            // Eliminar el nodo
            listaCorredor.eliminarCorredor(corredorSeleccionado);
            // Adicionarlo al final
            listaCorredor.adicionarNodoGP(correTemporal);
            
           // pintarLista();
        } catch (MotoException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    public void enviarAlInicio()
    {
        try {
            ///Buscar el corredor y guardar los datos en una variable temporal
            Corredor correTemporal = listaCorredor.obtenerCorredor(corredorSeleccionado);
            // Eliminar el nodo
            listaCorredor.eliminarCorredor(corredorSeleccionado);
            // Adicionarlo al inicio
            listaCorredor.adicionarNodoAlInicio(correTemporal);
            
           // pintarLista();
        } catch (MotoException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    
    
            
   
    
    public void obtenerPosicionCorredor()
    {
        
     try {
         posicionCorredor = listaCorredor.obtenerCorredorPosicion(corredorSeleccionado);
     } catch (MotoException ex) {
         Logger.getLogger(SesionMotoGP.class.getName()).log(Level.SEVERE, null, ex);
     }

    }
    
    
    
        public void obtenerGanadorDiagrama()
    {
        try {
            corredorDiagrama = listaCorredor.obtenerCorredor(corredorSeleccionado);
        } catch (MotoException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }

    
        public void eliminarCorredorDiagrama()
    {
     try {
         listaCorredor.eliminarCorredor(corredorSeleccionado);
         irPrimero();
     } catch (MotoException ex) {
         Logger.getLogger(SesionMotoGP.class.getName()).log(Level.SEVERE, null, ex);
     }
     
       
            JsfUtil.addErrorMessage("se elimino correcatamente");
       
           
    }
        
        public void cambiarCorredor()
        {

     try {
         listaCorredor.intercambiarCorredor(corredor1, corredor2);
         pintarLista();
     } catch (MotoException ex) {
         Logger.getLogger(SesionMotoGP.class.getName()).log(Level.SEVERE, null, ex);
     }
    }   
       
                
        
   
 public void cambiarPosicion()
    {
        boolean bandera=false;
        int posicionFinal= 0;
        switch(opcionElegida)
        {
            case"1":
                if(numeroPosiciones <= (posicionCorredor -1))
                {
                    bandera=true;
                    posicionFinal = posicionCorredor - numeroPosiciones;
                }
            break;
            case"0":
                if(numeroPosiciones <= (listaCorredor.contarNodos()-posicionCorredor))
                {
                    bandera=true;
                    posicionFinal = posicionCorredor + numeroPosiciones;
                }
                break;
        }
        if(bandera)
        {
            try {
                Corredor datosCorredor = listaCorredor.obtenerCorredor(corredorSeleccionado);
                listaCorredor.eliminarCorredor(corredorSeleccionado);
                listaCorredor.adicionarNodoPosicion(posicionFinal, datosCorredor);
                pintarLista();
                JsfUtil.addSuccessMessage("Se ha realizado el cambio");
            }catch (MotoException ex)
                {
                    JsfUtil.addErrorMessage(ex.getMessage());
                }
        }
    }
 
}

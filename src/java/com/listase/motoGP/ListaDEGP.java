/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.motoGP;





import com.listase.Excepciones.MotoGpExcepcion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author esteban
 */
public class ListaDEGP implements Serializable {
    private NodoDEGP cabeza;
    
    public ListaDEGP() {
    }

    public NodoDEGP getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoDEGP cabeza) {
        this.cabeza = cabeza;
    }
    
    
    public void adicionarNodoGP(Corredor corredor)
    {
        if(cabeza ==null)
        {
            cabeza = new NodoDEGP(corredor);
        }
        else
        {
            //Lamo a mi ayudante
            NodoDEGP temp= cabeza;
            while(temp.getSiguiente()!=null) //Mientras que en siguiente exista algo
            {
                temp= temp.getSiguiente();
            }
            //temp va estar ubicado en el ultimo nodo
            temp.setSiguiente(new NodoDEGP(corredor));
            temp.getSiguiente().setAnterior(temp);
            
        }        
    }
    
    public void adicionarNodoAlInicio(Corredor corredor)
    {
        if(cabeza ==null)
        {
            cabeza = new NodoDEGP(corredor);
        }
        else
        {
            NodoDEGP temp= new NodoDEGP(corredor);
            temp.setSiguiente(cabeza);
            cabeza.setAnterior(temp);
            cabeza= temp;
        }
    }
    
       public short contarNodos()
    {
        if(cabeza ==null)
        {
            return 0;
        }
        else
        {
            //llamar a mi ayudante
            NodoDEGP temp= cabeza;
            short cont=1;
            while(temp.getSiguiente()!=null)
            {
                temp=temp.getSiguiente();
                cont++;
            }
            return cont;
        }
    }
    
    public String obtenerListadoCorredors()
    {
        
        //Un método recursivo que recoora mis corredors y que sacando la
        // info la adicione een el string
        
        return listarCorredors("");
    }
    
    public String listarCorredors(String listado)
    {
        if(cabeza !=null)
        {
            NodoDEGP temp= cabeza;            
            while(temp!=null)
            {
                listado += temp.getDato()+"\n";
                temp=temp.getSiguiente();
                
            }
            return listado;
        }
        return "No hay corredors";
    }
    
    
     public List obtenerListaCorredors()
    {
        List<Corredor> listado = new ArrayList<>();
        //Un método recursivo que recoora mis corredors y que sacando la
        // info la adicione een el string
        listarCorredors(listado);
        return listado;
    }
    
    public void listarCorredors(List listado)
    {
        if(cabeza !=null)
        {
            NodoDEGP temp= cabeza;            
            while(temp!=null)
            {
                //listado += temp.getDato()+"\n";
                listado.add(temp.getDato());
                temp=temp.getSiguiente();                
            }            
        }
        
    }
    
   
    
    public void invertirLista()
    {
        if(cabeza!=null)
        {
            //Crear una lista temporal la cabeza de la lista temporal está vacía
            ListaDEGP listaTemporal = new ListaDEGP();
            // Llamo un ayudante
            NodoDEGP temp= cabeza;
            //Recorro la lista de principio a fin
            while(temp!=null)
            {         
               //Parado en cada nodo , se extrae la información y se
                // envía a la otra lista al inicio
                listaTemporal.adicionarNodoAlInicio(temp.getDato());
                temp=temp.getSiguiente();                
            }   
            //Igualo la cabeza de mi lista principal a la cabeza de la lista temporal
            cabeza= listaTemporal.getCabeza();
        }
    }
    
    public short contarCorredorsxGenero(boolean genero)
    {
        if(cabeza ==null)
        {
            return 0;
        }
        else
        {
            //llamar a mi ayudante
            NodoDEGP temp= cabeza;
            short cont=0;
            while(temp!=null)
            {
                if(temp.getDato().isGenero()==genero)
                {
                  cont++;   
                }                
                temp=temp.getSiguiente();
                
            }
            return cont;
        }
    }
    
    public void eliminarCorredor(short codigo ) throws MotoGpExcepcion
    {
        if(cabeza !=null)
        {
            if(cabeza.getDato().getCodigo()==codigo)
            {
                cabeza=cabeza.getSiguiente();
                cabeza.setAnterior(null);
                return;
            }
            else
            {
                NodoDEGP temp=cabeza;
                while(temp.getSiguiente()!=null)
                {
                    if(temp.getSiguiente().getDato().getCodigo()== codigo)
                    {
                        //el que sigue es el que hay que eliminar
                        temp.setSiguiente(temp.getSiguiente().getSiguiente());
                        if(temp.getSiguiente()!=null)
                            temp.getSiguiente().setAnterior(temp);
                        return;
                    }
                    temp = temp.getSiguiente();
                }
                
                throw new MotoGpExcepcion("El código "+codigo +" no existe en la lista");
            }
        }
        throw new MotoGpExcepcion("La lista de corredors está vacía");
    }
    
      public Corredor obtenerCorredor(short codigo ) throws MotoGpExcepcion
    {
        if(cabeza !=null)
        {
            if(cabeza.getDato().getCodigo()==codigo)
            {                
                return cabeza.getDato();
            }
            else
            {
                NodoDEGP temp=cabeza;
                while(temp!=null)
                {
                    if(temp.getDato().getCodigo()== codigo)
                    {                                                
                        return temp.getDato();
                    }
                    temp = temp.getSiguiente();
                }
                
                throw new MotoGpExcepcion("El código "+codigo +" no existe en la lista");
            }
        }
        throw new MotoGpExcepcion("La lista de corredors está vacía");
    }

    public void EliminarCorredor(short corredorSeleccionado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

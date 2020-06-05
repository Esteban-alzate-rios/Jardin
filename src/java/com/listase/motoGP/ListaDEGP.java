/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.listase.motoGP;






import com.listase.excepciones.MotoException;
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
    
    public String obtenerListadoCorredor()
    {
        
        //Un método recursivo que recoora mis corredors y que sacando la
        // info la adicione een el string
        
        return listarCorredor("");
    }
    
    public String listarCorredor(String listado)
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
    
    
     public List obtenerListaCorredor()
    {
        List<Corredor> listado = new ArrayList<>();
        //Un método recursivo que recoora mis corredors y que sacando la
        // info la adicione een el string
        listarCorredor(listado);
        return listado;
    }
     
      public Corredor obtenerGanador () throws MotoException
    {
        if(cabeza !=null)
        {
            Corredor tiempo = cabeza.getDato();
            NodoDEGP temp = cabeza;
            while(temp != null)
            {
                if(temp.getDato().getEdad()< tiempo.getTiempo())
                {
                    tiempo = temp.getDato();
                }
                temp = temp.getSiguiente();
            }
           return tiempo;
            
        }
    throw new MotoException("La lista de corredores está vacía");

    }
    
    public void listarCorredor(List listado)
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
    
    public short contarCorredorxGenero(boolean genero)
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
    
    public void eliminarCorredor(short codigo ) throws MotoException
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
                
                throw new MotoException("El código "+codigo +" no existe en la lista");
            }
        }
        throw new MotoException("La lista de corredors está vacía");
    }
    
      public Corredor obtenerCorredor(short codigo ) throws MotoException
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
                
                throw new MotoException("El código "+codigo +" no existe en la lista");
            }
        }
        throw new MotoException("La lista de corredors está vacía");
    }

  public int obtenerCorredorPosicion(short codigo ) throws MotoException
    {
        if (cabeza !=null)
        {
          int cont =1;  
          NodoDEGP temp = cabeza;
          while(temp !=null)
          {
                 if(temp.getDato().getCodigo()== codigo)
                 {
                     return cont;
                 }
                temp = temp.getSiguiente();
                 cont++;
          }
          throw new MotoException("El codigo ingresado no exite");
        }
        throw new MotoException("La lista de infantes está vacía");
    }
  
   
       public void adicionarNodoPosicion(int posicion, Corredor dato) throws MotoException
   {
       if (cabeza != null)
       {
         if(posicion ==1)
         {
             adicionarNodoPosicion(posicion, dato);
             return;
         }
         else
         {    
           int cont =1;  
          NodoDEGP temp = cabeza;
          while(temp !=null)
          {
                    if ((posicion - 1) == cont) {
                        NodoDEGP nodoInsertar = new NodoDEGP(dato);
                        nodoInsertar.setSiguiente(temp.getSiguiente());
                        temp.setSiguiente(nodoInsertar);
                        if(nodoInsertar.getSiguiente()!=null)
                            nodoInsertar.getSiguiente().setAnterior(nodoInsertar);
                        nodoInsertar.setAnterior(temp);
                    return;
                 }
                temp = temp.getSiguiente();
                 cont++;
          }
       }
       throw new MotoException(("La lista esta vacia "));
   }
       
   }    

 public void intercambiarCorredor(short codigo1, short codigo2) throws MotoException {
        if (cabeza != null) {
            NodoDEGP temp1 = cabeza;
            NodoDEGP temp2 = cabeza;
            Corredor datotemp = null;
            while (temp1 != null) {
                if (temp1.getDato().getCodigo()== codigo1) {
                    datotemp = temp1.getDato();
                    break;
                }
                temp1 = temp1.getSiguiente();
            }
            while (temp2 != null) {
                if (temp2.getDato().getCodigo()== codigo2) {
                    temp1.setDato(temp2.getDato());
                    temp2.setDato(datotemp);
                    return;
                }
                temp2 = temp2.getSiguiente();
            }
        }
        throw new MotoException("La lista está vacía");
    } 

}

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.Serializable;

/**
 *
 * @author val
 */
public class LSE<S> implements Serializable{

    Nodo<S> primero; 
    int size; 

    public LSE() {
        this.primero = null; 
        this.size = 0; 
    }
    
    public int size(){
        return size;
    }
    
   
    public void add(S dato){
        Nodo<S> nuevo = new Nodo<>(dato);
        if(primero == null){
            this.primero = nuevo;
        } else {
            Nodo<S> aux = primero; 
            
            while(aux.nodoSiguiente != null){
                aux = aux.nodoSiguiente;
            }
          
            aux.nodoSiguiente = nuevo;
        }
        size++;
    }
    
  
    public S get(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("para el indice" + index);
        } else {
            if(index == 0){
                return this.primero.dato; 
            } else {
               Nodo<S> aux = primero; 
               int contador = 0;
               
               while(contador < index){
                   aux = aux.nodoSiguiente; 
                   contador++;
               }       
               return aux.dato; 
            }
        }
    }
    
    public void remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("para el indice " + index);
        } else{
            if (index == 0){
                this.primero = this.primero.nodoSiguiente; 
                size--;
            } else {
            
                Nodo<S> nodoAnterior = null;
                Nodo<S> aux = primero;
                int contador = 0;
                
                while(contador < index){
                    nodoAnterior = aux;
                    aux = aux.nodoSiguiente;
                    contador++;
                }
                
                nodoAnterior.nodoSiguiente = aux.nodoSiguiente;
                size--;
            }
       }
    }
    
    public void addIndex(S dato, int index){
       if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("para el indice " + index);
        } else {
           Nodo<S> nuevo = new Nodo<>(dato);
           if(index == 0 && primero == null){
               this.primero = nuevo;
               size++;
           } else if (index == 0 && primero != null){
               nuevo.nodoSiguiente = this.primero;
               this.primero = nuevo;
               size++;
           } else {
               Nodo<S> anterior = null;
                Nodo<S> aux = primero;
                int contador = 0;

                while(contador < index){
                    anterior = aux;
                    aux = aux.nodoSiguiente;
                    contador++;
                }
                anterior.nodoSiguiente = nuevo;
                nuevo.nodoSiguiente = aux;
                size++;
           }
       } 
    }
}

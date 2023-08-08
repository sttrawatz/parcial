/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import util.LSE;

/**
 *
 * @author val
 */
public class Carpa implements Serializable{
    public static final String DISPONIBLE = "Disponible";
    public static final String OCUPADO = "Ocupado";
    
    private LSE<Persona> listaPersonas;
    
    private String estado;
    private int cantidadPersonas;
    private String clave;
    private String atributoEjemplo;

    public Carpa() {
        listaPersonas = new LSE<>();
        estado = DISPONIBLE;
        cantidadPersonas = 0;
        clave = null;
    }

    public LSE<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(LSE<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}

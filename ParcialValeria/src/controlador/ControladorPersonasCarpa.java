/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import excepciones.LimiteAlcanzadoException;
import excepciones.PersonaYaRegistradaException;
import modelo.Carpa;
import modelo.Persona;
import singleton.Singleton;
import util.LSE;

/**
 *
 * @author val
 */
public class ControladorPersonasCarpa {

    private Carpa carpa;
    private LSE<Persona> listaPersonas;
    private int cantidadPersonas;

    public ControladorPersonasCarpa(Carpa carpa) {
        this.carpa = carpa;
        listaPersonas = carpa.getListaPersonas();
        cantidadPersonas = carpa.getCantidadPersonas();
    }

    public LSE<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void agregarPersonas(Persona persona) {
        if (cantidadPersonas == 3) {
            throw new LimiteAlcanzadoException();
        }
        Persona aux = buscarPersona(persona.getCedula());
        if (aux != null) {
            throw new PersonaYaRegistradaException();
        }

        listaPersonas.add(persona);
        cantidadPersonas++;
        carpa.setCantidadPersonas(cantidadPersonas);
        Singleton.getINSTANCIA().escribirCarpas();
    }

    public Persona buscarPersona(String cedula) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getCedula().equals(cedula)) {
                return listaPersonas.get(i);
            }
        }
        return null;
    }

    public boolean solicitarLlave(String clave) {
        if (carpa.getClave().equals(clave)) {
            return true;
        }
        return false;
    }

    public void desocuparCarpa(){
        carpa.setCantidadPersonas(0);
        carpa.setClave(null);
        carpa.setEstado(Carpa.DISPONIBLE);
        carpa.setListaPersonas(new LSE<>());
        Singleton.getINSTANCIA().escribirCarpas();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Carpa;
import modelo.Persona;
import singleton.Singleton;

/**
 *
 * @author val
 */
public class ControladorCarpas {
    Carpa[][] carpas;

    public ControladorCarpas() {
        carpas = Singleton.getINSTANCIA().getCarpas();
        if(carpas[0][0] == null){
            initCarpas();
        }
    }
    
    public void initCarpas(){
        for (int i = 0; i < carpas.length; i++) {
            for (int j = 0; j < carpas[i].length; j++) {
                carpas[i][j] = new Carpa();
                Singleton.getINSTANCIA().escribirCarpas();
            }
        }
    }
    
    public Carpa obtenerCarpas(int i, int j){
        return carpas[i][j];
    }
    
    public void registrarCarpa(Carpa carpa, Persona persona, String clave){
        carpa.getListaPersonas().add(persona);
        carpa.setCantidadPersonas(1);
        carpa.setClave(clave);
        carpa.setEstado(Carpa.OCUPADO);
        Singleton.getINSTANCIA().escribirCarpas();
    }
    
    
}

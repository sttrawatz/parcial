/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Carpa;

/**
 *
 * @author val
 */
public class Singleton {

    public static Singleton INSTANCIA = new Singleton();
    private Carpa[][] carpas;

    public Singleton() {
        carpas = leerCarpas();
    }

    public static Singleton getINSTANCIA() {
        return INSTANCIA;
    }

    public Carpa[][] getCarpas() {
        return carpas;
    }

    public void escribirCarpas() {
        try {
            FileOutputStream archivo = new FileOutputStream("carpas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(carpas);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Carpa[][] leerCarpas() {
        try {
            FileInputStream archivo = new FileInputStream("carpas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (Carpa[][]) lector.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return new Carpa[3][6];
        }
    }
}

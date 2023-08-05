/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author val
 */
public class LimiteAlcanzadoException extends RuntimeException{

    public LimiteAlcanzadoException() {
        super("no se puede agregar más personas a esta carpa");
    }    
}

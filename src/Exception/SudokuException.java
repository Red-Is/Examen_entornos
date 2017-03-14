/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author user
 */
public class SudokuException extends Exception {
    /**
     * Constructor por defecto
     * @param mensaje Mensaje que lanzará la excepción
     */
    public SudokuException(String mensaje) {
        super(mensaje);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.entornos;

/**
 *
 * @author Alejandro
 * @version 1
 */
public class ExamenEntornos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.inicializar();
        System.out.println(sudoku.toString());
    }
    
}

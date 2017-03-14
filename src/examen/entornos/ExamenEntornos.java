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
    
    private static void menu() {
        System.out.println("1. Iniciar/reiniciar Sudoku.\n"
                + "2. Mostrar Sudoku.\n"
                + "3. Introducir número.\n"
                + "4. Borrar número.\n"
                + "0. Salir.");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        
        
    }
    
}

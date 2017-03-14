/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.entornos;

import Exception.*;

/**
 *
 * @author Alejandro Ariza
 * @version 1
 */
public class ExamenEntornos {
    
    private static String menu() {
        String menu = "1. Iniciar/reiniciar Sudoku.\n"
                        + "2. Mostrar Sudoku.\n"
                        + "3. Introducir número.\n"
                        + "4. Borrar número.\n"
                        + "0. Salir.\n"
                        + "Introduzca una opción: ";
        return menu;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Ciclo formativo: Desarrollo de Aplicaciones Multiplataforma
         * Módulo profesional: Programación 
         * Tema: 
         * Alumno: Alejandro Ariza Guerrero
         * Curso académico: 2016-2017
         * Poniente Formación
         */
        Sudoku sudoku = new Sudoku();
        int opcion = -1;
        do{
            try{
                int fila = 0, columna = 0, elemento = 0;
                ES.println(menu());
                opcion = ES.getInt();
                switch(opcion) {
                    case 1:
                        sudoku.inicializar();
                        ES.println(sudoku.toString());
                        break;
                    case 2:
                        ES.println(sudoku.toString());
                        break;
                    case 3:
                        ES.println("Introduzca la fila: ");
                        fila = ES.getInt();
                        ES.println("Introduzca la columna: ");
                        columna = ES.getInt();
                        ES.println("Introduzca la elemento: ");
                        elemento = ES.getInt();
                        sudoku.modificarElemento(fila-1, columna-1, elemento);
                        break;
                    case 4:
                        ES.println("Introduzca la fila: ");
                        fila = ES.getInt();
                        ES.println("Introduzca la columna: ");
                        columna = ES.getInt();
                        sudoku.vaciarElemento(fila-1, columna-1);
                        break;
                    case 0:
                        ES.println("Saliendo...");
                        break;
                    default:
                        ES.println("Introduce una opción válida.");
                        break;
                }
            }catch(SudokuException e) {
                ES.printErr("Error: " + e);
            }
        } while (opcion != 0);
        
        
    }
    
}

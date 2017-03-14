/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.entornos;

import Exception.SudokuException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Sudoku {

    // Variables privadas de la clase
    private ArrayList<ArrayList<Integer>> sudoku;
    /**
     * Contructor por defecto
     */
    public Sudoku() {
        sudoku = new ArrayList<>();
    }
    
    /**
     * Inicializa el sudoku añadiendo los números al array
     */
    public void inicializar() {
        ArrayList<Integer> fila1 = new ArrayList<>();
        ArrayList<Integer> fila2 = new ArrayList<>();
        ArrayList<Integer> fila3 = new ArrayList<>();
        ArrayList<Integer> fila4 = new ArrayList<>();
        ArrayList<Integer> fila5 = new ArrayList<>();
        ArrayList<Integer> fila6 = new ArrayList<>();
        ArrayList<Integer> fila7 = new ArrayList<>();
        ArrayList<Integer> fila8 = new ArrayList<>();
        ArrayList<Integer> fila9 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fila1.add(0);
            fila2.add(0);
            fila3.add(0);
            fila4.add(0);
            fila5.add(0);
            fila6.add(0);
            fila7.add(0);
            fila8.add(0);
            fila9.add(0);
        }
        fila1.set(0,5);
        fila1.set(1,3);
        fila1.set(4,7);
        fila2.set(0,6);
        fila2.set(3,1);
        fila2.set(4,9);
        fila2.set(5,5);
        fila3.set(1,9);
        fila3.set(2,8);
        fila3.set(7,6);
        fila4.set(0,8);
        fila4.set(4,6);
        fila4.set(8,3);
        fila5.set(0,4);
        fila5.set(3,8);
        fila5.set(5,3);
        fila5.set(8,1);
        fila6.set(0,7);
        fila6.set(4,2);
        fila6.set(8,6);
        fila7.set(1,6);
        fila8.set(3,4);
        fila8.set(4,1);
        fila8.set(5,9);
        fila8.set(8,5);
        fila9.set(4,8);
        fila9.set(7,7);
        fila9.set(8,9);
        sudoku.add(fila1);
        sudoku.add(fila2);
        sudoku.add(fila3);
        sudoku.add(fila4);
        sudoku.add(fila5);
        sudoku.add(fila6);
        sudoku.add(fila7);
        sudoku.add(fila8);
        sudoku.add(fila9);
        
        
    }
    
    /**
     * Da forma gráfica al sudoku y lo devuelve en string
     * @return Devuelve el array sudoku en forma de string
     */
    @Override
    public String toString() {
        String resultadoFinal = "||-----||-----||-----||\n";
        for (int i = 0; i < 9; i++) {
            resultadoFinal += ("||");
            for (int j = 0; j < 9; j++) {
                if (sudoku.get(i).get(j) == 0) {
                    resultadoFinal += (" |");
                } else {
                    resultadoFinal += (sudoku.get(i).get(j) + "|");
                }
                if (j == 2 || j == 5 || j == 8) {
                    resultadoFinal += ("|");
                }
            }

            resultadoFinal += ("\n");
            if (i == 2 || i == 5 || i == 8) {
                resultadoFinal += ("||-----||-----||-----||\n");
            }
        }
        return resultadoFinal;
    }
    
    /**
     * Comprueba si se puede modificar el elemento, si se puede lo modifica, si no lanza una excepción
     * @param fila Fila que contiene el elemento a modificar
     * @param columna Columna que contiene el elemento a modificar
     * @param elemento Elemento a escribir
     * @throws SudokuException Excepción lanzada cuando se introduce una columna o fila fuera del array, o si no se puede introducir ese elemento 
     */
    public void modificarElemento(int fila, int columna, int elemento) throws SudokuException {
        if ((fila >= 0 && fila < 9) && (columna >= 0 && columna < 9)) {
            if(sudoku.get(fila).get(columna) == 0) {
                if(puedoInsertar(fila, columna, elemento)) {
                    sudoku.get(fila).set(columna, elemento);
                } else {
                    throw new SudokuException("El número ya se encuentra en la fila, columna o cuadrante seleccionado.");
                }
            }
            else {
                throw new SudokuException("La casilla seleccionada ya está rellena, borre el número para poder insertar otro.");
            }
        } else {
            throw new SudokuException("Se debe introducir filas y columnas entre 1 y 9.");
        }
    }
    
    /**
     * Sustituye el elemento en esa posición por un cero que luego se representa como vacio
     * @param fila Fila que contiene el elemento a modificar
     * @param columna Columna que contiene el elemento a modificar
     */
    public void vaciarElemento(int fila, int columna) {
        sudoku.get(fila).set(columna, 0);
    }
    
    /**
     * Comprueba que el elemento a escribir no esté en esa fila
     * @param fila Fila que contiene el elemento a modificar
     * @param elemento Elemento a escribir
     * @return true - si el elemento no está en la fila
     * @return false - si el elemento ya se encuentra en la fila
     */
    private boolean comprobarFila(int fila, int elemento) {
        boolean resultado = true;
        for (int i = 0; i < sudoku.get(fila).size(); i++) {
            if (sudoku.get(fila).get(i) == elemento) {
                resultado = false;
            }
        }
        return resultado;
    }
    
    /**
     * Comprueba que el elemento a escribir no esté en esa columna
     * @param columna Columna que contiene el elemento a modificar
     * @param elemento Elemento a escribir
     * @return true - si el elemento no está en la columna
     * @return false - si el elemento ya se encuentra en la columna
     */
    private boolean comprobarColumna(int columna, int elemento) {
        boolean resultado = true;
        for (int i = 0; i < sudoku.get(0).size(); i++) {
            if (sudoku.get(i).get(columna) == elemento) {
                resultado = false;
            }
        }
        return resultado;
    }
    
    /**
     * Comprueba el cuadrante al que pertenece esa fila y columna
     * @param fila Fila que contiene el elemento a modificar
     * @param columna Columna que contiene el elemento a modificar
     * @return devuelve el número del cuadrante en que se encuentras
     */
    public int numeroCuadrante(int fila, int columna)
    {
        int nquad;
        if(fila < 3)
        {
            if(columna < 3)
            {
                nquad = 0;
            }
            else if (columna > 2 && columna < 6)
            {
                nquad = 1;
            }
            else
            {
                nquad = 2;
            }
        }
        else if(fila > 2 && fila < 6)
        {
            if(columna < 3)
            {
                nquad = 3;
            }
            else if (columna > 2 && columna < 6)
            {
                nquad = 4;
            }
            else
            {
                nquad = 5;
            }
        }
        else
        {
            if(columna < 3)
            {
                nquad = 6;
            }
            else if (columna > 2 && columna < 6)
            {
                nquad = 7;
            }
            else
            {
                nquad = 8;
            }
        }
        return nquad;
    }
    
    /**
     * Comprueba que el elemento a escribir no esté en ese cuadrante
     * @param fila Fila que contiene el elemento a modificar
     * @param columna Columna que contiene el elemento a modificar
     * @param elemento Elemento a escribir
     * @return true - si el elemento no está en el cuadrante
     * @return false - si el elemento ya se encuentra en el cuadrante
     */
    private boolean comprobarCuadrante(int fila, int columna, int elemento) {
        boolean resultado = true;
        int ncuadrante = numeroCuadrante(fila, columna);
        
        switch (ncuadrante)
        {
            case 0:
                for(int i = 0; i < 3; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        if (sudoku.get(i).get(j) == elemento)
                        {
                            resultado = false;
                        }
                    }
                }
                break;
            case 1:
                for(int i = 0; i < 3; i++)
                {
                    for (int j = 3; j < 6; j++)
                    {
                        if (this.sudoku.get(i).get(j) == elemento)
                        {
                            resultado = false;
                        }
                    }
                }
                break;
            case 2:
                for(int i = 0; i < 3; i++)
                {
                    for (int j = 6; j < 9; j++)
                    {
                        if (sudoku.get(i).get(j) == elemento)
                        {
                            resultado = false;
                        }
                    }
                }
                break;
            case 3:
                for(int i = 3; i < 6; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        if (sudoku.get(i).get(j) == elemento)
                        {
                            resultado = false;
                        }
                    }
                }
                break;
            case 4:
                for(int i = 3; i < 6; i++)
                {
                    for (int j = 3; j < 6; j++)
                    {
                        if (sudoku.get(i).get(j) == elemento)
                        {
                            resultado = false;
                        }
                    }
                }
                break;
            case 5:
                for(int i = 3; i < 6; i++)
                {
                    for (int j = 6; j < 9; j++)
                    {
                        if (sudoku.get(i).get(j) == elemento)
                        {
                            resultado = false;
                        }
                    }
                }
                break;
            case 6:
                for(int i = 6; i < 9; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        if (sudoku.get(i).get(j) == elemento)
                        {
                            resultado = false;
                        }
                    }
                }
                break;
            case 7:
                for(int i = 6; i < 9; i++)
                {
                    for (int j = 3; j < 6; j++)
                    {
                        if (sudoku.get(i).get(j) == elemento)
                        {
                            resultado = false;
                        }
                    }
                }
                break;
            case 8:
                for(int i = 6; i < 9; i++)
                {
                    for (int j = 6; j < 9; j++)
                    {
                        if (sudoku.get(i).get(j) == elemento)
                        {
                            resultado = false;
                        }
                    }
                }
                break;
            default:
                resultado = false;
                break;
        }
        return resultado;
    }
    
    /**
     * Comprueba que el elemento se pueda insertar en esa posicion
     * @param fila Fila que contiene el elemento a modificar
     * @param columna Columna que contiene el elemento a modificar
     * @param elemento Elemento a escribir
     * @return true - si el elemento se puede insertar
     * @return false - si el elemento no se puede insertar
     */
    private boolean puedoInsertar(int fila, int columna, int elemento) {
        boolean resultado = false;
        if (comprobarFila(fila, elemento) && comprobarColumna(columna, elemento)
                && comprobarCuadrante(fila, columna, elemento)) {
            resultado = true;
        }
        return resultado;
    }
}

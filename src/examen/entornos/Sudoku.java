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

    public Sudoku() {
        sudoku = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ArrayList<Integer> fila = new ArrayList<>();
        }
    }

    public void inicializar() {

    }

    @Override
    public String toString() {
        String resultadoFinal = "||-----||-----||-----||\n";
        for (int i = 0; i < 9; i++) {
            resultadoFinal += ("||");
            for (int j = 0; j < 9; j++) {
                if ((int) sudoku.get(i).get(j) == 0) {
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

    public void modificarElemento(int fila, int columna, int elemento) throws SudokuException {
        if ((fila >= 0 && fila < 9) && (columna >= 0 && columna < 9)) {
            if(puedoInsertar(fila, columna, elemento)) {
                sudoku.get(fila).set(columna, elemento);
            } else {
                throw new SudokuException("El número ya se encuentra en la fila, columna o cuadrante seleccionado.");
            }
        } else {
            throw new SudokuException("Se debe introducir filas y columnas entre 1 y 9.");
        }
    }

    public void vaciarElemento(int fila, int columna) {
        sudoku.get(fila).set(columna, 0);
    }

    private boolean comprobarFila(int fila, int elemento) {
        boolean resultado = true;
        for (int i = 0; i < sudoku.get(fila).size(); i++) {
            if (sudoku.get(fila).get(i) == elemento) {
                resultado = false;
            }
        }
        return resultado;
    }

    private boolean comprobarColumna(int columna, int elemento) {
        boolean resultado = true;
        for (int i = 0; i < sudoku.get(0).size(); i++) {
            if (sudoku.get(i).get(columna) == elemento) {
                resultado = false;
            }
        }
        return resultado;
    }

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

    private boolean puedoInsertar(int fila, int columna, int elemento) {
        boolean resultado = false;
        if (comprobarFila(fila, elemento) && comprobarColumna(columna, elemento)
                && comprobarCuadrante(fila, columna, elemento)) {
            resultado = true;
        }
        return resultado;
    }
}

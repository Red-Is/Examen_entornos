/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.entornos;

import Exception.CadenaVaciaException;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author LopezPC
 */
public final class ES {

    public static int getInt() throws java.util.InputMismatchException {
        int entrada;
        Scanner teclado = new Scanner(System.in);
        entrada = teclado.nextInt();
        return entrada;
    }

    public static String getString() throws CadenaVaciaException, java.util.InputMismatchException {
        String entrada;
        Scanner teclado = new Scanner(System.in);
        entrada = teclado.nextLine();
        if ("".equals(entrada)) {
            throw new CadenaVaciaException("El string está vacio.");
        }
        return entrada;
    }

    public static char getChar() throws java.util.InputMismatchException {
        char entrada;
        Scanner teclado = new Scanner(System.in);
        entrada = teclado.nextLine().charAt(0);
        return entrada;
    }

    public static float getFloat() throws java.util.InputMismatchException {
        float entrada;
        Scanner teclado = new Scanner(System.in);
        entrada = teclado.nextFloat();
        return entrada;
    }

    public static double getDouble() throws java.util.InputMismatchException {
        double entrada;
        Scanner teclado = new Scanner(System.in);
        entrada = teclado.nextDouble();
        return entrada;
    }

    public static void print(Object line) {
        System.out.print(line.toString());
    }

    public static void println(Object line) {
        System.out.println(line.toString());
    }
    
    public static void printErr(Object line) {
        System.err.println(line.toString());
    }
    
    public static void writeFile(String filename, Object toWrite, boolean cond) throws IOException {
        FileWriter file = null;
        PrintWriter pw = null;
        try {
            file = new FileWriter(filename, cond);
            pw = new PrintWriter(file);
            pw.println(toWrite);
        } catch(IOException e) {
            throw new IOException(e);
        } finally {
            try {
                if(pw != null) {
                    pw.close();
                }
                if(file != null) {
                    file.close();
                }
            } catch(IOException e) {
                throw new IOException(e);
            }
        }
    }
    
    public static void readFile() {
        
    }
    
    public static void writeObject() {
        
    }
    
    public static void readObject() {
        
    }

}

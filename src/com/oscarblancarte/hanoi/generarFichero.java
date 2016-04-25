/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarblancarte.hanoi;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * 
 * @author oscar javier
 */
public class generarFichero {

    File f;
    FileWriter ficheroEscritura;
    BufferedWriter escribir;

    public generarFichero() {
        f = new File("C://Torres de Hanoi.txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al crear el fichero");
                return;
            }
        }


        try {
            ficheroEscritura = new FileWriter(f, false);
            escribir = new BufferedWriter(ficheroEscritura);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el fichero");
            return;
        }
    }

    
    /**
     * Metodo encargado de generar un archivo de texto con los datos de la tabla y los totales de movimientos
     * @param tabla es la tabla que contiene todos los movimientos
     * @param totalTorreA Total de movimientos en la torre A
     * @param totalTorreB Total de movimientos en la torre B
     * @param totalTorreC Total de movimientos en la torre C
     */
    public void generarFichero(JTable tabla,int totalTorreA,int totalTorreB,int totalTorreC) {
        int totalFilas = tabla.getRowCount();
        int totalColumnas = 4;
        int i=0;
        
        //Escribimos el titulo
        try {
            escribir.write("\tLas Torres de Hanoi : Ing.Oscar Javier Blancarte Iturralde");
            escribir.newLine();
            escribir.newLine();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al escribir" );
        }
        
        //Escribimos los datos de la tabla en archivo de texto
        for (int c = 0; c < totalFilas; c++) {
            try {
                escribir.write("Num.Movimiento:"+(Integer)tabla.getValueAt(c, i++) + "  |  Disco:"+(Integer)tabla.getValueAt(c, i++)+"  |  De la torre Num.:"+(Integer)tabla.getValueAt(c, i++)+"  |  A la torre Num.:"+(Integer)tabla.getValueAt(c, i++));
                escribir.newLine();
                i=0;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al escribir una linea "+e);
                return;
            }
        }
        
        
        
        //Escribimos los totales
        try {
            escribir.newLine();
            escribir.write("\tTotal TorreA:"+totalTorreA+"\tTotal torreB:"+totalTorreB+"\tTotal torreC:"+totalTorreC);
            escribir.newLine();
            escribir.newLine();
            escribir.write("\t\tTotal de movimientos:"+(totalTorreA+totalTorreB+totalTorreC));
            escribir.newLine();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al escribir" );
        }
        
        try {
            escribir.close();
            ficheroEscritura.close();            
        } catch (Exception e) {}
        
        
        JOptionPane.showMessageDialog(null,"Archivo del juego generado correctamente en C://Torres de Hanoi.txt" );
        Desktop d = Desktop.getDesktop();
        try {
            d.open(f);
        } catch (Exception e) {}
        
    }

    public static void main(String[] args) {
        new generarFichero();
    }
}

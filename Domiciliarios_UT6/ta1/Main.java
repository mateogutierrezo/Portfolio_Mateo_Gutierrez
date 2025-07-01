/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uy.edu.ucu.aed.tas.ta1;

import uy.edu.ucu.aed.tdas.THash;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

/**
 *
 * @author jechague
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear una tabla de tipo THash e insertar las claves del archivo "claves_insertar.txt"
        THash<Integer,Integer> tablaPoderosa = new THash<>(223);
       
        String[] clavesInsertar = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\uy\\edu\\ucu\\aed\\tas\\ta1\\claves_insertar.txt");
        for (int i  = 0; i < clavesInsertar.length; i++) {
            Integer clave = Integer.parseInt(clavesInsertar[i]);
            tablaPoderosa.insertarConContador(clave, clave);
        }
        // Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"

        String[] clavesBuscar = ManejadorArchivosGenerico.leerArchivo("src\\main\\java\\uy\\edu\\ucu\\aed\\tas\\ta1\\claves_buscar.txt");
        int promedio = 0;
        for (int i = 0; i < clavesBuscar.length; i++) {
            Integer clave = Integer.parseInt(clavesBuscar[i]);
            Integer contador = tablaPoderosa.buscarConContador(clave);
            promedio += contador;
            if (tablaPoderosa.buscar(clave) == null) {
                System.out.println(contador + " " + clave + " no encontrado");
            } else {
                System.out.println(contador + " " + clave + " encontrado");
            }
            
        }
        System.out.println("promedio: " + promedio / clavesBuscar.length);
    }
    
}

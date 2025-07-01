/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

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
        THash<Integer,Integer> tablaPoderosa = new THash<>(207);
       
        String[] clavesInsertar = ManejadorArchivosGenerico.leerArchivo("demo\\data\\claves_insertar.txt");
        int compInser = 0;
        for (int i  = 0; i < clavesInsertar.length; i++) {
            Integer clave = Integer.parseInt(clavesInsertar[i]);
            compInser += tablaPoderosa.insertarConContador(clave, clave);
            
        }
        // Buscar en la tabla creada anteriormente las claves indicadas en el archivo "claves_buscar.txt"

        String[] clavesBuscar = ManejadorArchivosGenerico.leerArchivo("demo\\data\\claves_buscar.txt");
        int compBusqExitosa = 0;
        int compBusqNoExitosa = 0;
        int cantBusqExitosa = 0;
        int cantBusqNoExitosa = 0;
        for (int i = 0; i < clavesBuscar.length; i++) {
            Integer clave = Integer.parseInt(clavesBuscar[i]);
            Integer contador = tablaPoderosa.buscarConContador(clave);
            if (tablaPoderosa.buscar(clave) == null) {
                compBusqNoExitosa += contador;
                cantBusqNoExitosa++;
                System.out.println(contador + " " + clave + " no encontrado");
            } else {
                compBusqExitosa += contador;
                cantBusqExitosa++;
                System.out.println(contador + " " + clave + " encontrado");
            }
            
        }
        System.out.println("promedio inserciones: " + compInser / clavesInsertar.length);
        System.out.println("promedio busqueda exitosa: " + compBusqExitosa / cantBusqExitosa);
        System.out.println("promedio busqueda no exitosa: " + compBusqNoExitosa / cantBusqNoExitosa);
    }
    
}

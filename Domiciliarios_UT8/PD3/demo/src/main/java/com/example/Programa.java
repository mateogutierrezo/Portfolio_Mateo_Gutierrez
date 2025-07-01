package com.example;

import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TGrafoRedElectrica laRed = (TGrafoRedElectrica) UtilGrafos.cargarGrafo(
                "demo\\src\\data\\barrio.txt",
                "demo\\src\\data\\distancias.txt",
                false, TGrafoRedElectrica.class);
       
        /*  
          
        calcular la mejor red electrica\
        listar en el archivo "redelectrica.txt" el costo total del cableado
        y las conexiones establecidas, una por linea (origen, destino, costo)
        
        */

        TAristas mejorRed = laRed.mejorRedElectrica();
        String[] lineas = new String[mejorRed.size() + 1];
        Double costoTotal = 0.0;
        int i = 1;
        for (TArista a : mejorRed) {
            costoTotal += a.getCosto();
            lineas[i] = a.getEtiquetaOrigen() + "," + a.getEtiquetaDestino() + "," + a.getCosto();
            i++;
        }
        lineas[0] = "Costo total de la red eléctrica: " + String.valueOf(costoTotal);
        ManejadorArchivosGenerico.escribirArchivo("demo\\src\\data\\redelectrica.txt", lineas);

    }
}

package com.example;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrieTelefonos trieAbonados = new TArbolTrieTelefonos();
       // CARGAR EN EL TRIE LOS TELÉFONOS Y NOMBRES A PARTIR DEL ARCHIVO ABONADOS.TXT
        String[] abonadosTexto = ManejadorArchivosGenerico.leerArchivo("demo\\data\\abonados.txt");
        for (String abonadoTexto : abonadosTexto) {
            String[] datosAbonado = abonadoTexto.split(",");
            String telefono = datosAbonado[0];
            String nombre = datosAbonado[1];
            TAbonado abonado = new TAbonado(nombre, telefono);
            trieAbonados.insertar(abonado);
        }
        String codigoPais = "054" ; // utilizar el indicado en el archivo "codigos.txt"
        String codigoArea = "90" ;// utilizar el indicado en el archivo "codigos.txt"
        LinkedList<TAbonado> ab = trieAbonados.buscarTelefonos(codigoPais, codigoArea);
        
        String[] salida = new String[ab.size()];
        int i = 0;
        for (TAbonado abonado : ab) {
            salida[i] = abonado.getNombre() + "," + abonado.getTelefono();
            i++;
        }

        Arrays.sort(salida);

        ManejadorArchivosGenerico.escribirArchivo("demo\\data\\salida.txt", salida);
        // crear el archivo "salida.txt", con los abonados (1 por linea) 
        // correspondientes al pais y area 
        // imprimir Nombre y teléfono, 
        // ordenados alfabeticamente por nombre
        
      
        
    }
}
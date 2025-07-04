package uy.edu.ucu.aed;

import java.util.LinkedList;

public class Parcial2
{    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // 1 - Cargar el Grafo
        TGrafoRedDatos grafo = UtilGrafos.cargarGrafo("src/main/dispositivos.txt", "src/main/conexiones.txt", false, TGrafoRedDatos.class);

        // 2 - Verificar que los componentes se encuentren conectados
        boolean conectados1 = grafo.conectados("CS10","CS60");
        boolean conectados2 = grafo.conectados("CS30","CS80");
        boolean conectados3 = grafo.conectados("CS80","CS90");

        String[] resultados = new String[4]; 

        resultados[0] = conectados1 ? "CS10 y CS60 están conectados" : "CS10 y CS60 no están conectados";
        resultados[1] = conectados2 ? "CS30 y CS80 están conectados" : "CS30 y CS80 no están conectados";
        resultados[2] = conectados3 ? "CS80 y CS90 están conectados" : "CS80 y CS90 no están conectados";
        
        // 3 - Leer y cargar archivo mediciones.txt
        TDato[] datos = Parcial2.cargarMediciones("src/main/mediciones.txt");
        
        // 4 - Obtener dato de mayor medicion.
        TMedidor medidor = new TMedidor();
        TDato mayorMedicion = medidor.obtenerMayorMedicion(datos);
        
        resultados[3] = "mayor medición: " + mayorMedicion.getValor() + " fecha: " + mayorMedicion.getFecha();
        // 5 - Emitir archivo de salida salida.txt
        // COMPLETAR CÓDIGO
         ManejadorArchivosGenerico.escribirArchivo("src/main/java/salida.txt", resultados);
    }

    private static TDato[] cargarMediciones(String rutaAlArchivo) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(rutaAlArchivo, false);
        
        TDato[] mediciones = new TDato[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            String[] datos = lineas[i].split(",");
            mediciones[i] = new TDato(Double.parseDouble(datos[1]), Integer.parseInt(datos[0]));
        }

        return mediciones;
    }
}

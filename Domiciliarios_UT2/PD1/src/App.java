import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        FileReader fr; 
        try { 
            fr = new FileReader("C:\\Users\\Mateo\\Facultad\\Algoritmos\\UT2\\PD1\\data\\numeros.txt"); 
            BufferedReader br = new BufferedReader(fr); 
            String lineaActual = br.readLine();
            int cantidad = Integer.parseInt(lineaActual);
            int[] arreglo = new int[cantidad + 1];
            arreglo[0] = cantidad;
            int index = 1;
            lineaActual = br.readLine();
            while (lineaActual != null){  
                arreglo[index] = Integer.parseInt(lineaActual);
                index++;
                lineaActual = br.readLine(); 
            }
            br.close();
            miFuncion(arreglo);
            System.out.println("El arreglo contiene " + cantidad + " números.");
            System.out.println("El número más chico es: " + arreglo[1]);
            System.out.println("El número más grande es: " + arreglo[100]);
        } catch (FileNotFoundException e) { 
            System.out.println("Error al leer el archivo " + "C:\\Users\\Mateo\\Facultad\\Algoritmos\\UT2\\PD1\\data\\numeros.txt"); 
            e.printStackTrace(); 
        } catch (IOException e) { 
            System.out.println("Error al leer el archivo " + "C:\\Users\\Mateo\\Facultad\\Algoritmos\\UT2\\PD1\\data\\numeros.txt"); 
            e.printStackTrace(); 
        } 
    }

    public static void miFuncion(int[] arreglo){
        int n = arreglo[0];
        int contador = 0;
        for (int i = 1; i <= n; i++) { 
            for (int j = n; j > i; j--){
                if (arreglo[j] < arreglo[j-1]){
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j-1];
                    arreglo[j-1] = aux;
                    contador++;
                }
            }
        }
        System.out.println("La sentencia if se invocó " + contador +" veces.");
    }
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lector {
    public void leerArchivo(String nombreCompletoArchivo){ 
        FileReader fr; 
            try { 
                fr = new FileReader(nombreCompletoArchivo); 
                BufferedReader br = new BufferedReader(fr); 
                String lineaActual = br.readLine(); 
                while (lineaActual != null){  
                    System.out.println(lineaActual); 
                    lineaActual = br.readLine(); 
                } 
                br.close();
            } catch (FileNotFoundException e) { 
                System.out.println("Error al leer el archivo "+nombreCompletoArchivo); 
                e.printStackTrace(); 
            } catch (IOException e) { 
                System.out.println("Error al leer el archivo "+nombreCompletoArchivo); 
                e.printStackTrace(); 
            } 
        System.out.println("Archivo leido satisfactoriamente"); 
        }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        System.out.println("");
        System.out.println("Ejercicio 2a:");
        leerEntradaArchivo("C:\\Users\\mateo\\Facultad\\Algoritmos\\UT1\\PD6\\LeerEntrada\\src\\entrada1.txt");
        System.out.println("");
        System.out.println("Ejercicio 2b:");
        leerEntradaStdin();
        System.out.println("");
        System.out.println("Ejercicio 3:");
        transformarTextoT9("C:\\\\Users\\\\mateo\\\\Facultad\\\\Algoritmos\\\\UT1\\\\PD6\\\\LeerEntrada\\\\src\\\\entrada2.txt");
    }

    public static void leerEntradaArchivo(String rutaArchivo) {
        try {
            File archivo = new File (rutaArchivo);
            FileReader fr = new FileReader (archivo);
            try (BufferedReader br = new BufferedReader (fr)) {
                String enteroString = br.readLine();
                String puntoFlotanteString = br.readLine();
                String cadena = br.readLine();
                System.out.println("El entero leído es: " + enteroString);
                System.out.println("El número de punto flotante es: " + puntoFlotanteString);
                System.out.println("La cadena leída es: " + cadena);
                float suma = Integer.parseInt(enteroString) + Float.parseFloat(puntoFlotanteString);
                int division = (int) Float.parseFloat(puntoFlotanteString) / Integer.parseInt(enteroString);
                float resto = Float.parseFloat(puntoFlotanteString) % Integer.parseInt(enteroString);
                System.out.println("¡Hola Peter! La suma de " + enteroString + " y " + 
                                    puntoFlotanteString + " es " + suma + ".");
                System.out.println("La división entera de " + puntoFlotanteString + " y " + enteroString + " es " +
                                    division + " y su resto es " + resto + ".");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "+ "entrada.txt");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "+ "entrada.txt");
            e.printStackTrace();
        }
    }

    public static void leerEntradaStdin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el radio de la circunferencia: ");
        String input = scanner.nextLine();
        double radio = Double.parseDouble(input);
        double area = Math.PI * Math.pow(radio, 2);
        double perimetro = 2 * Math.PI * radio;
        System.out.println("El área de la circunferencia es: " + area);
        System.out.println("El perímetro de la circunferencia es: " + perimetro);
        scanner.close();
    }

    public static void transformarTextoT9(String rutaArchivo) {
        try {
            File archivo = new File (rutaArchivo);
            FileReader fr = new FileReader (archivo);
            try (BufferedReader br = new BufferedReader (fr)) {
                String lineaActual = br.readLine();
                FileWriter fw;
                fw = new FileWriter("C:\\\\Users\\\\mateo\\\\Facultad\\\\Algoritmos\\\\UT1\\\\PD6\\\\LeerEntrada\\\\src\\\\salida.txt",true);
                BufferedWriter bw = new BufferedWriter(fw);
                while (lineaActual != null) {
                    try {  
                        lineaActual = lineaActual.toUpperCase();
                        for (int i = 0; i < lineaActual.length(); i++) {
                            if (lineaActual.charAt(i) == 'A' || lineaActual.charAt(i) == 'B' || lineaActual.charAt(i) == 'C') {
                                bw.write('2');
                            } else if (lineaActual.charAt(i) == 'D' || lineaActual.charAt(i) == 'E' || lineaActual.charAt(i) == 'F') {
                                bw.write('3');
                            } else if (lineaActual.charAt(i) == 'G' || lineaActual.charAt(i) == 'H' || lineaActual.charAt(i) == 'I') {
                                bw.write('4');
                            } else if (lineaActual.charAt(i) == 'J' || lineaActual.charAt(i) == 'K' || lineaActual.charAt(i) == 'L') {
                                bw.write('5');
                            } else if (lineaActual.charAt(i) == 'M' || lineaActual.charAt(i) == 'N' || lineaActual.charAt(i) == 'O') {
                                bw.write('6');
                            } else if (lineaActual.charAt(i) == 'P' || lineaActual.charAt(i) == 'Q' || lineaActual.charAt(i) == 'R' || lineaActual.charAt(i) == 'S') {
                                bw.write('7');
                            } else if (lineaActual.charAt(i) == 'T' || lineaActual.charAt(i) == 'U' || lineaActual.charAt(i) == 'V') {
                                bw.write('8');
                            } else if (lineaActual.charAt(i) == 'W' || lineaActual.charAt(i) == 'X' || lineaActual.charAt(i) == 'Y' || lineaActual.charAt(i) == 'Z') {
                                bw.write('9'); 
                            } else if (lineaActual.charAt(i) == ' '){
                                bw.write('0');
                            } else if (lineaActual.charAt(i) == '.'){
                                bw.write('1');
                            }
                            
                        }
                        lineaActual = br.readLine();
                        bw.newLine();
                             
                    } catch (IOException e) {
                        System.out.println("Error al escribir el archivo "+ "salida.txt");
                        e.printStackTrace();
                    }
                      
                }
                bw.close();
                fw.close();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "+ "entrada.txt");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "+ "entrada.txt");
            e.printStackTrace();
        }
    }

}

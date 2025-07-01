public class App {
    public static void main(String[] args) throws Exception {
        Lector lector = new Lector();
        lector.leerArchivo("C:\\Users\\Mateo\\Facultad\\Algoritmos\\UT2\\Lectura Escritura\\entrada.txt");
        String[] numeros = {"1", "2", "3", "4", "5"};
        Escritor escritor = new Escritor();
        escritor.escribirArchivo("C:\\Users\\Mateo\\Facultad\\Algoritmos\\UT2\\Lectura Escritura\\salida.txt", numeros);
    }
}

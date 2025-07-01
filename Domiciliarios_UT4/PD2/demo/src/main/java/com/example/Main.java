package com.example;

public class Main {
    public static void main(String[] args) {
        ejecucion2();
        ejecucion3();
    }

    public static void ejecucion2(){
        TArbolBB<Integer> arbol = new TArbolBB<>();
        String[] claves = ManejadorArchivosGenerico.leerArchivo("demo\\data\\clavesPrueba.txt");
        for (int i = 0; i < claves.length; i++) {
            TElementoAB<Integer> unElemento = new TElementoAB<>(Integer.parseInt(claves[i]), Integer.parseInt(claves[i]));
            arbol.insertar(unElemento);
        }
        ManejadorArchivosGenerico.escribirArchivo("demo\\docs\\Ejecucion2.txt", new String[] {"Preorden:"});
        String pre = arbol.preOrden();
        ManejadorArchivosGenerico.escribirArchivo("demo\\docs\\Ejecucion2.txt", pre.split(","));

        ManejadorArchivosGenerico.escribirArchivo("demo\\docs\\Ejecucion2.txt", new String[] {"\nInorden:"});
        String in = arbol.inOrden();
        ManejadorArchivosGenerico.escribirArchivo("demo\\docs\\Ejecucion2.txt", in.split(","));

        ManejadorArchivosGenerico.escribirArchivo("demo\\docs\\Ejecucion2.txt", new String[] {"\nPostorden:"});
        String post = arbol.postOrden();
        ManejadorArchivosGenerico.escribirArchivo("demo\\docs\\Ejecucion2.txt", post.split(","));
    }

    public static void ejecucion3() {
        TArbolBB<String> arbol = new TArbolBB<>();
        String[] claves = ManejadorArchivosGenerico.leerArchivo("demo\\data\\claves1.txt");
        for (int i = 0; i < claves.length; i++) {
            TElementoAB<String> unElemento = new TElementoAB<>(Integer.parseInt(claves[i]), "");
            arbol.insertar(unElemento);
        }
        System.out.println("10635: " + (arbol.buscar(10635) != null));
        System.out.println("4567: " + (arbol.buscar(4567) != null));
        System.out.println("12: " + (arbol.buscar(12) != null));
        System.out.println("8978: " + (arbol.buscar(8978) != null));
        System.out.println("La décima clave del listado en preorden es: " + arbol.preOrden().split(",")[9]);
    }
}
package com.example;

import com.example.tdas.TGrafoDirigido;
import com.example.tdas.UtilGrafos;

public class Main {
    public static void main(String[] args) {
        pd3();
        pd4();
        pd5();
    }

    public static void pd3() {
        TGrafoDirigido gd = UtilGrafos.cargarGrafo("demo\\src\\data\\aeropuertos.txt", 
        "demo\\src\\data\\conexiones.txt", false, TGrafoDirigido.class);

        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(gd.getVertices()), gd.getVertices(), "Matriz adyacencias");
        UtilGrafos.imprimirMatrizMejorado(gd.floyd(), gd.getVertices(), "Matriz de Floyd");
        System.out.println("Centro del grafo: " + gd.centroDelGrafo());

        System.out.println("bpf desde Montevideo: " + gd.bpf("Montevideo") + "\n");
    }

    public static void pd4() {
        TGrafoDirigido gd = UtilGrafos.cargarGrafo("demo\\src\\data\\aeropuertos_2.txt", 
        "demo\\src\\data\\conexiones_2.txt", false, TGrafoDirigido.class);
        System.out.println("Todos los caminos de San Pablo a Rio de Janeiro:");
        gd.todosLosCaminos("San_Pablo", "Rio_de_Janeiro").imprimirCaminosConsola();
        System.out.println();
    }

    static void pd5() {
        TGrafoDirigido gd = UtilGrafos.cargarGrafo("demo\\src\\data\\aeropuertos_2.txt", 
        "demo\\src\\data\\conexiones_conexas.txt", false, TGrafoDirigido.class);
        System.out.println("¿Es conexo?");
        System.out.println(gd.esConexo() ? "si" : "no");
    }
}
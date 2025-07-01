package com.example;

import com.example.tdas.TGrafoNoDirigido;
import com.example.tdas.TVertice;
import com.example.tdas.UtilGrafos;

public class Main {
    public static void main(String[] args) {
        pd1_ej1();
        pd1_ej2();
        pd1_ej3();

        pd2();
    }

    static void pd1_ej1() {
        TGrafoNoDirigido gnd = UtilGrafos.cargarGrafo("demo\\src\\data\\vertices.txt", 
        "demo\\src\\data\\aristas.txt", false, TGrafoNoDirigido.class);

        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(gnd.getVertices()), gnd.getVertices(), "Matriz costos");

        for (TVertice v : gnd.bpf("a")) {
            System.out.print(v.getEtiqueta() + " ");
        }

        System.out.println("\n");

        gnd.todosLosCaminos("a", "d").imprimirCaminosConsola();
    }

    static void pd1_ej2() {
        TGrafoNoDirigido gnd = UtilGrafos.cargarGrafo("demo\\src\\data\\vertices.txt", 
        "demo\\src\\data\\aristas_prim.txt", false, TGrafoNoDirigido.class);

        TGrafoNoDirigido AAM = gnd.Prim();
        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(AAM.getVertices()), AAM.getVertices(), "Matriz costos AAM");
    }

    static void pd1_ej3() {
        TGrafoNoDirigido gnd = UtilGrafos.cargarGrafo("demo\\src\\data\\vertices.txt", 
        "demo\\src\\data\\aristas_bea.txt", false, TGrafoNoDirigido.class);

        for (TVertice v : gnd.bea("a")) {
            System.out.print(v.getEtiqueta() + " ");
        }
        System.out.println();
    }

    static void pd2() {
        TGrafoNoDirigido gnd = UtilGrafos.cargarGrafo("demo\\src\\data\\vertices.txt", 
        "demo\\src\\data\\aristas_prim.txt", false, TGrafoNoDirigido.class);

        TGrafoNoDirigido AAM = gnd.Kruskal();
        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(AAM.getVertices()), AAM.getVertices(), "Matriz costos AAM");
    }
}
package com.example;

import com.example.tdas.TGrafoDirigido;
import com.example.tdas.UtilGrafos;

public class Main {
    public static void main(String[] args) {
        TGrafoDirigido gd = UtilGrafos.cargarGrafo("demo\\src\\data\\vertices.txt", 
        "demo\\src\\data\\aristas.txt", false, TGrafoDirigido.class);

        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(gd.getVertices()), gd.getVertices(), "Matriz adyacencias");
        UtilGrafos.imprimirMatrizMejorado(gd.floyd(), gd.getVertices(), "Matriz de Floyd");

        System.out.println(gd.obtenerExcentricidad("Montevideo"));
    }
}
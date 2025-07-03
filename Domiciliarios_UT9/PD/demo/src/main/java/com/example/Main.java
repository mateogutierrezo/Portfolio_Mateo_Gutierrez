package com.example;

public class Main {
    public static void main(String[] args) {
        TClasificador clasificador = new TClasificador();
        int[] V1 = {2, 3, 1, 5, 4};
        System.out.println(clasificador.estaOrdenado(clasificador.clasificar(V1, 3)));   
    }
}

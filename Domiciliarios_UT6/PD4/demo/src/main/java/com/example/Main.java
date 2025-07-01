package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("demo\\data\\libro.txt");
        Map<String, Integer> frecuencia = new HashMap<>();
        for (int i = 0; i < lineas.length; i++) {
            String[] palabras =  lineas[i].split(" ");
            for (String palabra : palabras) {
                palabra = palabra.toLowerCase().replaceAll("[^\\p{L}]", "");
                if (!palabra.isEmpty()) {
                    frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                }
            }
        }
        List<Map.Entry<String, Integer>> topPalabras = frecuencia.entrySet()
            .stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .limit(10)
            .toList();
        System.out.println("Top 10 palabras más frecuentes:");
        for (Map.Entry<String, Integer> entry : topPalabras) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}
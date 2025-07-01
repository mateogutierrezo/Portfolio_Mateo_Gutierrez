package com.example;

public class Main {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        pila.apilar(1);
        pila.apilar(10);
        pila.apilar(100);
        pila.apilar(2);

        System.out.println();
        System.out.println(maximosRelativos(pila).imprimir(","));

    }

    public static Pila<Integer> maximosRelativos(Pila<Integer> p) {
        Pila<Integer> r = new Pila<>();
        Integer maxActual = Integer.MIN_VALUE;
        Integer x;
        while (!p.esVacia()) {
            r.apilar(p.desapilar());
        }
    
        // Paso 2: Volver a pasar de r a p, encontrando máximos relativos
        // De este modo procesamos los elementos en el orden original
        while (!r.esVacia()) {
             x = r.desapilar();
            if (x > maxActual) {
                p.apilar(x); // p contiene los máximos relativos en orden de aparición
                maxActual = x;
            }
        }
        while (!r.esVacia()) {
            p.apilar(r.desapilar()); // ahora p contiene los máximos relativos en orden creciente
        }
    
        // Paso 3: volver a pasar de p a r, para que p quede vacía y r sea el resultado
        while (!p.esVacia()) {
            r.apilar(p.desapilar());
        }
        
        return r;
    }
}
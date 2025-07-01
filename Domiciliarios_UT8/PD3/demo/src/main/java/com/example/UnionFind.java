package com.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")

public class UnionFind {
    private final Map<Comparable, Comparable> padre = new HashMap<>();

    public void crearSet(Collection<Comparable> elementos) {
        for (Comparable elem : elementos) {
            padre.put(elem, elem);
        }
    }

    public Comparable encontrar(Comparable x) {
        if (!padre.get(x).equals(x)) {
            padre.put(x, encontrar(padre.get(x))); 
        }
        return padre.get(x);
    }

    public void union(Comparable x, Comparable y) {
        Comparable raizX = encontrar(x);
        Comparable raizY = encontrar(y);
        if (!raizX.equals(raizY)) {
            padre.put(raizX, raizY);
        }
    }

    public boolean conectados(Comparable x, Comparable y) {
        return encontrar(x).equals(encontrar(y));
    }
}
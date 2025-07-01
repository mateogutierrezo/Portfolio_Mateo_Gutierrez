package com.example;

public class Main {
    public static void main(String[] args) {
        TArbolBB<Integer> abb = new TArbolBB<>();
        abb.insertar(new TElementoAB<Integer>(5, 5));
        abb.insertar(new TElementoAB<Integer>(3, 3));
        abb.insertar(new TElementoAB<Integer>(7, 7));
        abb.insertar(new TElementoAB<Integer>(8, 8));
        System.out.println(abb.listarHojas());
    }
}
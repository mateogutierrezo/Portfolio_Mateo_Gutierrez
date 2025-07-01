package com.example;

public class Pila<T> {
    private class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo<T> tope;

    public Pila() {
        this.tope = null;
    }

    public T getTope() {
        return tope.dato;
    }

    public boolean esVacia() {
        return tope == null;
    }

    public void apilar(T dato) {
        Nodo<T> nodo = new Nodo<>(dato);
        nodo.siguiente = tope;
        tope = nodo;
    }

    public T desapilar() {
        if (esVacia()) {
            return null;
        }
        T eliminado = tope.dato;
        tope = tope.siguiente;
        return eliminado;
    }

    public String imprimir() {
        String resultado = "";
        Nodo<T> actual = tope;
        while (actual != null) {
            resultado += actual.dato.toString();
            actual = actual.siguiente;
        }
        return resultado;
    }

    public String imprimir(String separador) {
        String resultado = "";
        Nodo<T> actual = tope;
        while (actual != null) {
            resultado += actual.dato;
            if (actual.siguiente != null) {
                resultado += separador; 
            }
            actual = actual.siguiente;
        }
        return resultado;
    }
}

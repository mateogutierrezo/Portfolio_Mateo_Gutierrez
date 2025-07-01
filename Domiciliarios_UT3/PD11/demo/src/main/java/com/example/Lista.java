package com.example;

public class Lista<T> {

    private class Nodo<T> {

        private final Integer etiqueta;
        private T dato;
        private Nodo<T> siguiente = null;
    
        public Nodo(Integer etiqueta, T dato ) {
            this.etiqueta = etiqueta;
            this.dato = dato;
        }
    }

    private Nodo<T> primero;
    private Nodo<T> ultimo;

    public Lista() {
        primero = null;
        ultimo = null;
    }

    
    public void insertar(T dato, Integer etiqueta) {
        Nodo<T> nodo = new Nodo<T>(etiqueta, dato);
        if (esVacia()) {
            primero = nodo;
            ultimo = nodo;
            return;
        }
        ultimo.siguiente = nodo;
        ultimo = nodo;
    }

    public T buscar(Integer clave) {
        if (esVacia()) {
            return null;
        }
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.etiqueta == clave) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public boolean eliminar(Integer clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.etiqueta == clave) {
            primero = primero.siguiente;
            return true;
        }
        Nodo<T> actual = primero;
        while (actual.siguiente != null) {
            if (actual.siguiente.etiqueta == clave) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public String imprimir() {
        String resultado = "";
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado += actual.etiqueta.toString();
            actual = actual.siguiente;
        }
        return resultado;
    }

    public String imprimir(String separador) {
        String resultado = "";
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado += actual.etiqueta;
            if (actual.siguiente != null) {
                resultado += separador; 
            }
            actual = actual.siguiente;
        }
        return resultado;
    }

    public int cantElementos() {
        int resultado = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado++;
            actual = actual.siguiente;
        }
        return resultado;
    }

    public boolean esVacia() {
        return primero == null;
    }

    //PD11

    //Precondición: la lista está ordenada.
    public void insertarOrdenado(T dato, Integer etiqueta) {
        Nodo<T> nodo = new Nodo<T>(etiqueta, dato);
        if (esVacia()) {
            primero = nodo;
            ultimo = nodo;
            return;
        }
        if(primero.etiqueta >= etiqueta) {
            nodo.siguiente = primero;
            primero = nodo;
            return;
        }
        if(ultimo.etiqueta <= etiqueta) {
            ultimo.siguiente = nodo;
            ultimo = nodo;
            return;
        }
        Nodo<T> actual = primero;
        while (actual.siguiente != null && actual.siguiente.etiqueta <= etiqueta) {
            actual = actual.siguiente;
        }
        nodo.siguiente = actual.siguiente;
        actual.siguiente = nodo;
    }

    public Lista<T> ordenaParesImpares() {
        Lista<T> listaImpares = new Lista<>();
        Lista<T> listaPares = new Lista<>();
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.etiqueta % 2 != 0) {
                listaImpares.insertarOrdenado(actual.dato, actual.etiqueta);
            } else {
                listaPares.insertarOrdenado(actual.dato, actual.etiqueta);
            }
            actual = actual.siguiente;
        }
        return listaImpares.concatenar(listaPares);
    }

    public Lista<T> concatenar(Lista<T> otraLista) {
        ultimo.siguiente = otraLista.primero;
        return this;
    }
}


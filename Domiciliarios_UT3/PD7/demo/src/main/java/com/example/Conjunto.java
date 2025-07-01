package com.example;

public class Conjunto<T> implements IConjunto<T> {

    private Nodo<T> primero;

    public Conjunto() {
        primero = null;
    }

    @Override
    public void insertar(Nodo<T> nodo) {
        if (esVacia()) {
            primero = nodo;
            return;
        }
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null && actual.getSiguiente().compareTo(nodo.getEtiqueta()) == -1) {
            if (actual.getSiguiente().compareTo(nodo.getEtiqueta()) == 0) {
                return;
            }
            actual = actual.getSiguiente();
        }
        nodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nodo);
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        Nodo<T> nodo = new Nodo<T>(etiqueta, dato);
        if (esVacia()) {
            primero = nodo;
            return;
        }
        if (primero.compareTo(etiqueta) == 1) {
            setPrimero(nodo);
            return;
        }
        if (primero.compareTo(etiqueta) == 0) {
            return;
        }
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null && actual.getSiguiente().compareTo(etiqueta) == -1) {
            if (actual.getSiguiente().compareTo(etiqueta) == 0) {
                return;
            }
            actual = actual.getSiguiente();
        }
        nodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nodo);
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        }
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.compareTo(clave) == 0) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.compareTo(clave) == 0) {
            primero = primero.getSiguiente();
            return true;
        }
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().compareTo(clave) == 0) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String resultado = "";
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado += actual.getEtiqueta().toString();
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    @Override
    public String imprimir(String separador) {
        String resultado = "";
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado += actual.getEtiqueta();
            if (actual.getSiguiente() != null) {
                resultado += separador; 
            }
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    @Override
    public int cantElementos() {
        int resultado = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado++;
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(Nodo<T> unNodo) {
        unNodo.setSiguiente(primero);
        primero = unNodo;
    }

    @Override
    public Nodo<T> getPrimero(){
        return primero;
    }

    @Override
    public IConjunto<T> union(IConjunto<T> otroConjunto) {
        IConjunto<T> resultado = new Conjunto<T>();
        Nodo<T> actual1 = primero;
        Nodo<T> actual2 = otroConjunto.getPrimero();
        while (actual1 != null && actual2 != null) {
            if (actual1.compareTo(actual2.getEtiqueta()) == -1) {
                resultado.insertar(actual1.getEtiqueta(), actual1.getDato());
                actual1 = actual1.getSiguiente();
            } else if (actual1.compareTo(actual2.getEtiqueta()) == 1) {
                resultado.insertar(actual2.getEtiqueta(), actual2.getDato());
                actual2 = actual2.getSiguiente();
            } else {
                resultado.insertar(actual1.getEtiqueta(), actual1.getDato());
                actual1 = actual1.getSiguiente();
                actual2 = actual2.getSiguiente();
            }
        }
        while (actual1 != null) {
            resultado.insertar(actual1.getEtiqueta(), actual1.getDato());
            actual1 = actual1.getSiguiente();
        }
        while (actual2 != null) {
            resultado.insertar(actual2.getEtiqueta(), actual2.getDato());
            actual2 = actual2.getSiguiente();
        }
        return resultado;
    }

    @Override
    public IConjunto<T> interseccion(IConjunto<T> otroConjunto) {
        Nodo<T> actual1 = primero;
        Nodo<T> actual2 = otroConjunto.getPrimero();
        IConjunto<T> resultado = new Conjunto<T>();
        while (actual1 != null && actual2 != null) {
            if (actual1.compareTo(actual2.getEtiqueta()) == -1) {
                actual1 = actual1.getSiguiente();
            } else if (actual1.compareTo(actual2.getEtiqueta()) == 1) {
                actual2 = actual2.getSiguiente();                
            } else {
                resultado.insertar(actual1.getEtiqueta(), actual1.getDato());
                actual1 = actual1.getSiguiente();
                actual2 = actual2.getSiguiente();
            }
        }
        return resultado;
    }
}


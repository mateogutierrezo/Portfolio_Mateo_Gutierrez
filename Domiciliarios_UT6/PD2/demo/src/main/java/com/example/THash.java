package com.example;

public class THash<K, V> implements IHash<K, V> {

    private class Nodo<K, V> {
        public final K clave;
        public V valor;
        public Nodo(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }
        @Override
        public String toString() {
            return "(" + clave + " → " + valor + ")";
        }
    }

    private int tamañoModerado;
    private Nodo<K, V>[] tremendoArreglo;

    @SuppressWarnings("unchecked")
    public THash(int tamañoModerado) {
        this.tremendoArreglo = (Nodo<K, V>[]) new Nodo[tamañoModerado];
        this.tamañoModerado = tamañoModerado;
    }

    @Override
    public V buscar(K unaClave) {
        int i = 0;
        int h0 = funcionHashing(unaClave);
        int j;
        do {
            j = (h0 + i) % tamañoModerado;
            if (tremendoArreglo[j] != null && tremendoArreglo[j].clave.equals(unaClave)) {
                return tremendoArreglo[j].valor;
            }
            i++;
        } while(tremendoArreglo[j] != null && i != tamañoModerado);
        return null;
    }

    public int buscarConContador(K unaClave) {
        int i = 0;
        int h0 = funcionHashing(unaClave);
        int j;
        do {
            j = (h0 + i) % tamañoModerado;
            if (tremendoArreglo[j] == null || tremendoArreglo[j].clave.equals(unaClave)) {
                return i + 1;
            }
            i++;
        } while(tremendoArreglo[j] != null && i != tamañoModerado);
        return tamañoModerado;
    }

    @Override
    public boolean insertar(K unaClave, V unValor) {
        int h0 = funcionHashing(unaClave);
        for (int i = 0; tremendoArreglo[i] != null && i != tamañoModerado;i++) {
            int j = (h0 + i) % tamañoModerado;
            if (tremendoArreglo[j] == null) {
                tremendoArreglo[j] = new Nodo<>(unaClave, unValor); ;
                return true;
            }
        }
        return false;
    }

    public int insertarConContador(K unaClave, V unValor) {
        int h0 = funcionHashing(unaClave);
        int i = 0;
        int j;
        do {
            j = (h0 + i) % tamañoModerado;
            if (tremendoArreglo[j] == null) {
                tremendoArreglo[j] = new Nodo<>(unaClave, unValor); 
                return i + 1;
            }
            i++;
        } while (tremendoArreglo[j] != null && i != tamañoModerado);
        return tamañoModerado;
    }
    
    /**
     * Función de hashing que convierte una clave en un índice de la tabla hash.
     * 
     * @param unaClave la clave a convertir en índice.
     * @return el índice correspondiente a la clave.
    */
    protected int funcionHashing(K unaClave) {
        // Implementar una función de hashing adecuada para las claves
        // Por ejemplo, se puede usar el método hashCode() de la clave y aplicar un módulo con el tamaño de la tabla
        return unaClave.hashCode() % tamañoModerado;
    }
}
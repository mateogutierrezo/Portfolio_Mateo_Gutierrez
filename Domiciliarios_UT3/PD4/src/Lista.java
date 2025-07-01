public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    public void insertar(Nodo<T> nodo) {
        if (esVacia()) {
            primero = nodo;
            return;
        }
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nodo);
    }

    public void insertar(Comparable etiqueta, T dato ) {
        Nodo<T> nodo = new Nodo<T>(etiqueta, dato);
        if (esVacia()) {
            primero = nodo;
            return;
        }
        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nodo);
    }

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

    public String imprimir() {
        String resultado = "";
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado += actual.getEtiqueta().toString();
            actual = actual.getSiguiente();
        }
        return resultado;
    }

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

    public int cantElementos() {
        int resultado = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado++;
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public boolean esVacia() {
        return primero == null;
    }

    public void setPrimero(Nodo<T> unNodo) {
        unNodo.setSiguiente(primero);
        primero = unNodo;
    }
}

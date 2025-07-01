public class Lista<T> implements ILista<T> {
    private INodo<T> primero;

    public Lista(){
        this.primero = null;
    }

    @Override
    public void insertar(INodo<T> nodo) {
        if(esVacia()){
            primero = nodo;
            return;
        }
        INodo<T> iterador = primero;
        while(iterador.getSiguiente() != null) {
            iterador = iterador.getSiguiente();
        }
        iterador.setSiguiente(nodo);
    }

    @Override
    public void insertar(Comparable<T> etiqueta, T dato) {
        INodo<T> nodo = new Nodo<T>(etiqueta, dato);
        if(esVacia()){
            primero = nodo;
            return;
        }
        INodo<T> iterador = primero;
        while(iterador.getSiguiente() != null) {
            iterador = iterador.getSiguiente();
        }
        iterador.setSiguiente(nodo);
    }

    @Override
    public INodo<T> buscar(Comparable<T> clave) {
        if (esVacia()) {
            return null;
        }
        INodo<T> iterador = primero;
        while (iterador != null) {
            if (iterador.getEtiqueta().compareTo((T) clave) == 0) {
                return iterador;
            }
            iterador = iterador.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable<T> clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getEtiqueta.compareTo((T) clave) == 0) {
            primero = primero.getSiguiente();
            return true;
        }
        INodo<T> actual = primero;
        while (actual.getSiguiente() != null) {
            if(actual.getSiguiente().getEtiqueta().compareTo((T) clave) == 0){
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        INodo<T> iterador = primero;
        String resultado = "";
        while (iterador != null) {
            resultado += iterador.getEtiqueta();
            iterador = iterador.getSiguiente();
        }
        return resultado;
    }

    @Override
    public String imprimir(String separador) {
        INodo<T> iterador = primero;
        String resultado = "";
        while (iterador != null) {
            resultado += iterador.getEtiqueta();
            
            if (iterador.getSiguiente() != null) {
                resultado += separador;
            }
            iterador = iterador.getSiguiente();
        }
        return resultado;
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        INodo<T> iterador = primero;
        while (iterador != null) {
            contador++;
            iterador = iterador.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(INodo<T> unNodo) {
        unNodo.setSiguiente(primero);
        primero = unNodo;
    }
}

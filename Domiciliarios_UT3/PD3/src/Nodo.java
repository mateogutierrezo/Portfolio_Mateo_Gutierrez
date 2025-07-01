public class Nodo<T> implements INodo<T> {
    private T dato;
    private INodo<T> siguiente;
    private Comparable<T> etiqueta;

    public Nodo(Comparable<T> etiqueta, T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.etiqueta = etiqueta;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public INodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(INodo<T> nodo) {
        this.siguiente = nodo;
    }

    @Override
    public void imprimir() {
        System.out.println(this.dato);
    }

    @Override
    public Comparable<T> getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public int compareTo(INodo<T> otroNodo) {
        return this.etiqueta.compareTo((T) otroNodo.getEtiqueta()); 
    }
}

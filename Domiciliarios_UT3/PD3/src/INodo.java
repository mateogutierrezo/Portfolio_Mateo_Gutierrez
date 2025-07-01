public interface INodo<T> extends Comparable<INodo<T>> {
    /**
     * Devuelve el dato del nodo.
     * @return El dato almacenado en el nodo.
     */
    public T getDato();

    /**
     * Devuelve el siguiente nodo en la lista.
     * @return El siguiente nodo o null si no hay siguiente.
     */
    public INodo<T> getSiguiente();

    /**
     * Asigna otro nodo como siguiente.
     * @param nodo El nodo a enlazar como siguiente.
     */
    public void setSiguiente(INodo<T> nodo);

    /**
     * Imprime los datos del nodo.
     */
    public void imprimir();

    /**
     * Retorna la etiqueta del nodo.
     * @return La etiqueta del nodo.
     */
    public Comparable<T> getEtiqueta();

    /**
     * Compara este nodo con otro según su etiqueta.
     * @param otroNodo El nodo a comparar.
     * @return -1 si este nodo es menor, 0 si son iguales, 1 si es mayor.
     */
    @Override
    public int compareTo(INodo<T> otroNodo);
}

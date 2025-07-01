public interface ILista<T> {

    /**
     * Agrega un nodo al final de la lista.
     * @param nodo Nodo a agregar.
     */
    public void insertar(INodo<T> nodo);

    /**
     * Crea e inserta un nuevo nodo con la etiqueta y dato especificados.
     * @param etiqueta Clave del nuevo nodo.
     * @param dato Dato asociado al nodo.
     */
    public void insertar(Comparable<T> etiqueta, T dato);

    /**
     * Busca un nodo cuya clave es la indicada.
     * @param clave Clave del nodo a buscar.
     * @return El nodo encontrado, o null si no existe.
     */
    public INodo<T> buscar(Comparable<T> clave);

    /**
     * Elimina un nodo cuya clave es la indicada.
     * @param clave Clave del nodo a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     */
    public boolean eliminar(Comparable<T> clave);

    /**
     * Retorna una cadena con las claves de los nodos de la lista.
     * @return String con las claves de la lista.
     */
    public String imprimir();

    /**
     * Retorna una cadena con las claves separadas por el separador especificado.
     * @param separador Separador entre claves.
     * @return String con las claves de la lista separadas por el separador.
     */
    public String imprimir(String separador);

    /**
     * Retorna la cantidad de elementos en la lista.
     * @return Número de elementos en la lista. Si está vacía, retorna 0.
     */
    public int cantElementos();

    /**
     * Indica si la lista está vacía.
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean esVacia();

    /**
     * Establece el primer nodo de la lista.
     * @param unNodo Nodo a establecer como primero.
     */
    public void setPrimero(INodo<T> unNodo);    
}

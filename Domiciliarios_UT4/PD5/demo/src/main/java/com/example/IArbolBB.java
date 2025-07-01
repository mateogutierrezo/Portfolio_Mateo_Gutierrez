package com.example;

public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operacián
     */

    public boolean insertar(TElementoAB<T> unElemento);



    /**
     * Busca un elemento dentro del árbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * 
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String preOrden();

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden();

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String postOrden();

   
       /**
     * Elimina un elemento dada una etiqueta.
     * @param unaEtiqueta 
     */
    public void eliminar(Comparable unaEtiqueta);

	
    //nuevo 

    /**
    * Devuelve la menor clave del árbol
    * @return menor clave del árbol
    */
    public Comparable menorClave();

    /**
     * Devuelve la mayor clave del árbol
     * @return
     */
    public Comparable mayorClave();

    /**
     * Devuelve la clave inmediata anterior a una clave dada.
     * @param clave
     * @return
     */
    public Comparable claveAnterior(Comparable clave);

    /**
     * Devuelve la cantidad de nodos en determinado nivel.
     * @param nivel
     * @return
     */
    public int cantidadEnNivel(int nivel);

    /**
     * lista todas las hojas cada una con su nivel.
     * @return
     */
    public String listarHojas();

    /**
     * Retorna verdadero si es un árbol abb, falso si no.
     * @return
     */
    public boolean esAbb();
}   


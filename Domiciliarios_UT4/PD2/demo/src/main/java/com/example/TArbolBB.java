package com.example;

public class TArbolBB<T> implements IArbolBB<T> {
    private IElementoAB<T> root;

    public TArbolBB() {
        this.root = null; 
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (root == null) {
            root = unElemento;
            return true;
        }
        return root.insertar(unElemento);
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        return root.buscar(unaEtiqueta);
    }

    @Override
    public String preOrden() {
        return root.preOrden();
    }

    @Override
    public String inOrden() {
        return root.inOrden();
    }

    @Override
    public String postOrden() {
        return root.postOrden();
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (root != null) {
            root = root.eliminar(unaEtiqueta);
        }
    }
}

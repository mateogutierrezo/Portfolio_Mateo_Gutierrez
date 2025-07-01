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

    //nuevo
    @Override
    public Comparable menorClave() {
        if (root == null) {
            return null;
        }
        return root.menorClave();
    }

    @Override
    public Comparable mayorClave() {
        if (root == null) {
            return null;
        }
        return root.mayorClave();
    }

    @Override
    public Comparable claveAnterior(Comparable clave) {
        if (root == null) {
            return null;
        }
        return root.claveAnterior(clave);
    }

    @Override
    public int cantidadEnNivel(int nivel) {
        if (root == null) {
            return 0;
        }
        return root.cantidadEnNivel(nivel);
    }

    @Override
    public String listarHojas() {
        if (root == null) {
            return "";
        }
        return root.listarHojas(1);
    }

    @Override
    public boolean esAbb() {
        if (root == null) {
            return true;
        }
        return root.esAbb();
    }
}

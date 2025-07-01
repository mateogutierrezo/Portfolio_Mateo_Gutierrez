package com.example;

public class TElementoAB<T> implements IElementoAB<T> {
    private Comparable etiqueta;
    private T datos;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;

    public TElementoAB(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.datos = datos;
        this.hijoIzq = null;
        this.hijoDer = null;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    } 

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        hijoDer = elemento;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (etiqueta.compareTo(unaEtiqueta) == 0) {
            return this;
        } else if (etiqueta.compareTo(unaEtiqueta) > 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta);
            }
        } else {
            if (hijoDer != null) {
                return hijoDer.buscar(unaEtiqueta);
            }
        }
        return null;
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        if (etiqueta.compareTo(elemento.getEtiqueta()) > 0) {
            if (hijoIzq != null) {
                return hijoIzq.insertar(elemento);
            } else {
                hijoIzq = elemento;
                return true;
            }
        } else if (etiqueta.compareTo(elemento.getEtiqueta()) < 0) {
            if (hijoDer != null) {
                return hijoDer.insertar(elemento);
            } else {
                hijoDer = elemento;
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public String preOrden() {
        String resultado = etiqueta.toString();
        if (hijoIzq != null) {
            resultado += "," + hijoIzq.preOrden(); 
        }
        if (hijoDer != null) {
            resultado += "," + hijoDer.preOrden();
        }
        return resultado;
    }

    @Override
    public String inOrden() {
        String resultado = "";
        if (hijoIzq != null) {
            resultado += hijoIzq.inOrden() + ","; 
        }
        resultado += etiqueta.toString();
        if (hijoDer != null) {
            resultado += "," + hijoDer.inOrden();
        }
        return resultado;
    }

    @Override
    public String postOrden() {
        String resultado = "";
        if (hijoIzq != null) {
            resultado += hijoIzq.postOrden() + ","; 
        }
        if (hijoDer != null) {
            resultado += hijoDer.postOrden() + ",";
        }
        resultado += etiqueta.toString();
        return resultado;
    }

    @Override
    public T getDatos() {
        return datos;
    }
	
    @Override
    public TElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (etiqueta.compareTo(unaEtiqueta) > 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
        } else if (etiqueta.compareTo(unaEtiqueta) < 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
        } else {
            if (hijoIzq != null && hijoDer != null) {
                TElementoAB<T> anterior = hijoIzq;
                TElementoAB<T> padreDeAnterior = this;
                while (anterior.getHijoDer() != null){
                    padreDeAnterior = anterior;
                    anterior = anterior.getHijoDer();
                }
                if (padreDeAnterior != this) {
                    padreDeAnterior.hijoDer = anterior.hijoIzq;
                    anterior.hijoIzq = hijoIzq;
                }

                anterior.hijoDer = hijoDer;
                return anterior;
            } else if (hijoIzq != null) {
                return hijoIzq;
            } else {
                return  hijoDer;
            }
        }
        return this;
    }
}

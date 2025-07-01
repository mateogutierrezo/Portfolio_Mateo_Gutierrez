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


    //nuevo
    @Override
    public Comparable menorClave() {
        if (hijoIzq != null) {
            return hijoIzq.menorClave();
        }
        return etiqueta;
    }  
    
    @Override
    public Comparable mayorClave() {
        if (hijoDer != null) {
            return hijoDer.mayorClave();
        }
        return etiqueta;
    }

    @Override
    public Comparable claveAnterior(Comparable clave) {
        if (clave.compareTo(etiqueta) <= 0) {
            if (hijoIzq != null) {
                return hijoIzq.claveAnterior(clave);
            }
            return null;
        } else {
            if (hijoDer != null) {
                Comparable otraClave = hijoDer.claveAnterior(clave);
                if (otraClave == null || etiqueta.compareTo(otraClave) > 0) {
                    return etiqueta;
                } else {
                    return otraClave;
                }
            }
            return etiqueta;
        }
    }

    @Override
    public int cantidadEnNivel(int nivel) {
        int resultado = 0;
        if (nivel == 1) {
            resultado++;
        }
        if(hijoIzq != null) {
            resultado += hijoIzq.cantidadEnNivel(nivel - 1);
        }
        if (hijoDer != null) {
            resultado += hijoDer.cantidadEnNivel(nivel - 1);
        }
        return resultado;
    }

    @Override
    public String listarHojas(int nivel) {
        String resultado = "";
        if (hijoIzq == null && hijoDer == null) {
            resultado += "(" + etiqueta.toString() + "," + String.valueOf(nivel) + ")"; 
        }
        if (hijoIzq != null) {
            resultado += hijoIzq.listarHojas(nivel + 1);
        }
        if (hijoDer != null) {
            resultado +=  hijoDer.listarHojas(nivel + 1);
        }
        return resultado;
    }

    @Override
    public boolean esAbb() {
        if (hijoIzq == null && hijoDer == null) {
            return true;
        } else if (hijoIzq != null && hijoDer != null) {
            if (etiqueta.compareTo(hijoIzq.etiqueta) < 0 || 
                    etiqueta.compareTo(hijoDer.etiqueta) > 0) {
                return false;
            }
            return hijoIzq.esAbb() && hijoDer.esAbb();
        } else if (hijoIzq == null) {
            if (etiqueta.compareTo(hijoDer.etiqueta) > 0) {
                return false;
            }
            return hijoDer.esAbb();
        } else {
            if (etiqueta.compareTo(hijoIzq.etiqueta) < 0) {
                return false;
            }
            return hijoIzq.esAbb();
        }
    }
}

package com.example.tdas;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author diego
 */
@SuppressWarnings("rawtypes")
public class TCamino implements ICamino {

    private final TVertice origen;
    private LinkedList<Comparable> otrosVertices;
// es una lista de etiquetas de los vertices
// ATENCIÓN: PONER LA CLASE CONCRETA QUE									     	     
// SEA MÁS APROPIADA
    private Double costoTotal = 0.0d;

    public void imprimirEtiquetasConsola() {
        System.out.println(imprimirEtiquetas());
    }

    public TCamino(TVertice v) {
        this.origen = v;
        this.otrosVertices = new LinkedList<>();

    }

    @Override
    public boolean agregarAdyacencia(TAdyacencia adyacenciaActual) {
        if (adyacenciaActual.getDestino() != null) {
            costoTotal = costoTotal + adyacenciaActual.getCosto();
            return getOtrosVertices().add(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(TAdyacencia adyacenciaActual) {
        if (getOtrosVertices().contains(adyacenciaActual.getDestino().getEtiqueta())) {
            costoTotal = costoTotal - adyacenciaActual.getCosto();
            return getOtrosVertices().remove(adyacenciaActual.getDestino().getEtiqueta());
        }
        return false;
    }

    public TVertice getOrigen() {
        return origen;
    }

    public Collection<Comparable> getOtrosVertices() {
        return otrosVertices;
    }

    public void setOtrosVertices(LinkedList<Comparable> otrosVertices) {
        this.otrosVertices = otrosVertices;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public TCamino copiar() {
        TVertice origen = new TVertice(this.getOrigen().getEtiqueta());
        TCamino copia = new TCamino(origen);
        origen.getAdyacentes().addAll(this.getOrigen().getAdyacentes());
        copia.getOtrosVertices().addAll(this.getOtrosVertices());
        copia.setCostoTotal(this.costoTotal);
        return copia;
    }

    @Override
    public String imprimirEtiquetas() {
        String etiquetas = "";
        etiquetas += origen.getEtiqueta();
        for(Comparable etiqueta : otrosVertices) {
            etiquetas += "->" + etiqueta;
        }
        return etiquetas;
    }

    public void imprimirCicloConsola(Comparable etiquetaOrigen) {
        boolean ciclo = false;
        String etiquetasCiclo = "";
        if (origen.getEtiqueta().compareTo(etiquetaOrigen) == 0) {
            ciclo = true;
            etiquetasCiclo += etiquetaOrigen;
        }
        for (Comparable etiqueta : otrosVertices) {
            if (ciclo = true) {
                if (etiquetasCiclo.length() > 0) {
                    etiquetasCiclo += "->";
                }
                etiquetasCiclo += etiqueta;
            }
            if (etiqueta.compareTo(etiquetaOrigen) == 0) {
                ciclo = !ciclo;
            }
        }
        System.out.println(etiquetasCiclo);
    }
}
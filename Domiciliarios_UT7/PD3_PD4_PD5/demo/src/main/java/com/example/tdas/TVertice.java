package com.example.tdas;
import java.util.Collection;
import java.util.LinkedList;
@SuppressWarnings("rawtypes")
public class TVertice<T> implements IVertice {

    private final Comparable etiqueta;
    private LinkedList<TAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public TAdyacencia buscarAdyacencia(TVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(TVertice verticeDestino) {
        TAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, TVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        TAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public TVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        TAdyacencia adyacente = buscarAdyacencia(w.getEtiqueta());
        int index = adyacentes.indexOf(adyacente);
        if (index + 1 < adyacentes.size()) {
            return adyacentes.get(index + 1).getDestino();
        }
        return null;
    }

    @Override
    public TAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (TAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public T getDatos() {
        return datos;
    }


    public Comparable bpf() {
        String result = getEtiqueta().toString();
        setVisitado(true);
        for (IAdyacencia adyacencia : adyacentes) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()){
                result += ", " + destino.bpf();
            }
        }
        return result;
    }

    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) { 
        this.setVisitado(true); 
        for (TAdyacencia adyacencia : this.getAdyacentes()) { 
            TVertice destino = adyacencia.getDestino(); 
            if (!destino.getVisitado()) { 
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) { 
                    TCamino copia = caminoPrevio.copiar(); 
                    copia.agregarAdyacencia(adyacencia); 
                    todosLosCaminos.getCaminos().add(copia); 
                } else { 
                    caminoPrevio.agregarAdyacencia(adyacencia);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia(adyacencia);
                }   
            }    
        }
        this.setVisitado(false); 
        return todosLosCaminos; 
    }

    public void ordenTopologico(LinkedList<TVertice> resultado) {
        setVisitado(true);
        for (TAdyacencia ady : adyacentes) {
            TVertice destino = ady.getDestino();
            if (!destino.getVisitado()) {
                destino.ordenTopologico(resultado);
            }
        }
        resultado.addFirst(this);
    }

    public void esConexo(int[] contador) {
        setVisitado(true);
        contador[0]++;
        for (TAdyacencia ady : adyacentes) {
            TVertice destino = (TVertice) ady.getDestino();
            if (!destino.getVisitado()) {
                destino.esConexo(contador);
            }
        }
    }

}
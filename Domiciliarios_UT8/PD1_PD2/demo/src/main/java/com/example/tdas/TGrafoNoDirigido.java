package com.example.tdas;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@SuppressWarnings("rawtypes")
public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        desvisitarVertices();
        LinkedList<Comparable> verticesAAM = new LinkedList<>();
        LinkedList<Comparable> verticesRestantes = new LinkedList<>();

        verticesRestantes.addAll(getVertices().keySet());

        TAristas aristasAAM = new TAristas();

        Comparable etiquetaVertice = getVertices().values().iterator().next().getEtiqueta();
        verticesAAM.add(etiquetaVertice);
        verticesRestantes.remove(etiquetaVertice);

        while (verticesAAM.size() != getVertices().size()) {
            TArista arista = lasAristas.buscarMin(verticesAAM, verticesRestantes);
            if (arista != null) {
                aristasAAM.add(arista);
                verticesAAM.add(arista.etiquetaDestino);
                verticesRestantes.remove(arista.etiquetaDestino);
            }
        }
        return new TGrafoNoDirigido(getVertices().values(), aristasAAM);
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.addAll(lasAristas);
        aristas.sort(Comparator.comparingDouble(TArista::getCosto));
        LinkedList<TArista> aristasAAM = new LinkedList<>();
        TGrafoNoDirigido AAM = new TGrafoNoDirigido(getVertices().values(), aristasAAM);
        for (TArista a : aristas) {
            if (aristasAAM.size() == getVertices().size() - 1) {
                break;
            }
            if (!AAM.estanConectados(a.getEtiquetaOrigen(), a.getEtiquetaDestino())) {
                AAM.insertarArista(a);
            }
        }
        return AAM;
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        desvisitarVertices();
        LinkedList<TVertice> visitados = new LinkedList<>();
        getVertices().get(etiquetaOrigen).bea(visitados);
        for (TVertice v : getVertices().values()) {
            if (!v.getVisitado()) {
                v.bea(visitados);
            }
        }
        return visitados;
    }
	 
    //pre: las etiquetas corresponden a dos vertices distintos del grafo.
    public boolean estanConectados(Comparable etiquetaU, Comparable etiquetaV) {
        desvisitarVertices();
        return getVertices().get(etiquetaU).hayCamino(etiquetaV);
    }

	@Override
	public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
	@Override
	public boolean esConexo(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

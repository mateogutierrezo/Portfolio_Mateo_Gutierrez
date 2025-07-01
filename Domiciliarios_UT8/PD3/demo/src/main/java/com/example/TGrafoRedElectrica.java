package com.example;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ocamp
 */
public class TGrafoRedElectrica extends TGrafoNoDirigido implements IGrafoRedElectrica{
    
    public TGrafoRedElectrica(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
    }

    @Override
    public TAristas mejorRedElectrica() {
        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.addAll(lasAristas);
        aristas.sort(Comparator.comparingDouble(TArista::getCosto));
        UnionFind uf = new UnionFind();
        uf.crearSet(getVertices().keySet());
        TAristas aristasAAM = new TAristas();
        for (TArista a : aristas) {
            if (!uf.conectados(a.getEtiquetaOrigen(), a.getEtiquetaDestino())) {
                uf.union(a.getEtiquetaOrigen(), a.getEtiquetaDestino());
                aristasAAM.add(a);
            }
        }
        return aristasAAM;
    }

}

package uy.edu.ucu.aed;


/*
 * NO LICENCE 
 * Author: Ing. Agustin Paredes
 */

import java.util.Collection;
import java.util.LinkedList;


/**
 *
 * @author agustinp
 */
public class TGrafoRedDatos extends TGrafoNoDirigido implements ITGrafoRedDatos
{

    public TGrafoRedDatos(Collection<TVertice> vertices, Collection<TArista> aristas)
    {
        // Descomentar la siguiente línea luego de elegir una superclase
        super(vertices, aristas);
    }

    @Override
    public boolean conectados(Comparable a, Comparable b) 
    {
        if (buscarVertice(a) == null || buscarVertice(b) == null) return false;
        desvisitarVertices();
        LinkedList<TVertice> busqueda = new LinkedList<>();
        buscarVertice(a).bpf(busqueda);
        TVertice vb = buscarVertice(b);
        return busqueda.contains(vb);
    }


}

package com.example.tdas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
@SuppressWarnings("rawtypes")
public class TGrafoDirigido implements IGrafoDirigido {
    
    private Map<Comparable, TVertice> vertices; // vertices del grafo.-
    
    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    
    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Double[][] mFloyd = floyd();
        int cantidadVertices = vertices.size();
        Double[] excentricidades = new Double[cantidadVertices];
        for (int i = 0; i < cantidadVertices; i++) {
            Double excentricidad = 0.0d;
            for (int j = 0; j < cantidadVertices; j++) {
                if (excentricidad < mFloyd[i][j]) {
                    excentricidad = mFloyd[i][j];
                }
            }
            excentricidades[i] = excentricidad;
        }
        Double menorExcentricidad = Double.MAX_VALUE;
        int indiceCentro = 0;
        for (int i = 0; i < cantidadVertices; i++) {
            if (menorExcentricidad >= excentricidades[i]) {
                menorExcentricidad = excentricidades[i];
                indiceCentro = i;
            }
        }
        Set<Comparable> etiquetasVertices = vertices.keySet();
        Object[] etiquetasArr = etiquetasVertices.toArray();
        return (Comparable) etiquetasArr[indiceCentro];

    }

    @Override
    public Double[][] floyd() {
        int cantidadVertices = vertices.size();
        Double[][] mCostos = UtilGrafos.obtenerMatrizCostos(vertices);
        Double[][] mFloyd = new Double[cantidadVertices][cantidadVertices];
        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                mFloyd[i][j] = mCostos[i][j];
            }
        }
        for (int k = 0; k < cantidadVertices; k++) {
            for (int i = 0; i < cantidadVertices; i++) {
                for (int j = 0; j < cantidadVertices; j++) {
                    if (mFloyd[i][j] > mFloyd[i][k] + mFloyd[k][j]) {
                        mFloyd[i][j] = mFloyd[i][k] + mFloyd[k][j];
                    }
                }
            }
        }
        return mFloyd;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Double[][] mFloyd = floyd();
        int cantidadVertices = vertices.size();
        Set<Comparable> etiquetasVertices = vertices.keySet();
        Object[] etiquetasArr = etiquetasVertices.toArray();
        int i = 0;
        while (!etiquetasArr[i].equals(etiquetaVertice)) {
            i++;
        }
        Double excentricidad = 0.0d;
        for (int j = 0; j < cantidadVertices; j++) {
            if (mFloyd[i][j] > excentricidad) {
                excentricidad = mFloyd[i][j];
            }
        }
        if (excentricidad == Double.MAX_VALUE) {
            return -1;
        }
        return excentricidad;
    }

    @Override
    public Boolean[][] warshall() {
        int cantidadVertices = vertices.size();
        Double[][] mCostos = UtilGrafos.obtenerMatrizCostos(vertices);
        Boolean[][] mWarshall = new Boolean[cantidadVertices][cantidadVertices];
        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                if (i == j || mCostos[i][j] == Double.MAX_VALUE) {
                    mWarshall[i][j] = false;
                } else {
                    mWarshall[i][j] = true;
                }
            }
        }
        for (int k = 0; k < cantidadVertices; k++) {
            for (int i = 0; i < cantidadVertices; i++) {
                for (int j = 0; j < cantidadVertices; j++) {
                    mWarshall[i][j] = mWarshall[i][k] && mWarshall[k][j];
                }
            }
        }
        return mWarshall;
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable bpf(Comparable etiqueta) {
        desvisitarVertices();
        String resultado = vertices.get(etiqueta).bpf().toString();
        for (IVertice vertice : vertices.values()) {
            if (resultado.split(",").length == vertices.size()) { //no es lo ideal.
                break;
            }
            if (!vertice.getVisitado()) {
                resultado += ", " + vertice.bpf(); 
            }
        }
        return resultado;
    }

    private void desvisitarVertices() {
        for (TVertice vertice : vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) { 
        TCaminos todosLosCaminos = new TCaminos(); 
        TVertice v = buscarVertice(etiquetaOrigen); 
        if(v != null){ 
            TCamino caminoPrevio = new TCamino(v); 
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos); 
            return todosLosCaminos; 
        } 
        return null; 
    }

    public Collection ordenTopologico() {
        LinkedList<TVertice> resultado = new LinkedList<>();
        for (TVertice v : vertices.values()) {
            v.setVisitado(false);
        }
        for (TVertice v : vertices.values()) {
            v.ordenTopologico(resultado);
        }
        return resultado;
    }

    public boolean esConexo() {
        if (vertices.isEmpty()) {
            return true;
        }
        for (TVertice v : vertices.values()) {
            v.setVisitado(false);
        }

        TVertice origen = vertices.values().iterator().next();
        int[] contador = {0};
        origen.esConexo(contador);
        if (contador[0] != vertices.size()) {
            return false;
        }

        TGrafoDirigido transpuesto = this.grafoTranspuesto();
        for (TVertice v : transpuesto.getVertices().values()) {
            v.setVisitado(false);
        }

        contador[0] = 0;
        TVertice origenT = transpuesto.getVertices().get(origen.getEtiqueta());
        origenT.esConexo(contador);
        return contador[0] == vertices.size();
    }

    public TGrafoDirigido grafoTranspuesto() {
        LinkedList<TVertice> verticesGt = new LinkedList<>();
        for (TVertice v : this.vertices.values()) {
            verticesGt.add(v);
        }
        LinkedList<TArista> aristasGt = new LinkedList<>();
        for (TVertice v : this.vertices.values()) {
            for (Object obj : v.getAdyacentes()) {
                TAdyacencia ady = (TAdyacencia) obj;
                TVertice destino = (TVertice) ady.getDestino();
                TArista aristaGt = new TArista(destino.getEtiqueta(), v.getEtiqueta(), ady.getCosto());
                aristasGt.add(aristaGt);
            }
        }
        return new TGrafoDirigido(verticesGt, aristasGt);
    }
}

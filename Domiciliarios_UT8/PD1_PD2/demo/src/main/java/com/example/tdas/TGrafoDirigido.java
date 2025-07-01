package com.example.tdas;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("rawtypes")
public class TGrafoDirigido implements IGrafoDirigido {

    private final Map<Comparable, TVertice> vertices; //lista de vertices del grafo.-
    

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
     * @param nomVerticeOrigen
     * @param nomVerticeDestino
     * @return
     */
    @Override
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
     * Metodo encargado de eliminar un vertice en el grafo. En caso de no
     * existir el v�rtice, retorna falso. En caso de que la etiqueta sea
     * inv�lida, retorna false.
     *
     * @param nombreVertice
     * @return
     */
    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        if (nombreVertice != null) {
            getVertices().remove(nombreVertice);
            return getVertices().containsKey(nombreVertice);
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @param etiquetaOrigen
     * @param etiquetaDestino
     * @return True si existe la adyacencia, false en caso contrario
     */
    @Override
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
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    @Override
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Matodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @param arista
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            tempbool = (vertOrigen != null) && (vertDestino != null);
            if (tempbool) {
                //getLasAristas().add(arista);
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }

        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse v�rtices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del v�rtice a ingresar.
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

    @Override
    public void desvisitarVertices() {
        for (TVertice vertice : this.vertices.values()) {
            vertice.setVisitado(false);
        }
    }

    /**
     * @return the vertices
     */
    @Override
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Collection<TVertice> bpf(TVertice vertice) {
        LinkedList<TVertice> visitados = new LinkedList<>();
        vertice.bpf(visitados);
        for (TVertice v : vertices.values()) {
            if (visitados.size() != vertices.size()) {
                break;
            }
            if (!v.getVisitado()) {
                v.bpf(visitados);
            }
        }
        return visitados;
    }

    @Override
    public Collection<TVertice> bpf() {
        return bpf(vertices.values().iterator().next());
    }

    @Override
    public Collection<TVertice> bpf(Comparable etiquetaOrigen) {
        return bpf(vertices.get(etiquetaOrigen));
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
    public boolean[][] warshall() {
        int cantidadVertices = vertices.size();
        Double[][] mCostos = UtilGrafos.obtenerMatrizCostos(vertices);
        boolean[][] mWarshall = new boolean[cantidadVertices][cantidadVertices];
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

    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) { 
        desvisitarVertices();
        TCaminos todosLosCaminos = new TCaminos(); 
        TVertice v = buscarVertice(etiquetaOrigen); 
        if(v != null){ 
            TCamino caminoPrevio = new TCamino(v); 
            v.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos); 
            return todosLosCaminos; 
        } 
        return null; 
    }

    @Override
    public boolean tieneCiclo(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tieneCiclo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tieneCiclo(TCamino camino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<TVertice> bea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
}

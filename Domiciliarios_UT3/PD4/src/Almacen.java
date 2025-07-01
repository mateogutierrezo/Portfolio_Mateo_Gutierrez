import java.util.Arrays;

public class Almacen implements IAlmacen {
    private String direccion;
    private String telefono;
    private String nombre;
    private Lista<Producto> listaProductos;

    public Almacen(String direccion, String telefono, String nombre) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        this.listaProductos = new Lista<Producto>();
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Lista<Producto> getListaProductos() {
        return this.listaProductos;
    }

    public void insertarProducto(Producto unProducto) {
        if (buscarPorCodigo(unProducto.getEtiqueta()) == null) {
            listaProductos.insertar(unProducto.getEtiqueta(), unProducto);
            return;
        }
        agregarStock(unProducto.getEtiqueta(), unProducto.getStock());
    }

    public boolean eliminar(Comparable clave) {
        return listaProductos.eliminar(clave);
    }

    public String imprimirProductos() {
        return listaProductos.imprimir();
    }

    public String imprimirSeparador(String separador) {
        return listaProductos.imprimir(separador);
    }

    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Producto producto = buscarPorCodigo(clave);
        if (producto != null) {
            producto.setStock(producto.getStock() + cantidad);
            return true;
        }
        return false;
    }

    public Integer restarStock(Comparable clave, Integer cantidad) {
        Producto producto = buscarPorCodigo(clave);
        if (producto != null) {
            Integer nuevoStock = Math.max(0, producto.getStock() - cantidad);
            Integer restado = producto.getStock() - nuevoStock;
            producto.setStock(nuevoStock);
            return restado;
        }
        return null;
    }

    public Producto buscarPorCodigo(Comparable clave) {
        Nodo<Producto> nodo = listaProductos.buscar(clave);
        if (nodo != null) {
            return nodo.getDato();
        }
        return null;
    }

    public int cantidadProductos() {
        return listaProductos.cantElementos();
    }

    public void listarOrdenadoPorNombre() {
        String productosPorEtiqueta = listaProductos.imprimir(",");
        String[] arrayEtiquetas = productosPorEtiqueta.split(",");
        Producto[] productos = new Producto[arrayEtiquetas.length];
        for (int i = 0; i < arrayEtiquetas.length; i++) {
            Comparable codigo = arrayEtiquetas[i];
            productos[i] = buscarPorCodigo(codigo);
        }
        Arrays.sort(productos, (p1, p2) -> p1.getNombre().compareTo(p2.getNombre()));
        for (Producto producto : productos) {
            System.out.println(producto.getEtiqueta() + " " + producto.getNombre() + " " + producto.getPrecio() + " " + producto.getStock());
        }
    }

    public Producto buscarPorDescripcion(String descripcion) {
        return null;
    }
    
   
}

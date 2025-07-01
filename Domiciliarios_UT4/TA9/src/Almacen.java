public class Almacen implements IAlmacen {

    private String nombre;
    private String direccion;
    private String telefono;

    private TArbolBB<Producto> productos;

    public Almacen(String nombre) {
        this.nombre = nombre;
        this.productos = new TArbolBB<Producto>();
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        productos.insertar(new TElementoAB<Producto>(unProducto.getEtiqueta(), unProducto)); 
    }

    @Override
    public String imprimirProductos() {
        String resultado = "";
        String productosInOrden = productos.inOrden();
        if (productosInOrden == null) {
            return null;
        } 
        String[] claves = productosInOrden.split(" ");
        for (int i = 0; i < claves.length; i++) {
            Producto producto = productos.buscar(claves[i]).getDatos();
            resultado += producto.getEtiqueta() + "," + producto.getNombre() + "," + producto.getPrecio() + "," + producto.getStock() + "\n";
        }
        return resultado;
    }

    public String imprimirCodigos() {
        return productos.inOrden();
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        TElementoAB<Producto> producto = productos.buscar(clave);
        if (producto == null) {
            return false;
        }
        producto.getDatos().agergarStock(cantidad);
        return true;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        TElementoAB<Producto> producto = productos.buscar(clave);
        if (producto == null) {
            return -1;
        }
        return producto.getDatos().restarStock(cantidad);
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        TElementoAB<Producto> elemento = productos.buscar(clave);
        if (elemento == null) {
            return null;
        }
        return elemento.getDatos();
    }

    @Override
    public boolean eliminarProducto(Comparable clave) {
        productos.eliminar(clave);
        return productos.buscar(clave) == null;
    }
}

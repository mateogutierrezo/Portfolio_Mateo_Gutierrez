
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Almacen almacenGeant = new Almacen("GEANT");    
        //cargar productos    
        String[] productosAlta = ManejadorArchivosGenerico.leerArchivo("data\\altasPrueba.txt");
        for (int i = 0; i < productosAlta.length; i ++) {
            String[] datosProducto = productosAlta[i].split(",");
            Producto nuevoProducto = new Producto(datosProducto[0], datosProducto[1]);
            nuevoProducto.agergarStock(Integer.parseInt(datosProducto[3]));
            nuevoProducto.setPrecio(Integer.parseInt(datosProducto[2]));
            almacenGeant.insertarProducto(nuevoProducto);
        }

        //listar productos
        System.out.println("Productos:");
        System.out.println(almacenGeant.imprimirProductos());

        //emititr valor del stock
        String[] codigos = almacenGeant.imprimirCodigos().split(" ");
        int valorStock = 0;
        for (int i = 0; i < codigos.length; i++) {
            valorStock += almacenGeant.buscarPorCodigo(codigos[i]).getStock();
        }
        System.out.println("Valor total del stock: " + valorStock);

        //simular ventas
        String[] productosVenta = ManejadorArchivosGenerico.leerArchivo("data\\ventasPrueba.txt");
        for (int i = 0; i < productosVenta.length; i++) {
            String[] datosProducto = productosVenta[i].split(",");
            Producto productoVenta = almacenGeant.buscarPorCodigo(datosProducto[0]);
            if (productoVenta != null) {
                productoVenta.restarStock(Integer.parseInt(datosProducto[1]));
            }
        }
        
        //listar productos
        System.out.println("Productos:");
        System.out.println(almacenGeant.imprimirProductos());

        //simular eliminación
        String[] productosElim = ManejadorArchivosGenerico.leerArchivo("data\\elimPrueba.txt");
        for (int i = 0; i < productosElim.length; i++) {
            almacenGeant.eliminarProducto(productosElim[i]);
        }
        
        //listar productos
        System.out.println("Productos:");
        System.out.println(almacenGeant.imprimirProductos());
    }
}


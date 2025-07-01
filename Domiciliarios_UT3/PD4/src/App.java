public class App {
    public static void main(String[] args) throws Exception {
        Almacen almacenGeant = new Almacen("18 de Julio 1234", "091 345 678", "GEANT");
        altaProductos(almacenGeant);
        almacenGeant.listarOrdenadoPorNombre();
        ventaProdcutos(almacenGeant);
        almacenGeant.listarOrdenadoPorNombre();
    }

    public static void altaProductos(Almacen almacen) {
        String[] lineasAltas = ManejadorArchivosGenerico.leerArchivo("data\\archivos almacen\\altas.txt");
        String[] datosProducto = new String[4];
        Integer total = 0;
        for (int i = 0; i < lineasAltas.length; i++) {
            datosProducto = lineasAltas[i].split(",");
            almacen.insertarProducto(new Producto(datosProducto[1], datosProducto[0], Integer.parseInt(datosProducto[2]), Integer.parseInt(datosProducto[3])));
            total += Integer.parseInt(datosProducto[2]) * Integer.parseInt(datosProducto[3]);
        }
        System.out.println("El total gastado es de: $" + total);
    }

    public static void ventaProdcutos(Almacen almacen) {
        String[] lineasAltas = ManejadorArchivosGenerico.leerArchivo("data\\archivos almacen\\ventas.txt");
        String[] datosProducto = new String[4];
        Integer total = 0;
        Integer vendido;
        for (int i = 0; i < lineasAltas.length; i++) {
            datosProducto = lineasAltas[i].split(",");
            vendido = almacen.restarStock(datosProducto[0], Integer.parseInt(datosProducto[1]));
            Producto producto = almacen.buscarPorCodigo(datosProducto[0]);
            if (producto != null) {
                total += producto.getPrecio() * vendido;
            }
        }
        System.out.println("El total vendido es de: $" + total);
    }
}

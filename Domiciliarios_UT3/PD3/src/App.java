public class App {
    public static void main(String[] args) throws Exception {
        Lista<Integer> lista = new Lista<>();
        lista.insertar(1, 100);
        Nodo<Integer> nodo2 = new Nodo<>(2, 200);
        lista.insertar(nodo2);
        System.out.println(lista.imprimir(","));
        lista.eliminar(2);
        lista.eliminar(1);
        Nodo<Integer> nodo0 = new Nodo<>(0, 500);
        System.out.println(lista.cantElementos());
        System.out.println(lista.esVacia());
        lista.setPrimero(nodo0);
        System.out.println(lista.imprimir(","));
        System.out.println(lista.buscar(0).getEtiqueta());
        System.out.println(lista.buscar(0) == null);
        System.out.println(lista.buscar(6) == null);
        lista.insertar(1, 400);
        lista.insertar(nodo2);
        System.out.println(lista.imprimir());
    }
}

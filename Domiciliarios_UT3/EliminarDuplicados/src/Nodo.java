public class Nodo {
    int valor;
    Nodo siguiente;

    public Nodo(int valor){
        this.valor = valor;
        this.siguiente = null;
    }

    public void imprimirNodo() {
        System.out.print(valor);
    }
}

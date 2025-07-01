public class Principal {
    public static void main(String[] args) throws Exception {
        System.out.println();
        imprimirTablero(30, 15);
    }

    public static void imprimirTablero(int largo, int ancho){
        for (int i = 0; i < largo; i++){
            for (int j = 0; j < ancho; j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }
}

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        String[] Ar1 = {"Hola", "mundo", "de", "los", "algoritmos"};
        String[] Ar2 = {"Hola", "mundo", "de", "la", "informática"};
        System.out.println(Arrays.toString(palabrasComunes(Ar1, Ar2)));
    }

    public static String[] palabrasComunes(String[] palabras1, String[] palabras2) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < palabras1.length; i++) {
            for (int j = 0; j < palabras2.length; j++) {
                if (palabras1[i].equals(palabras2[j])) {
                    result.add(palabras1[i]);
                }
            }
        }
        return result.toArray(new String[0]);
    } 
}

public class Principal {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println("factorial de 3 es: " + factorial(3));
        Ejercicio2(11);
    }

    public static int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void Ejercicio2(long n) {
        if (isPrime(n)) {
            int i = 0;
            int suma = 0;
            while (i <= n) {
                suma += i;
                i += 2;
            }
            System.out.println(n + " es primo y la suma de los números pares desde 0 hasta " + n + " es " + suma);
            return;
        }
        int i = 1;
        int suma = 0;
        while (i <= n) {
            suma += i;
            i += 2;
        }
        System.out.println(n + " no es primo y la suma de los números impares desde 0 hasta " + n + " es " + suma);
    }

    public static boolean isPrime(long n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) {
                prime = false;
                break;
            }
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
            return true;
        } else {
            return false;
        }
    }
}

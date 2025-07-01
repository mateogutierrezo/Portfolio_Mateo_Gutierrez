package com.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(factorial(5));
        System.out.println(factorial(0));
        int[] vectorEnteros = {1,2,3,4,5,6,7};
        invertirComponentes(vectorEnteros, 1, 5); 
        for (int i = 0; i < vectorEnteros.length; i++) {
            System.out.print(vectorEnteros[i]);
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void invertirComponentes(int[] vector, int i, int j) {
        if (i < j) {
            int variable = vector[i];
            vector[i] = vector[j];
            vector[j] = variable; 
            invertirComponentes(vector, i + 1, j - 1);
        }
    }
}
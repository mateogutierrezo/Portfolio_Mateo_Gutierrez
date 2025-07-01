// Ejercicio 5
package com.example;

public class Contador {
  private final int MAX_CONT = 50;
  private int incremento = 1;
  private int contador = 1;

  public void displayCountWhile(){
    while(contador <= MAX_CONT){
      System.out.println(contador);
      contador += incremento;
    }
  }

  public void displayCountDoWhile(){
    do{
      System.out.println(contador);
      contador += incremento;
    }while(contador <= MAX_CONT);
  }

  public void displayCountFor(){
    for(int i = 1; i <= MAX_CONT; i++){
      System.out.println(contador);
      contador += incremento;
    }
      
  }

}
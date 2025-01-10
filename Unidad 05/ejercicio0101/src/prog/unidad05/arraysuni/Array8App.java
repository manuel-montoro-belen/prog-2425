package prog.unidad05.arraysuni;

import java.util.Locale;
import java.util.Scanner;

/**
 * Aplicacion que realiza varias operaciones con un array de reales
 */
public class Array8App {

  private static final int TAM_ARRAY = 8;
  
  public static void main(String[] args) {
    
    // Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Creamos el array
    double[] numeros = new double[TAM_ARRAY];
    
    System.out.println("OPERACIONES VARIAS SOBRE UN ARRAY DE 8 ELEMENTOS");
    
    System.out.println("A continuación se van a solicitar 8 número reales");
    
    // Para cada elemento del array
    for (int i = 0; i < numeros.length; i++) {
      System.out.printf("Introduce el número %d: ", i + 1);
      numeros[i] = Double.parseDouble(sc.nextLine());
    }
    
    // Sumamos todos los elementos
    double suma = 0;
    for (double numero: numeros) {
      suma += numero;
    }
    
    // Imprimimos el resultado
    System.out.printf(Locale.US, "La suma de todos los elementos vale %f%n", suma);

    // Sumamos todos los elementos mayores de 36
    double sumaMayores36 = 0;
    for (double numero: numeros) {
      if (numero > 36) {
        sumaMayores36 += numero;
      }        
    }
    
    // Imprimimos el resultado
    System.out.printf(Locale.US, "La suma de todos los elementos mayores de 36 vale %f%n", sumaMayores36);

    // Contamos los valores mayores a 50
    int contadorMayores50 = 0;
    for (double numero: numeros) {
      if (numero > 50) {
        contadorMayores50++;
      }        
    }
    
    // Imprimimos el resultado
    System.out.printf(Locale.US, "La cantidad de valores mayores de 50 es de %d%n", contadorMayores50);

    double[] mediaEntre10Y30 = calculaMediaEntre10Y30(numeros);
    
    // Imprimimos el resultado
    System.out.printf(Locale.US, "La media de los %f elementos comprendidos entre 10 y 30 vale %f%n", mediaEntre10Y30[0], mediaEntre10Y30[1]);

  }

  private static double[] calculaMediaEntre10Y30(double[] numeros) {
    // Media de valores entre 10 y 30
    int contadorEntre10Y30 = 0;
    double sumaEntre10Y30 = 0;
    for (double numero: numeros) {
      if (numero >= 10 && numero <= 30) {
        contadorEntre10Y30++;
        sumaEntre10Y30 += numero;
      }        
    }
    double[] resultado = new double[2];
    resultado[0] = contadorEntre10Y30;
    resultado[1] = sumaEntre10Y30 / contadorEntre10Y30; 
    return resultado;
  }

}

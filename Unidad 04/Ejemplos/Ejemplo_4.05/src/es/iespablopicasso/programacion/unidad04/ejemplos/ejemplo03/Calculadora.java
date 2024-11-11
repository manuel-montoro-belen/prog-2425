package es.iespablopicasso.programacion.unidad04.ejemplos.ejemplo03;

/**
 * Clase que demuestra valores de retorno haciendo calculos
 */
public class Calculadora {
  
  /**
   * Suma dos enteros 
   * @param operando1 Primer entero a sumar
   * @param operando2 Segundo entero a sumar
   * @return Suma de los dos operandos
   */
  public int suma(int operando1, int operando2) {
    // Suma y devuelve en un solo paso
    return operando1 + operando2;
  }
  
  /**
   * Determina si un número entero es par o no
   * @param numero Numero a comprobar
   * @return true si el número es par o false si no lo es
   */
  public static boolean esPar(int numero) {
    // Si el número es divisible por 2
    if (numero % 2 == 0) {
      // Devuelve true
      return true;
    } else {
      // Si no lo es, devuelve false
      return false;
    }
  }
  
  /**
   * Suma un rango de números
   * @param minimo Valor inicial del rango (incluido)
   * @param maximo Valor final del rango (incluido)
   * @return Suma de los números del rango. Si el rango no es correcto devuelve 0
   */
  public static int sumaRango(int minimo, int maximo) {
    // Si el rango no es correcto
    if (minimo > maximo) {
      // Devuelve 0
      return 0;
    } else {
      // Inicializa la suma
      int suma = 0;
      // Para cada número del rango
      for (int i = minimo; i <= maximo; i++) {
        // Lo añade a la suma
        suma += i;
      }
      // Devuelve la suma
      return suma;
    }
  }

}

package principal;

import cola.Cola;

public class ClasePrincipal {

  public static void main(String[] args) {
    Cola<Integer> colaEnteros = new Cola<>();
    Cola<Double> colaDoble = new Cola<>();
    
    colaEnteros.encola(2);
    colaEnteros.encola(5);
    
    System.out.printf("Tamaño: %d%n", colaEnteros.getLongitudCola());
    
    colaEnteros.desencola();

    System.out.printf("Tamaño: %d%n", colaEnteros.getLongitudCola());
    
    
  }

}

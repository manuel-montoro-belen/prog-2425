package prog.unidad04.atributos.ejercicio1;

import java.util.Scanner;

public class PruebaPizza {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Mostramos la cabecera
    System.out.println("PROGRAMA DE MANEJO DE PIZZAS");
    
    // Solicitamos la cantidad de pizzas a crear
    System.out.print("Introduzca la cantidad de pizzas a crear (1 o mas): ");
    int pizzas = Integer.parseInt(sc.nextLine());
    
    // Para cada pizza
    for (int i = 1; i <= pizzas; i++) {
      // Creamos una nueva pizza
      Pizza pizza = new Pizza();
      Pizza.pizzasCreadas++;
      
      // Pedimos los datos de la pizza
      System.out.printf("Introduce el tamaño de la pizza %d (mediana/familiar): ", i);
      pizza.tamanyo = sc.nextLine();
      System.out.printf("Introduce el tipo de la pizza %d (margarita / cuatro quesos / funghi): ", i);
      pizza.tipo = sc.nextLine();
      System.out.print("¿Servir la pizza? (s / n): ");
      char respuesta = sc.nextLine().charAt(0);
      if (respuesta == 's') {
        pizza.estado = "servida";
        Pizza.pizzasServidas++;
      } else {
        pizza.estado = "pedida";
      }
      
      // Imprimimos datos de la pizza
      System.out.printf("Datos de la pizza %d%n", i);
      System.out.printf("Tamaño: %s%n", pizza.tamanyo);
      System.out.printf("Tipo: %s%n", pizza.tipo);
      System.out.printf("Estado: %s%n", pizza.estado);
      System.out.printf("Pizzas Creadas: %d%n", Pizza.pizzasCreadas);
      System.out.printf("Pizzas Servidas: %d%n", Pizza.pizzasServidas);
    }
  }

}

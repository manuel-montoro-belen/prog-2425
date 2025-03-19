package prog.unidad07.ejercicio01;

import java.util.ArrayList;
import java.util.List;

/**
 * Prueba las figuras
 */
public class Main {

  public static void main(String[] args) {
    // Lista de figuras
    List<Figura> figuras = new ArrayList<>();
    
    // La rellenamos
    figuras.add(new Circulo(new Punto(0, 0), 25.2));
    figuras.add(new Rectangulo(new Punto(0, 0), new Punto(10, 10)));
    figuras.add(new Rectangulo(new Punto(10, 10), new Punto(20, 15)));
    figuras.add(new Triangulo(new Punto(0, 0), new Punto(10, 10), new Punto(10, 0)));
    
    // Para cada figura
    int i = 1;
    for (Figura figura: figuras) {
      System.out.printf("Figura: %d: area = %f, perimetro = %f, ¿es regular? = \"%s\"%n"
        , i, figura.getArea(), figura.getPerimetro(), figura.isRegular() ? "si" : "no");
      i++;
    }
  }

}

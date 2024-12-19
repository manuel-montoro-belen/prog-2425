package prog.unidad04.actividad405.ejercicio02.pruebas;

import prog.unidad04.actividad405.ejercicio02.Circulo;
import prog.unidad04.actividad405.ejercicio02.Figura;
import prog.unidad04.actividad405.ejercicio02.Punto;
import prog.unidad04.actividad405.ejercicio02.Rectangulo;
import prog.unidad04.actividad405.ejercicio02.Triangulo;
import java.util.Locale;

/**
 * Clase que prueba las figuras
 */
public class PruebaFigurasApp {

  public static void main(String[] args) {
    
    // Cabecera
    System.out.println("PROGRAMA DE PRUEBA DE FIGURAS");
    
    // Creamos figuras variadas 
    // Un triangulo irregular
    Figura triangulo = new Triangulo(new Punto(0,0), new Punto(0,1), new Punto(1,0));
    double angulo60Grados = 2 * Math.PI / 3;
    // Uno regular
    Figura trianguloRegular = new Triangulo(new Punto(0,0), new Punto(0.5, 0.87), new Punto(1, 0));
    
    
    // Otro "malo" (los tres puntos están alineados). Debe lanzar una excepción
    try {
      System.out.println("Intentado crear un triángulo con los vertices alineados");
      Figura trianguloMalo = new Triangulo(new Punto(0,0), new Punto (2, 1), new Punto(4,2));
      // Esta línea no debería ejecutarse porque lo anterior deberia fallar
      System.out.println("Error. Se ha creado un triángulo con los vértices alineados");
    } catch (IllegalArgumentException e) {
      System.out.println("OK. Se evitó crear el triángulo");
    }

    // Circulo
    Circulo circulo = new Circulo(new Punto(0,0), 2.5);
    
    // Otro "malo" (el radio es negativo). Debe lanzar una excepción
    try {
      System.out.println("Intentado crear un círculo con el radio negativo");
      Circulo circuloMalo = new Circulo(new Punto(0,0), -2);
      // Esta línea no debería ejecutarse porque lo anterior deberia fallar
      System.out.println("Error. Se ha creado un círculo de radio de negativo");
    } catch (IllegalArgumentException e) {
      System.out.println("OK. Se evitó crear el círculo");
    }

    // Y dos rectángulos. El segundo es en realidad un cuadrado
    Figura rectangulo = new Rectangulo(new Punto(0, 0), new Punto(2, 3));
    Figura cuadrado = new Rectangulo(new Punto(0, 0), new Punto(2, 2));
    
    // Calculamos área, perímetro y regularidad de todas las figuras
    System.out.printf(Locale.US, "Area triangulo irregular = %f%n", triangulo.area());
    System.out.printf(Locale.US, "Perimetro triangulo irregular = %f%n", triangulo.perimetro());
    System.out.printf("Es regular el triángulo irregular?: %s%n", (triangulo.esRegular() ? "si" : "no"));
    System.out.printf(Locale.US, "Area triangulo regular = %f%n", trianguloRegular.area());
    System.out.printf(Locale.US, "Perimetro triangulo regular = %f%n", trianguloRegular.perimetro());
    System.out.printf("Es regular el triángulo regular?: %s%n", (trianguloRegular.esRegular() ? "si" : "no"));
    System.out.printf(Locale.US, "Area circulo = %f%n", circulo.area());
    System.out.printf(Locale.US, "Perimetro circulo (circunferencia) = %f%n", circulo.perimetro());
    System.out.printf("Es regular el círculo?: %s%n", (circulo.esRegular() ? "si" : "no"));
    System.out.printf(Locale.US, "Area rectángulo no cuadrado = %f%n", rectangulo.area());
    System.out.printf(Locale.US, "Perimetro rectángulo no cuadrado = %f%n", rectangulo.perimetro());
    System.out.printf("El rectangulo no cuadrado es cuadrado?: %s%n", (rectangulo.esRegular() ? "si" : "no"));
    System.out.printf(Locale.US, "Area rectángulo cuadrado = %f%n", cuadrado.area());
    System.out.printf(Locale.US, "Perimetro rectángulo cuadrado = %f%n", cuadrado.perimetro());
    System.out.printf("El rectángulo cuadrado es cuadrado?: %s%n", (cuadrado.esRegular() ? "si" : "no"));
  }

}

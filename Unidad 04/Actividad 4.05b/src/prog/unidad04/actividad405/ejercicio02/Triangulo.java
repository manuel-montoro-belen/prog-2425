package prog.unidad04.actividad405.ejercicio02;

/**
 * Representa a un triángulo
 */
public class Triangulo implements Figura {

  /**
   * Primer vértice
   */
  private Punto primerVertice;

  /**
   * Segundo vértice
   */
  private Punto segundoVertice;
  
  /**
   * Tercer vértice
   */
  private Punto tercerVertice;
  
  /**
   * Crea un triángulo aa partir de los tres vértices (es importante que no formen parte de la misma línea)
   * @param vertice1 Primer vértice del triángulo
   * @param vertice2 Segundo vértice del triángulo
   * @param vertice3 Tercer vértice del triángulo
   */
  public Triangulo(Punto vertice1, Punto vertice2, Punto vertice3) {
    this.primerVertice = vertice1;
    this.segundoVertice = vertice2;
    this.tercerVertice = vertice3;
  }
  
  /**
   * Obtiene el área del triángulo
   * @return Área del triángulo
   */
  public double area() {
    // Calculamos las longitudes de los tres lados (a, b y c)
    double a = getLongitudSegmento(primerVertice, segundoVertice);
    double b = getLongitudSegmento(segundoVertice, tercerVertice);
    double c = getLongitudSegmento(tercerVertice, primerVertice);
    
    // Según la fórmula de Heron, en primer lugar calculamos s
    double s = (a + b + c) / 2;
    
    // Y el área a partir de s
    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
  }
  
  /**
   * Obtiene el perímetro del triángulo
   * @return Perímetro del triángulo
   */
  public double perimetro() {
    // Calculamos las longitudes de los tres lados (a, b y c)
    double a = getLongitudSegmento(primerVertice, segundoVertice);
    double b = getLongitudSegmento(segundoVertice, tercerVertice);
    double c = getLongitudSegmento(tercerVertice, primerVertice);
    
    // Y las sumamos para obtener el resultado
    return a + b + c;
  }
  
  /**
   * Calcula la longitud del segmento situado entre los dos puntos dados
   * @param p1 Punto origen del segmento
   * @param p2 Punto destino del segmento
   * @return Longitud del segmento
   */
  private double getLongitudSegmento(Punto p1, Punto p2) {
    // Aplicamos el teorema de Pitágoras
    return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
  }

  @Override
  public boolean esRegular() {
    double lado1 = getLongitudSegmento(primerVertice, segundoVertice);
    double lado2 = getLongitudSegmento(segundoVertice, tercerVertice);
    double lado3 = getLongitudSegmento(tercerVertice, primerVertice);
    return lado1 == lado2 && lado2 == lado3;
  }
}

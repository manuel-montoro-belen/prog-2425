package prog.unidad07.ejercicio01;

public class Triangulo extends Figura {

  // Atributos
  // Tres vertices
  private Punto vertice1;
  private Punto vertice2;
  private Punto vertice3;
  
  public Triangulo(Punto vertice1, Punto vertice2, Punto vertice3) {
    this.vertice1 = vertice1;
    this.vertice2 = vertice2;
    this.vertice3 = vertice3;
  }

  @Override
  public double getArea() {
    double lado1 = vertice1.distancia(vertice2);
    double lado2 = vertice2.distancia(vertice3);
    double lado3 = vertice3.distancia(vertice1);
    
    // Según la fórmula de Heron, en primer lugar calculamos s
    double s = (lado1 + lado2 + lado3) / 2;
    
    // Y el área a partir de s
    return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
  }

  @Override
  public double getPerimetro() {
    double lado1 = vertice1.distancia(vertice2);
    double lado2 = vertice2.distancia(vertice3);
    double lado3 = vertice3.distancia(vertice1);
    
    return lado1 + lado2 + lado3;
  }

  @Override
  public boolean isRegular() {
    double lado1 = vertice1.distancia(vertice2);
    double lado2 = vertice2.distancia(vertice3);
    double lado3 = vertice3.distancia(vertice1);
    
    return lado1 == lado2 && lado2 == lado3;
  }
}

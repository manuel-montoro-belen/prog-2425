package prog.unidad07.ejercicio01;

public class Rectangulo extends Figura {

  // Atributos
  // Esquina superior izquierda
  private Punto esquinaSuperiorIzquierda;
  // Esquina inferior derecha
  private Punto esquinaInferiorDerecha;
  
  public Rectangulo(Punto esquina1, Punto esquina2) {
    this.esquinaSuperiorIzquierda = esquina1;
    this.esquinaInferiorDerecha = esquina2;
  }

  @Override
  public double getArea() {
    return getLadoHorizontal() * getLadoVertical();
  }

  @Override
  public double getPerimetro() {
    return 2 * getLadoHorizontal() + 2 * getLadoVertical();
  }

  @Override
  public boolean isRegular() {
    return getLadoHorizontal() == getLadoVertical();
  }

  private double getLadoHorizontal() {
    return Math.abs(esquinaInferiorDerecha.getX() - esquinaSuperiorIzquierda.getX());
  }
  
  private double getLadoVertical() {
    return Math.abs(esquinaSuperiorIzquierda.getY() - esquinaInferiorDerecha.getY());
  }
}

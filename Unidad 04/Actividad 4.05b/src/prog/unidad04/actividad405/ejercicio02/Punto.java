package prog.unidad04.actividad405.ejercicio02;

/**
 * Representa un punto del plano
 */
public class Punto {

  /**
   * Coordenada X del punto
   */
  private double x;
  /**
   * Coordenada Y del punto
   */
  private double y;
  
  /**
   * Constructor
   * @param x Coordenada X del punto
   * @param y Coordenada Y del punto
   */
  public Punto(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Obtiene la coordenada X del punto
   * @return Coordenada X del punto
   */
  public double getX() {
    return x;
  }

  /**
   * Obtiene la coordenada Y del punto
   * @return Coordenada Y del punto
   */
  public double getY() {
    return y;
  }
}

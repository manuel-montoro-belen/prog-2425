package prog.unidad04.actividad405.ejercicio02;

/**
 * Clase que representa a un rectángulo
 */
public class Rectangulo implements Figura {

  /**
   * Esquina
   */
  private Punto esquina1;
  
  /**
   * Esquina opuesta
   */
  private Punto esquina2;
  
  /**
   * Crea un nuevo rectángulo a partir de dos esquinas opuestas del mimo
   * @param esquina1 Punto de una esquina del rectángulo
   * @param esquina2 Punto de la esquina opuesta del rectángulo
   */
  public Rectangulo(Punto esquina1, Punto esquina2) {
    this.esquina1 = esquina1;
    this.esquina2 = esquina2;
  }
  
  /**
   * Obtiene el área del rectángulo
   * @return Área del rectángulo
   */
  public double area() {
    return getDistancia(esquina1.getX(), esquina2.getX()) * getDistancia(esquina1.getY(), esquina2.getY());
  }

  /**
   * Obtiene el perímetro del rectángulo
   * @return Perímetro del rectángulo
   */
  public double perimetro() {
    return 2 * getDistancia(esquina1.getX(), esquina2.getX()) + 2 * getDistancia(esquina1.getY(), esquina2.getY());
  }

  /**
   * Determina si el rectángulo es realmente un cuadrado
   * @return true si el rectángulo es un cuadrado (tiene los cuatro lados iguales) o false si no.
   */
  public boolean esCuadrado() {
    return getDistancia(esquina1.getX(), esquina2.getX()) == getDistancia(esquina1.getY(), esquina2.getY());
  }

  /**
   * Calcula la distancia entre dos coordenadas en un mismo eje
   * @param coordenada1 Primera coordenada
   * @param coordenada2 Segunda coordenada
   * @return Distancia entre las dos coordenadas
   */
  private double getDistancia(double coordenada1, double coordenada2) {
    return Math.abs(coordenada1 - coordenada2);
  }

  @Override
  public boolean esRegular() {
    return esCuadrado();
  }
}

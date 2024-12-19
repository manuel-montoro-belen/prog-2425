package prog.unidad04.actividad405.ejercicio02;

/**
 * Interfaz que define los métodos que tienen todas las figuras
 */
public interface Figura {

  /**
   * Devuelve el área de la figura
   * @return Área de la figura
   */
  double area();
  
  double perimetro();
  
  boolean esRegular();
}

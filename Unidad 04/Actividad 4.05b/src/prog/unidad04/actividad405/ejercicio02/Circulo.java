package prog.unidad04.actividad405.ejercicio02;

/**
 * Clase que representa a un círculo
 */
public class Circulo implements Figura {

  /**
   * Centro del círculo
   */
  private Punto centro;
  
  /**
   * Radio del círculo. Debería ser positivo
   */
  private double radio;
  
  /**
   * Crea un círculo con el centro y radio dados
   * @param centro Punto que será el centro del círculo
   * @param radio Radio del círculo (debería ser mayor que cero)
   */
  public Circulo(Punto centro, double radio) {
    if (radio < 0) {
      System.out.println("Error. El circulo no  puede tener un radio negativo");
    } else {
      this.centro = centro;
      this.radio = radio;
    }
  }
  
  /**
   * Obtiene el área del círculo
   * @return Area del círculo
   */
  public double area() {
    return Math.PI * radio * radio;
  }
  
  /**
   * Obtiene el perímetro (circunferencia) del círculo
   * @return Perimetro del círculo
   */
  public double perimetro() {
    return 2 * Math.PI * radio;
  }

  @Override
  public boolean esRegular() {
    return true;
  }
}

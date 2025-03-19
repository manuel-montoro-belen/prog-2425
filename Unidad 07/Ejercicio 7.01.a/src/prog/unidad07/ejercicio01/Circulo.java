package prog.unidad07.ejercicio01;

public class Circulo extends Figura {

  // Atributos
  // Centro
  private Punto centro;
  // Radio
  private double radio;
  
  public Circulo(Punto centro, double radio) {
    this.centro = centro;
    this.radio = radio;
  }
  
  @Override
  public double getArea() {
    return Math.PI * radio * radio;
  }

  @Override
  public double getPerimetro() {
    return 2 * Math.PI * radio;
  }

  @Override
  public boolean isRegular() {
    return true;
  }
}

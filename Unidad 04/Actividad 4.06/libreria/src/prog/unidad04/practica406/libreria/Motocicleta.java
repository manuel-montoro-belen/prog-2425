package prog.unidad04.practica406.libreria;

public class Motocicleta extends Vehiculo implements MaquinaConDistintivoAmbiental {
  
  private static final int CILINDRADA_MINIMA = 50;
  
  // Atributos
  protected int cilindrada;

  public Motocicleta(String matricula, Fecha fechaMatriculacion, int cilindrada) {
    super(matricula, fechaMatriculacion);
    if (esCilindradaValida(cilindrada)) {
      this.cilindrada = cilindrada;
    } else {
      vehiculosMatriculados--;
      throw new IllegalArgumentException("La cilindrada no es válida");
    }
  }
  
  public int getCilindrada() {
    return cilindrada;
  }

  @Override
  public String getDistintivo() {
    if (cilindrada < 75) {
      return "0";
    } else if (cilindrada >= 75 && cilindrada <= 125) {
      return "ECO";
    } else if (cilindrada > 125 && cilindrada <= 500) {
      return "A";
    } else {
      return "B";
    }
  }

  private boolean esCilindradaValida(int cilindrada) {
    return cilindrada >= CILINDRADA_MINIMA;
  }
  
  public String toString() {
    return String.format("%s, Cilindrada: %d", super.toString(), cilindrada);
  }

}

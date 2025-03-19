package prog.ud07.relacion1.ejercicio3;

public abstract class Cuenta {

  // Constantes
  // Porcentaje de comisión
  private static final double PORCENTAJE_COMISION = 0.10;
  // Comision maxima
  private static final double COMISION_MAXIMA = 10;
  
  // Atributos
  // Nombre
  protected String nombre;
  // DNI
  protected String dni;
  // Saldo
  protected double saldo;
  
  public Cuenta(String nombre, String dni) {
    this.nombre = nombre;
    this.dni = dni;
    this.saldo = 0;
  }

  public void ingresa(double cantidad) {
    if (cantidad > 0) {
      saldo += cantidad;
    }
  }
  
  public void retira(double cantidad) {
    if (cantidad > 0) {
      saldo -= cantidad;
    }
  }
  
  public void actualiza() {
    double interes = getInteres();
    double comision = getComision();
    double penalizacion = getPenalizacion();
    
    saldo += interes - comision - penalizacion;
  }
  
  public double getComision() {
    double porcentaje = saldo * PORCENTAJE_COMISION;
    if (porcentaje < COMISION_MAXIMA) {
      return porcentaje;
    } else {
      return COMISION_MAXIMA;
    }
  }
  
  public abstract double getInteres();
  
  public abstract double getPenalizacion();
}

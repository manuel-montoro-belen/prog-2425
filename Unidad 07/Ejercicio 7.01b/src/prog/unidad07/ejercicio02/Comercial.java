package prog.unidad07.ejercicio02;

public class Comercial extends Empleado {
  
  // Constantes
  private static final double PORCENTAJE_BAJO = 0.05;
  private static final double PORCENTAJE_MEDIO = 0.08;
  private static final double PORCENTAJE_ALTO = 0.10;
  private static final int SALARIO_MINIMO = 300;
  
  // Atributos
  // Ventas
  private double ventas;

  public Comercial(String nombre, String dni, String telefono, double ventas) {
    super(nombre, dni, telefono);
    this.ventas = ventas;
  }

  @Override
  public double getSalario() {
    
    double salario = 0;
    if (ventas <= 10000) {
      salario = ventas * PORCENTAJE_BAJO;
    } else if (ventas > 10000 && ventas <= 30000) {
      salario = ventas * PORCENTAJE_MEDIO;
    } else {
      salario = ventas * PORCENTAJE_ALTO;
    }
    
    if (salario < SALARIO_MINIMO) {
      salario = SALARIO_MINIMO;
    }
    
    return salario;
  }

}

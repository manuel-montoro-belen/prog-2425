package prog.unidad07.ejercicio02;

public class Comisionista extends EmpleadoFijo {
  
  // Atributos
  // Comision sobre las ventas
  private double comision;
  // Ventas
  private double ventas;

  public Comisionista(String nombre, String dni, String telefono,
      double salarioFijo, double comision, double ventas) {
    super(nombre, dni, telefono, salarioFijo);
    this.comision = comision;
    this.ventas = ventas;
  }

  @Override
  public double getSalario() {
    return super.getSalario() + comision * ventas;
  }
}

package prog.unidad07.ejercicio02;

public class EmpleadoFijo extends Empleado {

  // Atributo
  // Salario fijo
  protected double salarioFijo;
  
  
  public EmpleadoFijo(String nombre, String dni, String telefono,
      double salarioFijo) {
    super(nombre, dni, telefono);
    this.salarioFijo = salarioFijo;
  }


  @Override
  public double getSalario() {
    return salarioFijo;
  }

}

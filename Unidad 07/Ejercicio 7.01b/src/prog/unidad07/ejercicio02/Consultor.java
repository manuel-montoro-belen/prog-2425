package prog.unidad07.ejercicio02;

public class Consultor extends Empleado {
  
  // Atributos
  private double tarifa;
  // Horas
  private int horas;

  public Consultor(String nombre, String dni, String telefono, double tarifa,
      int horas) {
    super(nombre, dni, telefono);
    this.tarifa = tarifa;
    this.horas = horas;
  }

  @Override
  public double getSalario() {
    return tarifa * horas;
  }

}

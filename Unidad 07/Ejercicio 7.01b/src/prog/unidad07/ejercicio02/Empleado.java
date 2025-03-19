package prog.unidad07.ejercicio02;

public abstract class Empleado {
  
  // Atributos
  // Nombre completo
  protected String nombre;
  // DNI
  protected String dni;
  // Telefono
  protected String telefono;
  
  /**
   * 
   * @param nombre
   * @param dni
   * @param telefono
   */
  public Empleado(String nombre, String dni, String telefono) {
    this.nombre = nombre;
    this.dni = dni;
    this.telefono = telefono;
  }
  
  public abstract double getSalario();

}

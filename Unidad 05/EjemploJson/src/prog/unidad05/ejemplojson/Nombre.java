package prog.unidad05.ejemplojson;

public class Nombre {

  private String nombre;
  private String apellidos;
  
  
  public Nombre(String nombre, String apellidos) {
    this.nombre = nombre;
    this.apellidos = apellidos;
  }


  public String getNombre() {
    return nombre;
  }


  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public String getApellidos() {
    return apellidos;
  }


  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }
  
  
}

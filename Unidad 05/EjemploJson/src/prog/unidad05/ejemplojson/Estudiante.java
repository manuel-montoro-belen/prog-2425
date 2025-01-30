package prog.unidad05.ejemplojson;

import java.util.List;

public class Estudiante {
  
  private String nombreTitulacion;
  private Nombre nombre;
  private String email;
  private boolean repite;
  private List<String> amigos;
  private Asignatura[] asignaturas;
  
  public Estudiante(String nombreTitulacion, Nombre nombre, String email, boolean repite,
      List<String> amigos, Asignatura[] asignaturas) {
    this.nombreTitulacion = nombreTitulacion;
    this.nombre = nombre;
    this.email = email;
    this.repite = repite;
    this.amigos = amigos;
    this.asignaturas = asignaturas;
  }

  public String getNombreTitulacion() {
    return nombreTitulacion;
  }

  public void setNombreTitulacion(String nombreTitulacion) {
    this.nombreTitulacion = nombreTitulacion;
  }

  public Nombre getNombre() {
    return nombre;
  }

  public void setNombre(Nombre nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean isRepite() {
    return repite;
  }

  public void setRepite(boolean repite) {
    this.repite = repite;
  }

  public List<String> getAmigos() {
    return amigos;
  }

  public void setAmigos(List<String> amigos) {
    this.amigos = amigos;
  }

  public Asignatura[] getAsignaturas() {
    return asignaturas;
  }

  public void setAsignaturas(Asignatura[] asignaturas) {
    this.asignaturas = asignaturas;
  }
  
  
}

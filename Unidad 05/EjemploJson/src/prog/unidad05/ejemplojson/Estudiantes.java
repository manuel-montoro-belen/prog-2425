package prog.unidad05.ejemplojson;

import java.util.ArrayList;
import java.util.List;

public class Estudiantes {

  private List<Estudiante> estudiantes;
  
  public Estudiantes() {
    estudiantes = new ArrayList<>();
  }
  
  public void addEstudiante(Estudiante estudiante) {
    estudiantes.add(estudiante);
  }
}

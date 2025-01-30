package prog.unidad05.ejemplojson;

import prog.unidad05.ejemplojson.procesador.ProcesadorEstudiantes;
import prog.unidad05.ejemplojson.procesador.ProcesadorEstudiantesException;

public class ProcesaJsonApp {

  public static void main(String[] args) {
    ProcesadorEstudiantes procesador = new ProcesadorEstudiantes("doc/estudiantes.json");
    Estudiantes estudiantes = procesador.procesaFichero();
    int i = 1;
  }

}

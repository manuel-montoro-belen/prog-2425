package prog.unidad05.ejemplojson.procesador;

@SuppressWarnings("serial")
public class ProcesadorEstudiantesException extends RuntimeException {

  public ProcesadorEstudiantesException() {
  }

  public ProcesadorEstudiantesException(String message) {
    super(message);
  }

  public ProcesadorEstudiantesException(Throwable cause) {
    super(cause);
  }

  public ProcesadorEstudiantesException(String message, Throwable cause) {
    super(message, cause);
  }

}

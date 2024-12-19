package prog.unidad04.practica406.libreria;

/**
 * Clase que representa a un vehículo
 */
public class Vehiculo {

  protected String matricula;
  protected Fecha fechaMatriculacion;
  protected static int vehiculosMatriculados = 0;
  
  protected Vehiculo(String matricula, Fecha fechaMatriculacion) {
    if (esMatriculaValida(matricula)) {
      if (fechaMatriculacion != null) {
        this.matricula = matricula;
        this.fechaMatriculacion = fechaMatriculacion;
        vehiculosMatriculados++;
      } else {
        throw new NullPointerException("La fecha es null");
      }
    } else {
      throw new IllegalArgumentException("La matricula no es válida");
    }
  }
  
  public String getMatricula() {
    return matricula;
  }
  
  public Fecha getFechaMatriculacion() {
    return fechaMatriculacion;
  }
  
  public static int getVehiculosMatriculados() {
    return vehiculosMatriculados;
  }
  
  public String toString() {
    return String.format("Matricula: %s, Fecha Matriculación: %s", matricula, fechaMatriculacion.toString());
  }

  private boolean esMatriculaValida(String matricula) {
    // Si la matricula tiene la longitud mínima (4 números, 0 espacios y 3 letras)
    if (matricula.length() >= 7) {
      // Los primeros 4 caracteres deben ser numeros
      String supuestosNumeros = matricula.substring(0, 4);
      // Los ultimos 3 debe ser letras
      String supuestasLetras = matricula.substring(matricula.length() - 3);
      // Y por ultimo sacamos los espacios
        String supuestosEspacios = matricula.substring(4, matricula.length() - 3);
      return esNumeroValido(supuestosNumeros) && esLetrasValidas(supuestasLetras)
          && esEspaciosValidos(supuestosEspacios);
    } else {
      return false;
    }
  }

  private boolean esEspaciosValidos(String supuestosEspacios) {
    // Para cada caracter de los supuestos espacios
    for (int i = 0; i < supuestosEspacios.length(); i++) {
      // Obtengo el caracter
      char caracter = supuestosEspacios.charAt(i);
      // Si el caracter NO es un espacio
      if (caracter != ' ') {
        return false;
      }
    }
    // Si ningun caracter es malo, entonces son todos espacios
    return true;
  }

  private boolean esLetrasValidas(String supuestasLetras) {
    // Para cada caracter de las supuestas letras
    for (int i = 0; i < supuestasLetras.length(); i++) {
      // Obtengo el caracter
      char caracter = supuestasLetras.charAt(i);
      // Si el caracter NO corresponde con una letra MAYUSCULA
      if (caracter < 'A' || caracter > 'Z') {
        return false;
      }
    }
    // Si ningun caracter es malo, entonces las letras son buenas
    return true;
  }

  private boolean esNumeroValido(String supuestoNumero) {
    // Para cada caracter del supuesto número
    for (int i = 0; i < supuestoNumero.length(); i++) {
      // Obtengo el caracter
      char caracter = supuestoNumero.charAt(i);
      // Si el caracter NO corresponde con un digito
      if (caracter < '0' || caracter > '9') {
        return false;
      }
    }
    // Si ningun caracter es malo, entonces el numero es bueno
    return true;
  }
}

package prog.unidad04.actividad402.ejercicio08a;

/**
 * La clase IntervaloTiempo ...s..sd.sa.d....
 */
public class IntervaloTiempo {
  
  // Constantes
  // Cantidad de segundos por minuto
  private static final int SEGUNDOS_POR_MINUTO = 60;

  // Atributos
  // Cantidad de segundos
  private int segundos;
  
  /**
   * Constructor con tres parametros
   * @param horas Numero de horas del intervalo. No puede ser negativo
   * @param minutos Número de minutos del intervalo. No puede ser negativo. Si pasa de 59 se suman las horas.....
   * @param segundos
   */
  public IntervaloTiempo(int horas, int minutos, int segundos) {
    this.segundos = horas * 3600 + SEGUNDOS_POR_MINUTO * minutos + segundos;
  }

  /**
   * Comentario......
   * @param segundos
   */
  private IntervaloTiempo(int segundos) {
    this.segundos = segundos;
  }
  
  /**
   * Suma dos intervalos y devuelve
   * @param otro
   * @return
   */
  public IntervaloTiempo suma(IntervaloTiempo otro) {
    // Se calcula el total de segundos
    int resultado = this.segundos + otro.segundos;
    // Se devuelve el nuevo objeto
    return new IntervaloTiempo(resultado);
  }

  public IntervaloTiempo resta(IntervaloTiempo otro) {
    int resultado = this.segundos - otro.segundos;

    if (resultado < 0) {
      System.out.println("Error. El intervalo que se resta es mayor que el original");
      return null;
    } else {
      // Creamos el resultado
      return new IntervaloTiempo(resultado);
    }
  }
  
  public String obtenerCadena() {
    int segundosTemporal = segundos % 60;
    int minTemporal = segundos / 60;
    int minutos = minTemporal % 60;
    int horas = minTemporal / 60;
    
    return horas + "h " + minutos + "m " + segundosTemporal + "s";
  }

}

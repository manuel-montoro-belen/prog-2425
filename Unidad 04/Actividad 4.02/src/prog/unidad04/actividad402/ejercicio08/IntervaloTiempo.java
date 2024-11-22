package prog.unidad04.actividad402.ejercicio08;

public class IntervaloTiempo {
  
  // Constantes
  // Cantidad de segundos por minuto
  private static final int SEGUNDOS_POR_MINUTO = 60;

  // Atributos
  // Horas
  private int horas;
  // Minutos
  private int minutos;
  // Segundos
  private int segundos;
  
  public IntervaloTiempo(int horas, int minutos, int segundos) {
    
    // Ajustamos los segundos
    while (segundos > 59) {
      segundos -= 60;
      minutos++;
    }
    
    // Ajustamos los minutos por el metodo Manolo
    horas += minutos / 60;
    minutos = minutos % 60;
    
    this.horas = horas;
    this.minutos = minutos;
    this.segundos = segundos;
  }
  
  public IntervaloTiempo suma(IntervaloTiempo otro) {
    // Sumamos los segundos
    int segundosTemporales = segundos + otro.segundos;
    // Ajustamos los segundos
    int segundosReales = segundosTemporales % SEGUNDOS_POR_MINUTO;
    // Calculamos los minutos extra
    int minutosExtra = segundosTemporales / SEGUNDOS_POR_MINUTO;
    
    // Hacemos lo mismo con los minutos
    int minutosTemporales = minutos + otro.minutos + minutosExtra;
    int minutosReales = minutosTemporales % SEGUNDOS_POR_MINUTO;
    int horasExtra = minutosTemporales / SEGUNDOS_POR_MINUTO;
    
    // Por ultimo calculamos las horas
    int horasReales = horas + otro.horas + horasExtra;
    
    // Creamos el resultado
    return new IntervaloTiempo(horasReales, minutosReales, segundosReales);
  }

  public IntervaloTiempo resta(IntervaloTiempo otro) {
    // Restamos los segundos
    int segundosTemporales = segundos - otro.segundos;
    // Ajustamos los segundos
    int segundosReales = 0;
    int minutosExtra = 0;
    if (segundosTemporales < 0) {
      segundosReales = 60 + segundosTemporales;
      minutosExtra = 1;
    } else {
      segundosReales = segundosTemporales;
    }

    // Hacemos lo mismo con los minutos
    int minutosTemporales = minutos - otro.minutos - minutosExtra;
    
    int minutosReales = 0;
    int horasExtra = 0;
    if (minutosTemporales < 0) {
      minutosReales = 60 + minutosTemporales;
      horasExtra = 1;
    } else {
      minutosReales = minutosTemporales;
    }
    
    // Por ultimo calculamos las horas
    int horasReales = horas - otro.horas - horasExtra;
    
    if (horasReales < 0) {
      System.out.println("Error. El intervalo que se resta es mayor que el original");
      return null;
    } else {
      // Creamos el resultado
      return new IntervaloTiempo(horasReales, minutosReales, segundosReales);
    }
  }
  
  public String obtenerCadena() {
    return horas + "h " + minutos + "m " + segundos + "s";
  }

}

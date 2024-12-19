package prog.unidad04.practica406.libreria;

/**
 * Clase que representa una fecha a partir del 1/1/1900
 */
public class Fecha {

  // Constantes
  private static final int ANYO_INICIO = 1900;
  
  // Atributos
  // Dia
  private int dia;
  // Mes
  private int mes;
  // Año
  private int anyo;
  
  public Fecha(int dia, int mes, int anyo) {
    // Comprobamos el año
    if (anyo >= ANYO_INICIO) {
      // Comprobamos el mes
      if (mes >= 1 && mes <= 12) {
        // Comprobamos el dia
        if (dia >= 1 && dia <= diasMes(mes, anyo)) {
          // Guardamos los valores
          this.dia = dia;
          this.mes = mes;
          this.anyo = anyo;
        } else {
          throw new IllegalArgumentException("El dia no es correcto");
        }
      } else {
        throw new IllegalArgumentException("El mes no es correcto");
      }
    } else {
      throw new IllegalArgumentException("El año no es correcto");
    }
  }

  
  /**
   * @return the dia
   */
  public int getDia() {
    return dia;
  }


  /**
   * @return the mes
   */
  public int getMes() {
    return mes;
  }

  /**
   * @return the anyo
   */
  public int getAnyo() {
    return anyo;
  }

  public boolean esBisiesto() {
    return esBisiesto(anyo);
  }
  
  public String toString() {
    return String.format("%d de %s de %d", dia, mesEnLetra(mes), anyo);
  }
  
  public long diasTranscurridos() {
    
    // Acumulador de dias
    long dias = 0;
    
    // Para cada año transcurrido
    for (int i = 1900; i < anyo; i++) {
      dias += 365;
      if (esBisiesto(i)) {
        dias++;
      }
    }
    
    // Para cada mes PASADO
    for (int i = 1; i < mes; i++) {
      dias += diasMes(i, anyo);
    }
    
    dias += (dia - 1);
    
    return dias;
  }
  
  public long diasEntre(Fecha fecha) {
    long diasTranscurridosEstaFecha = diasTranscurridos();
    long diasTranscurridosOtraFecha = fecha.diasTranscurridos();
    if (diasTranscurridosEstaFecha <= diasTranscurridosOtraFecha) {
      return diasTranscurridosOtraFecha - diasTranscurridosEstaFecha;
    } else {
      throw new FechaException("La fecha proporcionada no es posterior");
    }
  }
  
  public int compara(Fecha fecha) {
    long diasTranscurridosEstaFecha = diasTranscurridos();
    long diasTranscurridosOtraFecha = fecha.diasTranscurridos();
    return (int)(diasTranscurridosEstaFecha - diasTranscurridosOtraFecha);
  }
  
  private String mesEnLetra(int mes) {
    switch (mes) {
      case 1:
        return "enero";
      case 2:
        return "febrero";
      case 3:
        return "marzo";
      case 4:
        return "abril";
      case 5:
        return "mayo";
      case 6:
        return "junio";
      case 7:
        return "julio";
      case 8:
        return "agosto";
      case 9:
        return "septiembre";
      case 10:
        return "octubre";
      case 11:
        return "noviembre";
      case 12:
        return "diciembre";
      default:
        throw new IllegalArgumentException("El mes no es correcto");
    }
  }

  private int diasMes(int mes, int anyo) {
    switch (mes) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        return 31;
      case 4:
      case 6:
      case 9:
      case 11:
        return 30;
      case 2:
        return esBisiesto(anyo) ? 29 : 28;
      default:
        throw new IllegalArgumentException("Mes incorrecto");
    }
  }

  private boolean esBisiesto(int anyo) {
    return (anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 100 == 0 && anyo % 400 == 0);
  }
}

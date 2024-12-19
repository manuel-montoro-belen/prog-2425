package prog.unidad04.practica406.libreria;

public class Automovil extends Vehiculo implements MaquinaConDistintivoAmbiental {
  
  // Constantes publicas
  public static final String COLOR_BLANCO = "blanco";
  public static final String COLOR_NEGRO = "negro";
  public static final String COLOR_AZUL = "azul";
  
  // Atributos
  protected String color;
  protected int plazas;

  public Automovil(String matricula, Fecha fechaMatriculacion, String color, int plazas) {
    super(matricula, fechaMatriculacion);
    if (esColorValido(color) && esPlazasValidas(plazas)) {
      this.color = color;
      this.plazas = plazas;
    } else {
      vehiculosMatriculados--;
      throw new IllegalArgumentException("Alguno de los parámetros no es válido");
    }
  }

  /**
   * @return the color
   */
  public String getColor() {
    return color;
  }

  /**
   * @return the plazas
   */
  public int getPlazas() {
    return plazas;
  }
  
  public String toString() {
    return String.format("%s, Color: %s, Num. Plazas: %d", super.toString(), color, plazas);
  }

  private boolean esPlazasValidas(int plazas) {
    return plazas > 0;
  }

  private boolean esColorValido(String color) {
    return color.equals(COLOR_BLANCO) || color.equals(COLOR_NEGRO) || color.equals(COLOR_AZUL);
  }

  @Override
  public String getDistintivo() {
    if (plazas == 1) {
      return "0";
    } else if (plazas >= 2 && plazas <= 3) {
      return "ECO";
    } else if (plazas >= 4 && plazas <= 5) {
      return "A";
    } else {
      return "B";
    }
  }

}

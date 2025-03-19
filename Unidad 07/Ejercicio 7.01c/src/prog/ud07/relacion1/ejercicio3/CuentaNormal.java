package prog.ud07.relacion1.ejercicio3;

public class CuentaNormal extends Cuenta {
  
  // Constantes
  private static final double PENALIZACION = 10;
  private static final double SALDO_MINIMO = 500;
  
  
  // Atributo
  private boolean penaliza;

  public CuentaNormal(String nombre, String dni) {
    super(nombre, dni);
    penaliza = false;
  }

  @Override
  public double getInteres() {
    return 0;
  }

  @Override
  public double getPenalizacion() {
    
    return penaliza ? PENALIZACION : 0;
  }

  @Override
  public void retira(double cantidad) {
    super.retira(cantidad);
    if (saldo < SALDO_MINIMO)  {
      penaliza = true;
    }
  }

  @Override
  public void actualiza() {
    super.actualiza();
    penaliza = (saldo < SALDO_MINIMO);
  }

}

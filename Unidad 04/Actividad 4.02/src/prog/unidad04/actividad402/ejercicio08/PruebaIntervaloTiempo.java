package prog.unidad04.actividad402.ejercicio08;

import prog.unidad04.actividad402.ejercicio08a.IntervaloTiempo;

public class PruebaIntervaloTiempo {

  public static void main(String[] args) {
    PruebaIntervaloTiempo prueba = new PruebaIntervaloTiempo();
    prueba.run();
    
  }
  
  private void imprimeIntervalo(IntervaloTiempo intervalo) {
    System.out.println(intervalo.obtenerCadena());
  }
  
  private void run() {
    IntervaloTiempo intervalo = new IntervaloTiempo(2, 30, 40);
    IntervaloTiempo intervalo2 = new IntervaloTiempo(1, 20, 30);
    IntervaloTiempo salida = intervalo.resta(intervalo2);
    
    imprimeIntervalo(intervalo);
    imprimeIntervalo(intervalo2);
    imprimeIntervalo(salida);
  }

}

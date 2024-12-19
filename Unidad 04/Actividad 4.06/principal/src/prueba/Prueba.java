package prueba;

import prog.unidad04.practica406.libreria.Automovil;
import prog.unidad04.practica406.libreria.Fecha;
import prog.unidad04.practica406.libreria.Vehiculo;

public class Prueba {

  public static void main(String[] args) {
    Automovil auto = new Automovil("0000AAA", new Fecha(19,12,2024), Automovil.COLOR_BLANCO, 5);
    System.out.printf("Vehiculos creados: %d%n", Vehiculo.getVehiculosMatriculados());
    
    Automovil auto2 = null;
    try {
      auto2 = new Automovil("0000AAA", new Fecha(19, 12, 2024), "cachumbo", 8);
    } catch (Exception e) {
      System.out.println("Se ha intentado crear un auto chungo");
    }
    System.out.printf("Vehiculos creados: %d%n", Vehiculo.getVehiculosMatriculados());
    
    
  }

}

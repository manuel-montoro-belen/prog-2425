package prog.unidad07.ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class EmpleadosMain {

  public static void main(String[] args) {
    
    List<Empleado> empleados = new ArrayList<>();
    
    empleados.add(new EmpleadoFijo("Paco", "11111111A", "666666666", 2500));
    empleados.add(new Consultor("Paco", "11111111A", "666666666", 25, 150));
    empleados.add(new Comercial("Paco", "11111111A", "666666666", 10001));
    empleados.add(new Comisionista("Paco", "11111111A", "666666666", 2000, 0.15, 10000));
    
    double nomina = CalculadorNomina.calculaNominaCompleta(empleados);
    
    System.out.printf("La nómina total es: %.2f euros%n", nomina);
  }

}

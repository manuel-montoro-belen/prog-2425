package prog.unidad04.practica406.principal;

import java.time.LocalDate;
import java.util.Scanner;
import prog.unidad04.practica406.libreria.Automovil;
import prog.unidad04.practica406.libreria.Fecha;
import prog.unidad04.practica406.libreria.Motocicleta;
import prog.unidad04.practica406.libreria.Vehiculo;

/**
 * Clase principal de la aplicación
 */
public class VehiculosApp {
  
  // Atributo
  // Scanner para leer desde teclado
  Scanner sc;
  
  private VehiculosApp() {
    this.sc = new Scanner(System.in);
  }

  /**
   * Punto de entrada a la aplicación
   * @param args
   */
  public static void main(String[] args) {
    
    // Creamos un objeto de esta clase
    // Al construirse inicializará el Scanner
    VehiculosApp app = new VehiculosApp();
    // Delegamos la ejecución al objeto
    app.run();
  }

  /**
   * Inicio del interfaz de usuario del programa
   */
  private void run() {
    // Cabecera
    System.out.println("PRÁCTICA DE Manuel Montoro. GESTIÓN DE VEHÍCULOS");
    
    // Solicita los datos del automóvil
    Automovil automovil = solicitaAutomovil();

    // Solicita los datos del motocicleta
    Motocicleta motocicleta = solicitaMotocicleta();
    
    // Cuando llegamos aqui tanto automovil como motocicleta son válidos
    
    // Imprimimos sus datos
    System.out.println("Los datos del automovil son:");
    System.out.println(automovil);
    System.out.printf("Su distintivo ambiental es %s%n", automovil.getDistintivo());
    System.out.println("Los datos de la motocicleta son:");
    System.out.println(motocicleta);
    System.out.printf("Su distintivo ambiental es %s%n", motocicleta.getDistintivo());
    
    // Imprime si alguno se matriculo en año bisiesto o no
    if (automovil.getFechaMatriculacion().esBisiesto()) {
      System.out.println("El automóvil se matriculó en año bisiesto");
    }
    if (motocicleta.getFechaMatriculacion().esBisiesto()) {
      System.out.println("La motocicleta se matriculó en año bisiesto");
    }
    
    // Obtenemos la fecha actual
    Fecha hoy = obtenerFechaActual();
    
    // Imprimimos cuantos dias lleva matriculado el automovil y la motocicleta
    System.out.printf("El automóvil lleva matriculado %d días%n", automovil.getFechaMatriculacion().diasEntre(hoy));
    System.out.printf("La motocicleta lleva matriculada %d dias%n", motocicleta.getFechaMatriculacion().diasEntre(hoy));
    
    // Si el automóvil se matriculó antes
    if (automovil.getFechaMatriculacion().compara(motocicleta.getFechaMatriculacion()) < 0) {
      System.out.println("El automóvil se matriculó antes que la motocicleta");
    } else if (automovil.getFechaMatriculacion().compara(motocicleta.getFechaMatriculacion()) > 0) {
      System.out.println("La motocicleta se matriculó antes que el automóvil");
    } else {
      System.out.println("Ambos vehículos se matricularon en el mismo día");
    }
    
    // Por último mostramos el número de vehículos matriculados (debería ser 2)
    System.out.printf("Número de vehículos matriculados: %d%n", Vehiculo.getVehiculosMatriculados());
  }

  /**
   * Obtiene los datos de un automóvil y lo crea, reintentando las veces que sea preciso hasta
   * que el usuario introduce datos correctos
   * @return Automovil con los datos recopilados desde el usuario
   */
  private Automovil solicitaAutomovil() {
    for(;;) {
      // Solicitamos la matrícula
      System.out.print("Introduce la matrícula del automóvil (4 números, 0 ó más espacios y tres letras mayúsculas): ");
      String matricula = sc.nextLine();

      // Solicitamos la fecha de matriculacion
      Fecha fechaMatriculacion = solicitaFecha();
      
      // Solicitamos el color
      System.out.printf("Introduzca el color del automóvil (%s, %s o %s):", Automovil.COLOR_BLANCO
          , Automovil.COLOR_NEGRO, Automovil.COLOR_AZUL);
      String color = sc.nextLine();
      
      // Y el número de plazas
      int plazas = solicitaEntero("Introduzca el número de plazas del vehículo (1 ó mas): ");
      
      // Intenta crear y devolver el automóvil
      try {
        return new Automovil(matricula, fechaMatriculacion, color, plazas);
      } catch (Exception e) {
        // Mostramos un mensaje y se vuelve a intentar
        System.out.println("No se pudo crear el automóvil. Revise los datos para comprobar que todos son correctos");
      }
    }
  }

  /**
   * Obtiene los datos de una motocicleta desde el usuario, reintentando hasta que se introducen
   * datos correctos.
   * @return Motocicleta con los datos aportados por el usuario
   */
  private Motocicleta solicitaMotocicleta() {
    for(;;) {
      // Solicitamos la matrícula
      System.out.print("Introduce la matrícula de la motocicleta (4 números, 0 ó más espacios y tres letras mayúsculas): ");
      String matricula = sc.nextLine();

      // Solicitamos la fecha de matriculacion
      Fecha fechaMatriculacion = solicitaFecha();
      
      // Solicitamos la cilindrada
      int cilindrada = solicitaEntero("Introduzca la cilindrada de la motocicleta (50 ó mas): ");
      
      // Intenta crear y devolver la motocicleta. Si no se puede volvemos a empezar
      try {
        return new Motocicleta(matricula, fechaMatriculacion,  cilindrada);
      } catch (IllegalArgumentException e) {
        // Mostramos un mensaje y se vuelve a intentar
        System.out.println("No se pudo crear la motocicleta. Revise los datos para comprobar que todos son correctos");
      }
    }
  }

  /**
   * Solicita una fecha desde teclado
   * @return Fecha leida o null si los datos leidos no se corresponde con una fecha válida
   */
  private Fecha solicitaFecha() {
    int dia = solicitaEntero("Introduzca el día de la fecha de matriculación de la motocicleta: ");
    int mes = solicitaEntero("Introduzca el mes de la fecha de matriculación de la motocicleta: ");
    int anyo = solicitaEntero("Introduzca el año de la fecha de matriculación de la motocicleta: ");
    // Intenta crear y devolver la fecha
    try {
      return new Fecha(dia, mes, anyo);
      
    } catch (IllegalArgumentException e) {
      // Si no podemos crear la fecha
      // Mostramos un mensaje
      System.out.println("La fecha no es una fecha válida. Revise los valores e inténtelo de nuevo");
      // Y devolvemos null
      return null;
    }
  }

  /**
   * Solicita un entero desde teclado, asegurando que se introduce un valor
   *   entero correcto. Repite la solicitud hasta que se introduce un valor correcto
   * @param prompt Mensaje a mostrar al usuario para solicitar el dato
   * @return Entero leido desde el teclado
   */
  private int solicitaEntero(String prompt) {
    // Bucle infinito (salimos mediante el return)
    for (;;) {
      try {
        // Mostramos el prompt
        System.out.print(prompt);
        // Solicitamos el dato
        int numero = Integer.parseInt(sc.nextLine());
        // Y lo devolvemos (si se llega aqui, es un entero)
        return numero;
      } catch (NumberFormatException e) {
        System.out.println("Lo introducido no es un número entero correcto. Inténtelo de nuevo");
      }
    }
  }

  /**
   * Obtiene un objeto Fecha con la fecha actual
   * @return Objeto Fecha con la fecha actual
   */
  private Fecha obtenerFechaActual() {
    // Creamos un objeto LocalDate con la fecha actual
    LocalDate fechaActual = LocalDate.now();
    // Creamos un objeto Fecha empleando dia, mes y año que nos proporciona el objeto LocalDate
    // Y lo devolvemos
    return new Fecha(fechaActual.getDayOfMonth(), fechaActual.getMonthValue(), fechaActual.getYear());
  }

}

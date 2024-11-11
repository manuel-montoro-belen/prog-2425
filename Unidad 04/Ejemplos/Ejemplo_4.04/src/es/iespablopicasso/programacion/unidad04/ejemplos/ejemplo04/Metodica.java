package es.iespablopicasso.programacion.unidad04.ejemplos.ejemplo04;

/**
 * La clase Metodica tiene muchos métodos para probar su funcionamiento
 */
public class Metodica {

  public String nombre;
  public static int edad;
  
  public void mensaje1() {
    System.out.println("---------------------");
    System.out.println("Entrando en mensaje1");
    System.out.println("Atributo de instancia nombre = " + nombre);
    System.out.println("Atributo de clase edad = " + edad);
    System.out.println("Invocando  mensaje2");
    mensaje2();
    System.out.println("Después de mensaje2");
    System.out.println("Saliendo de mensaje1");
  }

  public void mensaje2() {
    System.out.println("---------------------");
    System.out.println("Entrando en mensaje2");
    System.out.println("Atributo de instancia nombre = " + nombre);
    System.out.println("Atributo de clase edad = " + edad);
    System.out.println("Invocando  mensaje3");
    mensaje3();
    System.out.println("Después de mensaje3");
    System.out.println("Saliendo de mensaje2");
  }

  public void mensaje3() {
    System.out.println("---------------------");
    System.out.println("Entrando en mensaje3");
    System.out.println("Atributo de instancia nombre = " + nombre);
    System.out.println("Atributo de clase edad = " + edad);
    System.out.println("Saliendo de mensaje3");
  }
  
  public static void mensaje1Estatico() {
    System.out.println("---------------------");
    System.out.println("Entrando en mensaje1Estatico");
    // No se puede imprimir el atributo de instancia
    //System.out.println("Atributo de instancia nombre = " + nombre);
    System.out.println("Atributo de clase edad = " + edad);
    // No se puede hacer porque mensaje2 es de instancia y estamos en un método estático
    //System.out.println("Invocando  mensaje2");
    //mensaje2();
    //System.out.println("Después de mensaje2");
    // Pero si podemos enviar un mensaje estatico
    System.out.println("Invocando  mensaje2Estatico");
    mensaje2Estatico();
    System.out.println("Después de mensaje2Estatico");
    
    System.out.println("Saliendo de mensaje1Estatico");
  }

  public static void mensaje2Estatico() {
    System.out.println("---------------------");
    System.out.println("Entrando en mensaje1");
    // No se puede imprimir el atributo de instancia
    //System.out.println("Atributo de instancia nombre = " + nombre);
    System.out.println("Atributo de clase edad = " + edad);
    // No se puede hacer porque mensaje3 es de instancia y estamos en un método estático
    //System.out.println("Invocando  mensaje3");
    //mensaje3();
    //System.out.println("Después de mensaje3");
    // Pero si podemos hacerlo creando un objeto de la clase
    Metodica nuevaMetodica = new Metodica();
    System.out.println("Invocando  mensaje3");
    nuevaMetodica.mensaje3();
    System.out.println("Después de mensaje3");
    
    System.out.println("Saliendo de mensaje1Estatico");
  }
}

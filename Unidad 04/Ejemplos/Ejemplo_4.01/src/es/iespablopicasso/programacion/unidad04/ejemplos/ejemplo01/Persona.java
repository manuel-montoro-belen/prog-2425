package es.iespablopicasso.programacion.unidad04.ejemplos.ejemplo01;

/**
 * Clase que representa a una Persona.
 * Una persona es alguien que participa en el sistema, ya sea como empleado o como cliente
 */
public class Persona {

  public int entero;
  public static double real;
  private char caracter;
  private static boolean booleano;
  long largo;
  static float flotante;

  public static void main(String[] args) {
    // Creamos una persona
    // Si, desde una clase podemos crear un objeto de esa misma clase. Que cosas, ¿eh?
    Persona persona = new Persona();
    
    // Podemos acceder a los atributos publicos
    // Debemos usar obligatoriamente objeto.atributo
    System.out.println(persona.entero);
    // No podemos usarlo sin objeto
    //System.out.println(entero);
    
    // A los atributos estáticos podemos acceder con o sin usar la clase
    System.out.println(Persona.real);
    System.out.println(real);
    
    // También a los privados, que para eso son nuestros
    System.out.println(persona.caracter);
    System.out.println(Persona.booleano);
    System.out.println(booleano);
    
    // Y a los de visibilidad de paquete
    System.out.println(persona.largo);
    System.out.println(Persona.flotante);
    System.out.println(flotante);
  }
}

package es.iespablopicasso.programacion.unidad04.ejemplos.ejemplo01;

/**
 * La clase AmigoPersona es amiga de persona porque vive en la misma
 * vecindad (paquete)
 */
public class AmigoPersona {

  public static void main(String[] args) {
    
    // Creamos una persona
    Persona persona = new Persona();
    
    // Podemos acceder a los atributos publicos
    System.out.println(persona.entero);
    System.out.println(Persona.real);
    
    // Pero no a los privados, por eso estas lineas están comentadas
    //System.out.println(persona.caracter);
    //System.out.println(Persona.booleano);
    
    // En cambio los de visibilidad de paquete también se pueden ver
    System.out.println(persona.largo);
    System.out.println(Persona.flotante);
  }
}

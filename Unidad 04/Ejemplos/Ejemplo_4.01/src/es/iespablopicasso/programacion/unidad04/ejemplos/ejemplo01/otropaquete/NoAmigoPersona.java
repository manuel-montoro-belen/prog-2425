package es.iespablopicasso.programacion.unidad04.ejemplos.ejemplo01.otropaquete;

import es.iespablopicasso.programacion.unidad04.ejemplos.ejemplo01.Persona;

public class NoAmigoPersona {

  public static void main(String[] args) {

    // Creamos una persona
    Persona persona = new Persona();
    
    // Podemos acceder a los atributos publicos
    System.out.println(persona.entero);
    System.out.println(Persona.real);
    
    // Pero no a los privados, por eso estas lineas están comentadas
    //System.out.println(persona.caracter);
    //System.out.println(Persona.booleano);
    
    // Tampoco a los de visibilidad de paquete porque estamos en otro paquete
    //System.out.println(persona.largo);
    //System.out.println(Persona.flotante);
    
  }

}

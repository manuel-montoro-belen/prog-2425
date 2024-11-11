package es.iespablopicasso.programacion.unidad04.ejemplos.ejemplo03;

/**
 * Usa una Persona para demostrar acceso a los atributos
 */
public class UsaPersona {

  public static void main(String[] args) {
    
    // Creamos una persona
    Persona persona = new Persona();
    
    // Imprime los atributos
    persona.imprimeAtributos();
    
    // Demostramos shadowing
    persona.imprimeYCambia("Juan", 45, 98L);

    // Ahora con métodos estáticos
    Persona.imprimeYCambiaEstatica("Juan", 45, 98L);
  }

}

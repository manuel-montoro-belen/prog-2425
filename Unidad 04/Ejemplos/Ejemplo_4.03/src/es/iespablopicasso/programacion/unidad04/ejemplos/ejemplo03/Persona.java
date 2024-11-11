package es.iespablopicasso.programacion.unidad04.ejemplos.ejemplo03;

/**
 * Clase Persona para demostrar la visibilidad de los atributos y el shadowing
 */
public class Persona {
  
  // Nombre de la persona
  public String nombre;
  // Edad de la persona
  protected int edad;
  // Peso de la persona
  private double peso;
  // Atributo estático
  public static long numero;
  // Otro atributo estático
  private static String nombreSecreto;

  /**
   * Imprime los atributos de la persona
   */
  public void imprimeAtributos() {
    System.out.println("-----------------------------------------------");
    System.out.println("Entrando en imprimeAtributos");
    System.out.println("Imprimiendo atributos");
    System.out.println("Nombre = " + nombre);
    System.out.println("Edad = " + edad);
    System.out.println("Peso = " + peso);
    System.out.println("Numero = " + numero);
    System.out.println("Nombre Secreto = " + nombreSecreto);
    System.out.println("Saliendo de imprimeAtributos");
  }
  
  public void imprimeYCambia(String nombre, int edad, long numero) {
    System.out.println("-----------------------------------------------");
    System.out.println("Entrando en imprimeYCambia");
    // Si se imprimen nombre, edad y peso se muestran los parámetros
    // en los dos primeros porque "tapan" a los atributos
    // peso si muestra el atributo porque no hay otra variable
    // que lo tape
    System.out.println("Intentamos imprimir los atributos. No funciona porque los parámetros tapan a tres de ellos");
    System.out.println("Nombre = " + nombre);
    System.out.println("Edad = " + edad);
    System.out.println("Peso = " + peso);
    System.out.println("Numero = " + numero);
    System.out.println("Nombre Secreto = " + nombreSecreto);
    

    // Si queremos mostrar los atributos hay que usar this
    System.out.println("Ahora si mostramos los atributos usando this");
    System.out.println("Nombre = " + this.nombre);
    System.out.println("Edad = " + this.edad);
    System.out.println("Numero = " + Persona.numero);
    
    // Actualizamos los atributos
    // Nótese que en la parte izquierda hay que usar this
    // porque si no no se hace nada
    // Ya que se asignaría a los parámetros los mismos valores
    // que ya contienen
    System.out.println("Modificamos los atributos usando los parámetros");
    this.nombre = nombre;
    this.edad = edad;
    Persona.numero = numero;

    // Volvemos a imprimir los atributos
    // Los dos primeros siguen siendo los parametros
    // Pero no es evidente porque al haberlos asignado
    // Los atributos y los parámetros valen lo mismo
    System.out.println("Intentamos volver imprimir los atributos. No funciona porque los parámetros tapan a tres de ellos");
    System.out.println("Nombre = " + nombre);
    System.out.println("Edad = " + edad);
    System.out.println("Peso = " + peso);
    System.out.println("Numero = " + numero);
    System.out.println("Nombre Secreto = " + nombreSecreto);

    // Ahora SI que imprimimos los atributos
    System.out.println("Volvemos a mostrar los atributos usando this");
    System.out.println("Nombre = " + this.nombre);
    System.out.println("Edad = " + this.edad);
    System.out.println("Numero = " + Persona.numero);
    
    // Cambiamos los valores de los parámetros y volvemos a imprimir todo
    System.out.println("Modificamos los parámetros");
    nombre = "Pepe";
    edad = 32;
    numero = 176L;
    System.out.println("Imprimimos todo otra vez. Los tres primeros son los parámetros porque tapan a los atributos, que son los tres últimos");
    System.out.println("Nombre = " + nombre);
    System.out.println("Edad = " + edad);
    System.out.println("Peso = " + peso);
    System.out.println("Numero = " + numero);
    System.out.println("Nombre Secreto = " + nombreSecreto);
    System.out.println("Nombre = " + this.nombre);
    System.out.println("Edad = " + this.edad);
    System.out.println("Numero = " + Persona.numero);
    System.out.println("Saliendo de imprimeYCambia");
  }

  public static void imprimeYCambiaEstatica(String nombre, int edad, long numero) {
    System.out.println("-----------------------------------------------");
    System.out.println("Entrando en imprimeYCambiaEstatica");
    // Se pueden imprimir los parámetros pero no los atributos de instancia (peso)
    System.out.println("Intentamos imprimir los atributos. No funciona porque los parámetros tapan a tres de ellos");
    System.out.println("Nombre = " + nombre);
    System.out.println("Edad = " + edad);
    //System.out.println("Peso = " + peso);
    System.out.println("Numero = " + numero);
    System.out.println("Nombre Secreto = " + nombreSecreto);
    

    // Si queremos mostrar los atributos hay que usar this, pero no podemos porque son atributos de instancia
    System.out.println("Ahora si mostramos los atributos usando this");
    //System.out.println("Nombre = " + this.nombre);
    //System.out.println("Edad = " + this.edad);
    // Este es estático y si puede
    System.out.println("Numero = " + Persona.numero);
    
    // Actualizamos los atributos
    // No se pueden actualizar los atributos de instancia porque no tenemos instancia
    System.out.println("Modificamos los atributos usando los parámetros");
    //this.nombre = nombre;
    //this.edad = edad;
    // Pero si el atributo estático
    Persona.numero = numero;

    // Volvemos a imprimir los atributos
    // Los dos primeros siguen siendo los parametros
    // Pero no es evidente porque al haberlos asignado
    // Los atributos y los parámetros valen lo mismo
    System.out.println("Intentamos volver imprimir los atributos. No funciona porque los parámetros tapan a tres de ellos");
    System.out.println("Nombre = " + nombre);
    System.out.println("Edad = " + edad);
    // Este atributo de instancia no se puede acceder desde un método estático
    //System.out.println("Peso = " + peso);
    System.out.println("Numero = " + numero);
    System.out.println("Nombre Secreto = " + nombreSecreto);

    // Ahora SI que imprimimos los atributos (pero sólo los estáticos)
    System.out.println("Volvemos a mostrar los atributos usando this");
    //System.out.println("Nombre = " + this.nombre);
    //System.out.println("Edad = " + this.edad);
    System.out.println("Numero = " + Persona.numero);
    
    // Cambiamos los valores de los parámetros y volvemos a imprimir todo
    System.out.println("Modificamos los parámetros");
    nombre = "Pepe";
    edad = 32;
    numero = 176L;
    System.out.println("Imprimimos todo otra vez. Los tres primeros son los parámetros porque tapan a los atributos, que son los tres últimos");
    System.out.println("Nombre = " + nombre);
    System.out.println("Edad = " + edad);
    // Este no se puede acceder porque es de instancia
    //System.out.println("Peso = " + peso);
    System.out.println("Numero = " + numero);
    System.out.println("Nombre Secreto = " + nombreSecreto);
    // Ni estos dos
    //System.out.println("Nombre = " + this.nombre);
    //System.out.println("Edad = " + this.edad);
    System.out.println("Numero = " + Persona.numero);
    System.out.println("Saliendo de imprimeYCambiaEstatica");
  }
}

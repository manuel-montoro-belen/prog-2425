package es.iespablopicasso.programacion.unidad04.ejemplos.ejemplo02;

/**
 * Clase para probar el envio de mensajes a Receptor
 */
public class Emisor {

  public static void main(String[] args) {
    
    // Creamos el receptor
    Receptor receptor = new Receptor();
    
    // Metodo sin parámetros
    receptor.metodoSinParametros();
    
    // Metodo con un parámetro. Pasamos un literal
    receptor.metodoConUnParametroEntero(0);
    
    // Metodo con un parámetro. Pasamos una variable
    int parametroQueVoyAPasar = 25;
    receptor.metodoConUnParametroEntero(parametroQueVoyAPasar);
    
    // Metodo con un parámetro. Hacemos una expresión para calcular el valor del parámetro
    receptor.metodoConUnParametroEntero(parametroQueVoyAPasar * 2 + parametroQueVoyAPasar / 3 % parametroQueVoyAPasar);
    
    // Metodo con dos parámetros
    parametroQueVoyAPasar = 127;
    // Primero variable y segundo literal
    receptor.metodoConDosParametrosEnteroYString(parametroQueVoyAPasar, "Supercadena");
    // Los dos literales
    receptor.metodoConDosParametrosEnteroYString(-100, "Cadena 100");
    // Literal y variable
    String cadena = "Cadena de favores";
    receptor.metodoConDosParametrosEnteroYString(-200, cadena);
    // Expresiones complejas
    receptor.metodoConDosParametrosEnteroYString(parametroQueVoyAPasar + 5 * parametroQueVoyAPasar, cadena + " menos algún que otro favor");

    // Ahora invertimos los parámetros
    parametroQueVoyAPasar = 721;
    // Primero literal y segundo variable
    receptor.metodoConDosParametrosStringYEntero("Cadenilla", parametroQueVoyAPasar);
    // Los dos literales
    receptor.metodoConDosParametrosStringYEntero("Cadena SER", -500);
    // Literal y variable
    cadena = "Palabras encadenadas";
    receptor.metodoConDosParametrosStringYEntero(cadena, -652);
    // Expresiones complejas
    receptor.metodoConDosParametrosStringYEntero("Unas cuantas " + cadena, parametroQueVoyAPasar * 7 + parametroQueVoyAPasar);
    
    // El siguiente método modifica los parámetros internamente, pero nosotros ni nos enteramos
    cadena = "Cadena Original";
    int entero = 1234;
    // Los imprimimos antes de entrar
    System.out.println("Antes de entrar cadena vale \"" + cadena + "\" y entero vale " + entero);
    receptor.metodoConDosParametrosQueSeIntentanModificar(cadena, entero);
    // Y al salir
    System.out.println("Después de salir cadena vale \"" + cadena + "\" y entero vale " + entero);
    
    // Ahora pasamos un objeto que se modifica dentro del método
    // Estos cambios si permanecen porque lo que se cambia no es el parámetro
    // Sino el objeto al que referencia el parámetro
    Persona persona = new Persona();
    persona.nombre = "Ambrosio";
    persona.edad = 35;
    // Antes de entrar
    System.out.println("Antes de entrar los atributos de persona valen: nombre = \"" + persona.nombre + "\" y edad = " + persona.edad);
    receptor.metodoQueModificaElContenidoDeUnObjeto(persona);
    // Después de salir
    System.out.println("Después de salir los atributos de persona valen: nombre = \"" + persona.nombre + "\" y edad = " + persona.edad);
    
  }

}

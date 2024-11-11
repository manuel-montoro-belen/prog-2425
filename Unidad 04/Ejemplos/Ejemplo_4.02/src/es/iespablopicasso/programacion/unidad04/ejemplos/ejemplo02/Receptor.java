package es.iespablopicasso.programacion.unidad04.ejemplos.ejemplo02;

/**
 * Clase de ejemplo para recibir mensajes en general
 * Por lo tanto la implementación interna no tiene mucho sentido
 * ya que no es una clase coherente "normal"
 * @author Manuel Montoro
 */
public class Receptor {
  
  public void metodoSinParametros() {
    System.out.println("metodoSinParametros");
  }

  
  public void metodoConUnParametroEntero(int parametroEntero) {
    System.out.println("metodoConUnParametroEntero");
    System.out.println("Primer parámetro: " + parametroEntero);
  }

  public void metodoConDosParametrosEnteroYString(int parametroEntero, String parametroCadena) {
    System.out.println("metodoConDosParametrosEnteroYString");
    System.out.println("Primer parámetro: " + parametroEntero);
    System.out.println("Segundo parámetro: " + parametroCadena);
  }

  public void metodoConDosParametrosStringYEntero(String p1, int superParametro) {
    System.out.println("metodoConDosParametrosStringYEntero");
    System.out.println("Primer parámetro: " + p1);
    System.out.println("Segundo parámetro: " + superParametro);
  }

  public void metodoConDosParametrosQueSeIntentanModificar(String cadenon, int enteroDelTodo) {
    System.out.println("metodoConDosParametrosQueSeIntentanModificar");
    System.out.println("Primer parámetro: " + cadenon);
    System.out.println("Segundo parámetro: " + enteroDelTodo);
    System.out.println("Ahora modificamos los parámetros y los volvemos a imprimir");
    cadenon = "Con la cabeza del Camarón";
    enteroDelTodo = 128;
    System.out.println("Primer parámetro: " + cadenon);
    System.out.println("Segundo parámetro: " + enteroDelTodo);
    System.out.println("Este cambio no afecta para nada al que llama");
  }
  
  public void metodoQueModificaElContenidoDeUnObjeto(Persona persona) {
    persona.nombre = "Agapito";
    persona.edad = 65;
  }

}

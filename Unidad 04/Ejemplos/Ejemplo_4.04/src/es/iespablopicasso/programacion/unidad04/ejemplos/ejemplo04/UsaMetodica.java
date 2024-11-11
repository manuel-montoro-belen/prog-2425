package es.iespablopicasso.programacion.unidad04.ejemplos.ejemplo04;

/**
 * Esta clase sirve para probar Metodica 
 */
public class UsaMetodica {

  public static void main(String[] args) {

    // Creamos el objeto
    Metodica metodica = new Metodica();
    
    // Le damos valores a los atributos
    metodica.nombre = "Metodica 1";
    Metodica.edad = 25;
    
    // Mandando mensaje mensaje1
    System.out.println("UsaMetodica: Mandando mensaje mensaje1");
    metodica.mensaje1();
    System.out.println("UsaMetodica: Después de envío mensaje mensaje1");

    // Mandando mensaje estatico
    System.out.println("UsaMetodica: Mandando mensaje mensaje1Estatico");
    Metodica.mensaje1Estatico();
    System.out.println("UsaMetodica: Después de envío mensaje mensaje1Estatico");

  }

}

package prog.unidad05.arraysobjetos;

public interface PredicadoLibro {
  
  /**
   * Comprueba si el libro cumple o no el predicado
   * @param libro Libro a comprobar
   * @return true si el libro cumple el predicado, false en caso contrario
   */
  boolean comprueba(Libro libro);

}

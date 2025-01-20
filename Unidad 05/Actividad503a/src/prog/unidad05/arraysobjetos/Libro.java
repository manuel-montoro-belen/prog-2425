package prog.unidad05.arraysobjetos;

/**
 * La clase Libro representa un libro de la biblioteca
 */
public class Libro {

  private String titulo;
  private String autor;
  private int anyoPublicacion;
  /**
   * @param titulo
   * @param autor
   * @param anyoPublicacion
   */
  Libro(String titulo, String autor, int anyoPublicacion) {
    this.titulo = titulo;
    this.autor = autor;
    this.anyoPublicacion = anyoPublicacion;
  }
  /**
   * @return the titulo
   */
  public String getTitulo() {
    return titulo;
  }
  /**
   * @return the autor
   */
  public String getAutor() {
    return autor;
  }
  /**
   * @return the anyoPublicacion
   */
  public int getAnyoPublicacion() {
    return anyoPublicacion;
  }
  @Override
  public String toString() {
    return String.format("Titulo: %s, Autor: %s, Año de Publicación: %d",titulo,  autor, anyoPublicacion);
  }
  
  
}

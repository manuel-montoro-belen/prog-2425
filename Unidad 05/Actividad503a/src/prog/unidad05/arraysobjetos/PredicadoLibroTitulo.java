package prog.unidad05.arraysobjetos;

public class PredicadoLibroTitulo implements PredicadoLibro {
  
  private String titulo;
  
  public PredicadoLibroTitulo(String titulo) {
    this.titulo = titulo;
  }

  @Override
  public boolean comprueba(Libro libro) {
    return libro.getTitulo().contains(titulo);
  }

}

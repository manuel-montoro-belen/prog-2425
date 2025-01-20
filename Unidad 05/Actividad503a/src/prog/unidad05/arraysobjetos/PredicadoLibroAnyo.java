package prog.unidad05.arraysobjetos;

public class PredicadoLibroAnyo implements PredicadoLibro {
  
  private int anyo;
  
  public PredicadoLibroAnyo (int anyo) {
    this.anyo = anyo;
  }

  @Override
  public boolean comprueba(Libro libro) {
    return libro.getAnyoPublicacion() == anyo;
  }

}

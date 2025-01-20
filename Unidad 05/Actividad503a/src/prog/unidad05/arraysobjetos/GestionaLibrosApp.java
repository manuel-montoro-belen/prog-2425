package prog.unidad05.arraysobjetos;

import java.util.Scanner;

public class GestionaLibrosApp {
  
  private static final int OPCION_SALIR = 0;
  private static final int OPCION_AGREGAR = 1;
  private static final int OPCION_MOSTRAR = 2;
  private static final int OPCION_BUSCAR_TITULO = 3;
  private static final int OPCION_BUSCAR_ANYO = 4;
  
  
  private Libro[] libros;
  Scanner sc;
  
  public GestionaLibrosApp() {
    libros = new Libro[0];
    sc = new Scanner(System.in);
  }

  public static void main(String[] args) {
    GestionaLibrosApp app = new GestionaLibrosApp();
    app.run();
  }

  public void run() {
    int opcion = -1;
    do {
      opcion = mostrarMenu();
      switch (opcion) {
        case OPCION_AGREGAR:
          agregarLibro();
          break;
        case OPCION_MOSTRAR:
          mostrarLibros();
          break;
        case OPCION_BUSCAR_TITULO:
          buscarPorTitulo();
          break;
        case OPCION_BUSCAR_ANYO:
          buscarPorAnyo();
          break;
        case OPCION_SALIR:
          break;
        default:
          System.err.println("Opción incorrecta.");
      }
    } while (opcion != OPCION_SALIR);
  }

  
  private void agregarLibro() {
    // Solicitar los datos del libro
    Libro nuevoLibro = solicitaLibro();
    // Añadir libro al array
    addLibro(nuevoLibro);
  }

  private Libro solicitaLibro() {
    imprimirTitulo("agregar libro");
    System.out.print("Introduzca el título del libro: ");
    String titulo = sc.nextLine();
    System.out.print("Introduzca el nombre del autor del libro: ");
    String autor = sc.nextLine();
    System.out.print("Introduzca el año de publicación del libro: ");
    int anyo = Integer.parseInt(sc.nextLine());
    return new Libro(titulo, autor, anyo);
  }

  private void addLibro(Libro nuevoLibro) {
    // Hacemos espacio para el nuevo libro
    ampliaArray();
    // Añadimos el libro al final
    libros[libros.length - 1] = nuevoLibro;
  }

  private void ampliaArray() {
    // Crea un nuevo array de tamaño superior
    Libro[] nuevoArray = new Libro[libros.length + 1];
    // Copia los elementos del array antiguo al nuevo
    for (int i = 0; i < libros.length; i++) {
      nuevoArray[i] = libros[i];
    }
    // Sustituimos el array antiguo por el nuevo
    libros = nuevoArray;
  }

  private void mostrarLibros() {
    imprimirTitulo("mostrar libros");
    for (Libro libro: libros) {
      System.out.println(libro);
    }
  }

  private void buscarPorTitulo() {
    // Imprimir cabecera
    imprimirTitulo("buscar libro por titulo");
    
    // Solicitar el titulo
    System.out.print("Introduzca el texto de búsqueda (no puede dejarse en blanco): ");
    String textoABuscar = sc.nextLine();
    if (!textoABuscar.isEmpty()) {
      // Listar los libros con el titulo dado
      filtraLibros(l -> l.getTitulo().contains(textoABuscar));
    } else {
      System.out.println("El texto de búsqueda no puede dejarse en blanco");
    }
    
  }
  
  private void filtraLibros(PredicadoLibro predicado) {
    int encontrados = 0;
    for (Libro libro: libros) {
      if (predicado.comprueba(libro)) {
        System.out.println(libro);
        encontrados++;
      }
    }
    System.out.printf("Se encontraron %d coincidencias%n", encontrados);
  }

  private void buscarPorAnyo() {
    // Imprimir cabecera
    imprimirTitulo("buscar libro por año");
    
    // Solicitar el año
    System.out.print("Introduzca el año de publicación a buscar: ");
    int anyoABuscar = Integer.parseInt(sc.nextLine());
    filtraLibros(new PredicadoLibroAnyo(anyoABuscar));
  }

  private int mostrarMenu() {
    imprimirTitulo("gestión de libros");
    System.out.println("(1) Agregar libro");
    System.out.println("(2) Mostrar todos los libros");
    System.out.println("(3) Buscar libro por título");
    System.out.println("(4) Buscar libro por Año");
    System.out.println("(0) Salir de la aplicación");
    System.out.print("Introduzca una opción (0-4): ");
    try {
      return Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException e) {
      return -1;
    }
  }
  
  private void imprimirTitulo(String titulo) {
    System.out.println();
    System.out.println(titulo.toUpperCase());
    for (int i = 0; i < titulo.length(); i++) {
      System.out.print("-");
    }
    System.out.println();
  }
}

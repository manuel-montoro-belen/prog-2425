package prog.unidad05.ejemplojson.procesador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import prog.unidad05.ejemplojson.Asignatura;
import prog.unidad05.ejemplojson.Estudiante;
import prog.unidad05.ejemplojson.Estudiantes;
import prog.unidad05.ejemplojson.Nombre;

public class ProcesadorEstudiantes {
  
  private String nombreFichero;
  
  public ProcesadorEstudiantes(String nombreFichero) {
    this.nombreFichero = nombreFichero;
  }

  public Estudiantes procesaFichero() {
    
    // Abre y procesa el fichero
    try {
      JsonElement raiz = JsonParser.parseReader(new FileReader(nombreFichero));
      if (raiz.isJsonObject()) {
        // Lo proceso
        JsonObject objetoRaiz = raiz.getAsJsonObject();
        JsonElement estudiantesJson = objetoRaiz.get("estudiantes");
        if (estudiantesJson != null) {
          // Procesa el array de estudiantes
          Estudiantes estudiantes = procesaEstudiantes(estudiantesJson);
          return estudiantes;
        } else {
          throw new ProcesadorEstudiantesException("No se encuentra el atributo \"estudiantes\"");
        }
      } else {
        throw new ProcesadorEstudiantesException("El elemento raiz no es un objeto");
      }
    } catch (Exception e) {
      throw new ProcesadorEstudiantesException("Error procesando el fichero");
    }
    
  }

  private Estudiantes procesaEstudiantes(JsonElement estudiantesJson) {
    // Si es un array
    if (estudiantesJson.isJsonArray()) {
      // Lo proceso
      // Lo adapto a un array
      JsonArray arrayEstudiantes = estudiantesJson.getAsJsonArray();
      // Creamos la salida
      Estudiantes estudiantes = new Estudiantes();
      // Para cada elemento
      for (JsonElement elemento: arrayEstudiantes)  {
        Estudiante estudiante = procesaEstudiante(elemento);
        estudiantes.addEstudiante(estudiante);
      }
      // Se devuelve 
      return estudiantes;
    } else {
      throw new ProcesadorEstudiantesException("El elemento estudiantes no es un array");
    }
  }

  
  private Estudiante procesaEstudiante(JsonElement elemento) {
    // Si es un objeto
    if (elemento.isJsonObject()) {
      // Se procesa
      JsonObject objeto = elemento.getAsJsonObject();
      String nombreTitulacion = procesaCadena(objeto, "nombreTitulacion");
      String email = procesaCadena(objeto, "email");
      boolean repite = procesaBooleano(objeto, "repite");
      JsonElement elementoNombre = objeto.get("nombreEstudiante");
      Nombre nombreEstudiante = procesaNombre(elementoNombre);
      JsonElement elementoAmigos = objeto.get("amigos");
      List<String> amigos = procesaAmigos(elementoAmigos);
      JsonElement elementoAsignaturas = objeto.get("asignaturas");
      Asignatura[] asignaturas = procesaAsignaturas(elementoAsignaturas);
      Estudiante estudiante = new Estudiante(nombreTitulacion, nombreEstudiante, email, repite,
          amigos, asignaturas);
      return estudiante;
    } else {
      throw new ProcesadorEstudiantesException("Se ha encontrado un elemento estudiante que no es un objeto");
    }
  }

  private Asignatura[] procesaAsignaturas(JsonElement elemento) {
    // Si es un array
    if (elemento.isJsonArray()) {
      // Lo proceso
      // Lo adapto a un array
      JsonArray arrayAsignaturas = elemento.getAsJsonArray();
      // Creamos la salida
      Asignatura[] salida = new Asignatura[arrayAsignaturas.size()];
      // Contador
      int i = 0;
      // Para cada elemento
      for (JsonElement elementoAsignatura: arrayAsignaturas)  {
        Asignatura asignatura = procesaAsignatura(elementoAsignatura);
        salida[i++] = asignatura;
      }
      // Se devuelve 
      return salida;
    } else {
      throw new ProcesadorEstudiantesException("El elemento asignaturas no es un array");
    }
  }

  private Asignatura procesaAsignatura(JsonElement elemento) {
    // Si es un objeto
    if (elemento.isJsonObject()) {
      // Se procesa
      JsonObject objeto = elemento.getAsJsonObject();
      String nombreAsignatura = procesaCadena(objeto, "nombreAsignatura");
      double nota = objeto.get("nota").getAsDouble();
      Asignatura asignatura = new Asignatura(nombreAsignatura, nota);
      return asignatura;
    } else {
      throw new ProcesadorEstudiantesException("Se ha encontrado un elemento estudiante que no es un objeto");
    }
  }

  private List<String> procesaAmigos(JsonElement elemento) {
    // Si es un array
    if (elemento.isJsonArray()) {
      // Lo proceso
      // Lo adapto a un array
      JsonArray arrayAmigos = elemento.getAsJsonArray();
      // Creamos la salida
      List<String> salida = new ArrayList<>();
      // Para cada elemento
      for (JsonElement amigo: arrayAmigos)  {
        salida.add(amigo.getAsString());
      }
      // Se devuelve 
      return salida;
    } else {
      throw new ProcesadorEstudiantesException("El elemento amigos no es un array");
    }
  }

  private Nombre procesaNombre(JsonElement elemento) {
    // Si es un objeto
    if (elemento.isJsonObject()) {
      // Se procesa
      JsonObject objeto = elemento.getAsJsonObject();
      String nombre = procesaCadena(objeto, "nombre");
      String apellido = procesaCadena(objeto, "apellido");
      Nombre nombreObjeto = new Nombre(nombre, apellido);
      return nombreObjeto;
    } else {
      throw new ProcesadorEstudiantesException("Se ha encontrado un elemento nombre que no es un objeto");
    }
  }

  private String procesaCadena(JsonObject objeto, String nombre) {
    // Accedemos al elemento
    JsonElement elemento = objeto.get(nombre);
    // Si no es null
    if (elemento != null) {
      return elemento.getAsString();
    } else {
      throw new ProcesadorEstudiantesException(String.format("El campo %s no es una cadena", nombre));
    }
  }

  private boolean procesaBooleano(JsonObject objeto, String nombre) {
    // Accedemos al elemento
    JsonElement elemento = objeto.get(nombre);
    // Si no es null
    if (elemento != null) {
      return elemento.getAsBoolean();
    } else {
      throw new ProcesadorEstudiantesException(String.format("El campo %s no es un booleano", nombre));
    }
  }
}

package prog.unidad04.practica406.libreria.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import prog.unidad04.practica406.libreria.Automovil;
import prog.unidad04.practica406.libreria.Fecha;
import prog.unidad04.practica406.libreria.MaquinaConDistintivoAmbiental;

/**
 * Pruebas unitarias de la clase automóvil
 */
class TestAutomovil {

  @Test
  void testAutomovilTodoCorrecto() {
    // Caso: Crea un automóvil con todos los datos válidos
    // Resultado esperado: El objeto se crea correctamente
    new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4);
  }

  @Test
  void testAutomovilMatriculaSinEspacios() {
    // Caso: Crea un automóvil con todos los datos válidos (la matricula no tiene espacios
    //       entre el número y las letras
    // Resultado esperado: El objeto se crea correctamente
    new Automovil("1111AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4);
  }

  @Test
  void testAutomovilMatriculaVariosEspacios() {
    // Caso: Crea un automóvil con todos los datos válidos (la matricula tiene 3 espacios
    //       entre el número y las letras
    // Resultado esperado: El objeto se crea correctamente
    new Automovil("1111   AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4);
  }

  @Test
  void testAutomovilMatriculaSobranNumeros() {
    // Caso: Crea un automóvil con todos los datos válidos, exceptuando la matricula
    // que tiene un número de mas 
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Automovil("11111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4));
  }

  @Test
  void testAutomovilMatriculaFaltanNumeros() {
    // Caso: Crea un automóvil con todos los datos válidos, exceptuando la matricula
    // que tiene un número de menos 
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Automovil("111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4));
  }

  @Test
  void testAutomovilMatriculaNumeroIncorrecto() {
    // Caso: Crea un automóvil con todos los datos válidos, exceptuando la matricula
    // que tiene una letra entre los números
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Automovil("1a11 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4));
  }

  @Test
  void testAutomovilMatriculaFaltanLetras() {
    // Caso: Crea un automóvil con todos los datos válidos, exceptuando la matricula
    // que tiene una letra de menos
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Automovil("1111 AA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4));
  }

  @Test
  void testAutomovilMatriculaSobranLetras() {
    // Caso: Crea un automóvil con todos los datos válidos, exceptuando la matricula
    // que tiene una letra de mas
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Automovil("1111 AAAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4));
  }

  @Test
  void testAutomovilMatriculaLetraNoValida() {
    // Caso: Crea un automóvil con todos los datos válidos, exceptuando la matricula
    // que tiene una letra minúscula
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Automovil("1111 AaA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4));
  }


  @Test
  void testAutomovilMatriculaLetraNoValida2() {
    // Caso: Crea un automóvil con todos los datos válidos, exceptuando la matricula
    // que tiene una letra inválida (no es una letra)
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Automovil("1111 A.A", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4));
  }
  @Test
  void testAutomovilaFechaNull() {
    // Caso: Crea un automóvil con todos los datos válidos, exceptuando la fecha
    //       que es null
    // Resultado esperado: El objeto NO se crea y lanza la excepción IllegalArgumentException
    assertThrows(NullPointerException.class, () -> new Automovil("1111 AAA", null, Automovil.COLOR_BLANCO, 4));
  }

  @Test
  void testAutomovilColorNull() {
    // Caso: Crea un automóvil con todos los datos válidos, exceptuando el color, que vale null
    // Resultado esperado: El objeto NO se crea y lanza la excepción IllegalArgumentException
    assertThrows(NullPointerException.class, () -> new Automovil("1111 AAA", new Fecha(1,10,2023), null, 4));
  }

  @Test
  void testAutomovilColorNoValido() {
    // Caso: Crea un automóvil con todos los datos válidos, exceptuando el color, que vale "verde"
    // Resultado esperado: El objeto NO se crea y lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Automovil("1111 AAA", new Fecha(1,10,2023), "verde", 4));
  }

  @Test
  void testAutomovilPlazasNoValidas() {
    // Caso: Crea un automóvil con todos los datos válidos, exceptuando las plazas que valen 0
    // Resultado esperado: El objeto NO se crea y lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 0));
  }

  @Test
  void testAutomovilGetMatriculaCorrecto() {
    // Caso: Crea un automóvil con todos los datos válidos. Al leer la matricula
    //  se debe obtener la misma con la que se creó
    // Resultado esperado: El objeto se crea correctamente y la matricula es la 
    //  que se empleó en la construcción
    Automovil automovil = new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4);
    assertEquals("1111 AAA", automovil.getMatricula());
  }

  @Test
  void testAutomovilGetFechaCorrecto() {
    // Caso: Crea un automóvil con todos los datos válidos. Al leer la fecha se debe
    //   obtener la misma con la que se creó
    // Resultado esperado: El objeto se crea correctamente y la fecha que se obtiene
    //   es la misma que se empleó en la construcción
    Automovil automovil = new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4);
    assertEquals(1, automovil.getFechaMatriculacion().getDia());
    assertEquals(10, automovil.getFechaMatriculacion().getMes());
    assertEquals(2023, automovil.getFechaMatriculacion().getAnyo());
  }

  @Test
  void testAutomovilGetColorCorrecto() {
    // Caso: Crea un automóvil con todos los datos válidos. Al leer el color se debe
    //   obtener el mismo con el que se creó
    // Resultado esperado: El objeto se crea correctamente y el color que se obtiene
    //   es el mismo que se empleó en la construcción
    Automovil automovil = new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4);
    assertEquals(Automovil.COLOR_BLANCO, automovil.getColor());
  }

  @Test
  void testAutomovilGetPlazasCorrecto() {
    // Caso: Crea un automóvil con todos los datos válidos. Al leer el número de plazas
    //   se debe obtener el mismo con el que se creó
    // Resultado esperado: El objeto se crea correctamente y el número de plazas debe
    //  ser el mismo que con el que se creó
    Automovil automovil = new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4);
    assertEquals(4, automovil.getPlazas());
  }

  @Test
  void testAutomovilDistintitivoCero() {
    // Caso: Crea un automovil con distintivo cero y lo obtiene
    // Resultado esperado: El distintivo obtenido es cero
    MaquinaConDistintivoAmbiental maquina = new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 1);
    assertEquals("0", maquina.getDistintivo());
  }

  @Test
  void testAutomovilDistintitivoEco1() {
    // Caso: Crea un automovil con distintivo ECO y lo obtiene
    // Resultado esperado: El distintivo obtenido es ECO
    MaquinaConDistintivoAmbiental maquina = new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 2);
    assertEquals("ECO", maquina.getDistintivo());
  }

  @Test
  void testAutomovilDistintitivoEco2() {
    // Caso: Crea un automovil con distintivo ECO y lo obtiene
    // Resultado esperado: El distintivo obtenido es ECO
    MaquinaConDistintivoAmbiental maquina = new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 3);
    assertEquals("ECO", maquina.getDistintivo());
  }

  @Test
  void testAutomovilDistintitivoA1() {
    // Caso: Crea un automovil con distintivo A y lo obtiene
    // Resultado esperado: El distintivo obtenido es A
    MaquinaConDistintivoAmbiental maquina = new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 4);
    assertEquals("A", maquina.getDistintivo());
  }

  @Test
  void testAutomovilDistintitivoA2() {
    // Caso: Crea un automovil con distintivo A y lo obtiene
    // Resultado esperado: El distintivo obtenido es A
    MaquinaConDistintivoAmbiental maquina = new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 5);
    assertEquals("A", maquina.getDistintivo());
  }

  @Test
  void testAutomovilDistintitivoB() {
    // Caso: Crea un automovil con distintivo B y lo obtiene
    // Resultado esperado: El distintivo obtenido es B
    MaquinaConDistintivoAmbiental maquina = new Automovil("1111 AAA", new Fecha(1,10,2023), Automovil.COLOR_BLANCO, 6);
    assertEquals("B", maquina.getDistintivo());
  }
}

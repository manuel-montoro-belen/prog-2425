package prog.unidad04.practica406.libreria.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import prog.unidad04.practica406.libreria.Automovil;
import prog.unidad04.practica406.libreria.Fecha;
import prog.unidad04.practica406.libreria.MaquinaConDistintivoAmbiental;
import prog.unidad04.practica406.libreria.Motocicleta;

/**
 * Clase que prueba la clase Motocicleta
 */
class TestMotocicleta {
  @Test
  void testMotocicletaTodoCorrecto() {
    // Caso: Crea una motocicleta con todos los datos válidos
    // Resultado esperado: El objeto se crea correctamente
    new Motocicleta("1111 AAA", new Fecha(1,10,2023), 750);
  }

  @Test
  void testMotocicletaMatriculaSinEspacios() {
    // Caso: Crea una motocicleta con todos los datos válidos (la matricula no tiene espacios
    //       entre el número y las letras
    // Resultado esperado: El objeto se crea correctamente
    new Motocicleta("1111AAA", new Fecha(1,10,2023), 750);
  }

  @Test
  void testMotocicletaMatriculaVariosEspacios() {
    // Caso: Crea una motocicleta con todos los datos válidos (la matricula tiene 3 espacios
    //       entre el número y las letras
    // Resultado esperado: El objeto se crea correctamente
    new Motocicleta("1111   AAA", new Fecha(1,10,2023), 750);
  }

  @Test
  void testMotocicletaMatriculaNull() {
    // Caso: Crea una motocicleta con todos los datos válidos (la matricula es null)
    // Resultado esperado: El objeto no se crea y lanza NullPointerException
    assertThrows(NullPointerException.class, () -> new Motocicleta(null, new Fecha(1,10,2023), 750));
  }

  @Test
  void testMotocicletaMatriculaSobranNumeros() {
    // Caso: Crea una motocicleta con todos los datos válidos, exceptuando la matricula
    // que tiene un número de mas 
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Motocicleta("11111 AAA", new Fecha(1,10,2023), 750));
  }

  @Test
  void testMotocicletaMatriculaFaltanNumeros() {
    // Caso: Crea una motocicleta con todos los datos válidos, exceptuando la matricula
    // que tiene un número de menos 
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Motocicleta("111 AAA", new Fecha(1,10,2023), 750));
  }

  @Test
  void testMotocicletaMatriculaNumeroIncorrecto() {
    // Caso: Crea una motocicleta con todos los datos válidos, exceptuando la matricula
    // que tiene una letra entre los números
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Motocicleta("1a11 AAA", new Fecha(1,10,2023), 750));
  }

  @Test
  void testMotocicletaMatriculaFaltanLetras() {
    // Caso: Crea una motocicleta con todos los datos válidos, exceptuando la matricula
    // que tiene una letra de menos
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Motocicleta("1111 AA", new Fecha(1,10,2023), 750));
  }

  @Test
  void testMotocicletaMatriculaSobranLetras() {
    // Caso: Crea una motocicleta con todos los datos válidos, exceptuando la matricula
    // que tiene una letra de mas
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Motocicleta("1111 AAAA", new Fecha(1,10,2023), 750));
  }

  @Test
  void testMotocicletaMatriculaLetraNoValida() {
    // Caso: Crea una motocicleta con todos los datos válidos, exceptuando la matricula
    // que tiene una letra minúscula
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Motocicleta("1111 AaA", new Fecha(1,10,2023), 750));
  }


  @Test
  void testMotocicletaMatriculaLetraNoValida2() {
    // Caso: Crea una motocicleta con todos los datos válidos, exceptuando la matricula
    // que tiene una letra inválida (no es una letra)
    // Resultado esperado: El objeto NO se crea correctamente y se lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Motocicleta("1111 A.A", new Fecha(1,10,2023), 750));
  }

  @Test
  void testMotocicletaFechaNull() {
    // Caso: Crea una motocicleta con todos los datos válidos, exceptuando la fecha
    //       que es null
    // Resultado esperado: El objeto NO se crea y lanza la excepción IllegalArgumentException
    assertThrows(NullPointerException.class, () -> new Motocicleta("1111 AAA", null, 750));
  }

  @Test
  void testMotocicletaCilindradaMenor50() {
    // Caso: Crea una motocicleta con todos los datos válidos, la cilindrada que vale menos de 50
    // Resultado esperado: El objeto NO se crea y lanza la excepción IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Motocicleta("1111 AAA", new Fecha(1,10,2023), 49));
  }

  @Test
  void testMotocicletaCilindrada50() {
    // Caso: Crea una motocicleta con todos los datos válidos, la cilindrada que vale exactamente 50
    // Resultado esperado: El objeto se crea correctamente
    new Motocicleta("1111 AAA", new Fecha(1,10,2023), 50);
  }

  @Test
  void testMotocicletaCilindradaMayor50() {
    // Caso: Crea una motocicleta con todos los datos válidos, la cilindrada que vale mas de 50
    // Resultado esperado: El objeto se crea correctamente
    new Motocicleta("1111 AAA", new Fecha(1,10,2023), 51);
  }

  @Test
  void testMotocicletaGetMatriculaCorrecto() {
    // Caso: Crea una motocicleta con todos los datos válidos. Al leer la matricula
    //  se debe obtener la misma con la que se creó
    // Resultado esperado: El objeto se crea correctamente y la matricula es la 
    //  que se empleó en la construcción
    Motocicleta motocicleta = new Motocicleta("1111 AAA", new Fecha(1,10,2023), 750);
    assertEquals("1111 AAA", motocicleta.getMatricula());
  }

  @Test
  void testMotocicletaGetFechaCorrecto() {
    // Caso: Crea una motocicleta con todos los datos válidos. Al leer la fecha se debe
    //   obtener la misma con la que se creó
    // Resultado esperado: El objeto se crea correctamente y la fecha que se obtiene
    //   es la misma que se empleó en la construcción
    Motocicleta motocicleta = new Motocicleta("1111 AAA", new Fecha(1,10,2023), 750);
    assertEquals(1, motocicleta.getFechaMatriculacion().getDia());
    assertEquals(10, motocicleta.getFechaMatriculacion().getMes());
    assertEquals(2023, motocicleta.getFechaMatriculacion().getAnyo());
  }

  @Test
  void testMotocicletaGetCilindradaCorrecto() {
    // Caso: Crea una motocicleta con todos los datos válidos. Al leer la cilindrada
    //   se debe obtener la que se empleó en la creación
    // Resultado esperado: El objeto se crea correctamente y la cilindrada que se
    //   obtiene es la empleada en la construccción
    Motocicleta motocicleta = new Motocicleta("1111 AAA", new Fecha(1,10,2023), 750);
    assertEquals(750, motocicleta.getCilindrada());
  }

  @Test
  void testMotocicletaDistintivoCero() {
    // Caso: Crea una motocicleta con distintivo cero y lo obtiene
    // Resultado esperado: El distintivo obtenido es cero
    MaquinaConDistintivoAmbiental maquina = new Motocicleta("1111 AAA", new Fecha(1,10,2023), 74);
    assertEquals("0", maquina.getDistintivo());
  }

  @Test
  void testMotocicletaDistintivoECO1() {
    // Caso: Crea una motocicleta con distintivo ECO y lo obtiene
    // Resultado esperado: El distintivo obtenido es ECO
    MaquinaConDistintivoAmbiental maquina = new Motocicleta("1111 AAA", new Fecha(1,10,2023), 75);
    assertEquals("ECO", maquina.getDistintivo());
  }

  @Test
  void testMotocicletaDistintivoECO2() {
    // Caso: Crea una motocicleta con distintivo ECO y lo obtiene
    // Resultado esperado: El distintivo obtenido es ECO
    MaquinaConDistintivoAmbiental maquina = new Motocicleta("1111 AAA", new Fecha(1,10,2023), 100);
    assertEquals("ECO", maquina.getDistintivo());
  }

  @Test
  void testMotocicletaDistintivoECO3() {
    // Caso: Crea una motocicleta con distintivo ECO y lo obtiene
    // Resultado esperado: El distintivo obtenido es ECO
    MaquinaConDistintivoAmbiental maquina = new Motocicleta("1111 AAA", new Fecha(1,10,2023), 125);
    assertEquals("ECO", maquina.getDistintivo());
  }

  @Test
  void testMotocicletaDistintivoA1() {
    // Caso: Crea una motocicleta con distintivo A y lo obtiene
    // Resultado esperado: El distintivo obtenido es A
    MaquinaConDistintivoAmbiental maquina = new Motocicleta("1111 AAA", new Fecha(1,10,2023), 126);
    assertEquals("A", maquina.getDistintivo());
  }

  @Test
  void testMotocicletaDistintivoA2() {
    // Caso: Crea una motocicleta con distintivo ECO y lo obtiene
    // Resultado esperado: El distintivo obtenido es ECO
    MaquinaConDistintivoAmbiental maquina = new Motocicleta("1111 AAA", new Fecha(1,10,2023), 500);
    assertEquals("A", maquina.getDistintivo());
  }

  @Test
  void testMotocicletaDistintivoB() {
    // Caso: Crea una motocicleta con distintivo ECO y lo obtiene
    // Resultado esperado: El distintivo obtenido es ECO
    MaquinaConDistintivoAmbiental maquina = new Motocicleta("1111 AAA", new Fecha(1,10,2023), 750);
    assertEquals("B", maquina.getDistintivo());
  }

}

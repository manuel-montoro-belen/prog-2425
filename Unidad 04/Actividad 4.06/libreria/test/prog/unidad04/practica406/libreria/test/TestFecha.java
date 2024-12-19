package prog.unidad04.practica406.libreria.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import prog.unidad04.practica406.libreria.Fecha;
import prog.unidad04.practica406.libreria.FechaException;

/**
 * Tests de la clase Fecha
 */
class TestFecha {

  @Test
  void testFecha() {
    // Caso: Crea una fecha con todos los datos válidos
    // Resultado esperado: El objeto se crea correctamente
    new Fecha(10,11,2023);
  }

  @Test
  void testFechaDiaMenor1() {
    // Caso: Crea una fecha con el día menor que 1
    // Resultado esperado: Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Fecha(0,11,2023));
  }

  @Test
  void testFechaDiaMayorMes31() {
    // Caso: Crea una fecha con el día mayor a 31 en un mes de 31 (enero)
    // Resultado esperado: Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Fecha(32,1,2023));
  }

  @Test
  void testFechaDiaMayorMes30() {
    // Caso: Crea una fecha con el día mayor a 30 en un mes de 30 (abril)
    // Resultado esperado: Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Fecha(31,4,2023));
  }

  @Test
  void testFechaDiaMayorMes28() {
    // Caso: Crea una fecha con el día mayor a 28 en un mes de 28 (febrero año no bisiesto)
    // Resultado esperado: Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Fecha(29,2,2021));
  }

  @Test
  void testFechaDiaMayorMes29() {
    // Caso: Crea una fecha con el día mayor a 29 en un mes de 29 (febrero año bisiesto)
    // Resultado esperado: Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Fecha(30,2,2020));
  }

  @Test
  void testFechaDiaMayorMes29Correcto() {
    // Caso: Crea una fecha con el día 29 en un mes de 29 (febrero año bisiesto)
    // Resultado esperado: Se debe crear el objeto correctamente
    new Fecha(29,2,2020);
  }

  @Test
  void testFechaMesMenor1() {
    // Caso: Crea una fecha con el mes menor que 1
    // Resultado esperado: Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Fecha(10,0,2023));
  }

  @Test
  void testFechaMesMayor12() {
    // Caso: Crea una fecha con el mes mayor a 12
    // Resultado esperado: Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Fecha(10,13,2023));
  }

  @Test
  void testFechaMes1() {
    // Caso: Crea una fecha con el mes 1
    // Resultado esperado: Se debe crear el objeto correctamente
    new Fecha(10,1,2023);
  }

  @Test
  void testFechaMes12() {
    // Caso: Crea una fecha con el mes 12
    // Resultado esperado: Se debe crear el objeto correctamente
    new Fecha(10,12,2023);
  }

  @Test
  void testFechaAnyoMenor1900() {
    // Caso: Crea una fecha con el año menor que 1900
    // Resultado esperado: Se lanza IllegalArgumentException
    assertThrows(IllegalArgumentException.class, () -> new Fecha(10,11,1899));
  }

  @Test
  void testFechaAnyo1900() {
    // Caso: Crea una fecha con el año 1900
    // Resultado esperado: Se debe crear el objeto correctamente
    new Fecha(10,11,1900);
  }

  @Test
  void testFechaDiaCorrecto() {
    // Caso: Crea una fecha con todos los datos válidos. Al leer el día se debe obtener
    //   el que se usó en la creación
    // Resultado esperado: El objeto se crea correctamente y el día es el mismo que
    //   se usó en la creación
    Fecha fecha = new Fecha(10, 11, 2023);
    assertEquals(10, fecha.getDia());
  }

  @Test
  void testFechaMesCorrecto() {
    // Caso: Crea una fecha con todos los datos válidos. Al leer el mes se debe obtener
    //   el que se usó en la creación
    // Resultado esperado: El objeto se crea correctamente y el mes es el mismo que
    //   se usó en la creación
    Fecha fecha = new Fecha(10, 11, 2023);
    assertEquals(11, fecha.getMes());
  }

  @Test
  void testFechaAnyoCorrecto() {
    // Caso: Crea una fecha con todos los datos válidos. Al leer el año se debe obtener
    //   el que se usó en la creación
    // Resultado esperado: El objeto se crea correctamente y el año es el mismo que
    //   se usó en la creación
    Fecha fecha = new Fecha(10, 11, 2023);
    assertEquals(2023, fecha.getAnyo());
  }

  @Test
  void testFechaAnyoBisiesto() {
    // Caso: Crea una fecha con todos los datos válidos en un año bisiestoy chequea
    //   si lo es o no
    // Resultado esperado: El objeto se crea correctamente y debe devolver que el año
    //   es bisiesto
    Fecha fecha = new Fecha(10, 11, 2020);
    assertTrue(fecha.esBisiesto());
  }

  @Test
  void testFechaAnyoNoBisiesto() {
    // Caso: Crea una fecha con todos los datos válidos en un año no bisiesto y
    //   chequea si lo es o no
    // Resultado esperado: El objeto se crea correctamente y debe devolver que el año
    //   NO es bisiesto
    Fecha fecha = new Fecha(10, 11, 2021);
    assertFalse(fecha.esBisiesto());
  }

  @Test
  void testFechaDiasTranscurridos0() {
    // Caso: Crea una fecha con la de inicio del calendario (1/1/1900) y calcula
    //   el número de dias transcurridos
    // Resultado esperado: 0
    Fecha fecha = new Fecha(1, 1, 1900);
    assertEquals(0, fecha.diasTranscurridos());
  }

  @Test
  void testFechaDiasTranscurridos1Dia() {
    // Caso: Crea una fecha al 2/1/1900 y calcula el número de dias transcurridos
    // Resultado esperado: 1
    Fecha fecha = new Fecha(2, 1, 1900);
    assertEquals(1, fecha.diasTranscurridos());
  }

  @Test
  void testFechaDiasTranscurridos1Mes() {
    // Caso: Crea una fecha al 1/2/1900 y calcula el número de dias transcurridos
    // Resultado esperado: 31
    Fecha fecha = new Fecha(1, 2, 1900);
    assertEquals(31, fecha.diasTranscurridos());
  }

  @Test
  void testFechaDiasTranscurridos2MesesNoBisiesto() {
    // Caso: Crea una fecha al 1/3/1900 y calcula el número de dias transcurridos
    // Resultado esperado: 31 + 28 = 59 (1900 NO es bisiesto)
    Fecha fecha = new Fecha(1, 3, 1900);
    assertEquals(59, fecha.diasTranscurridos());
  }

  @Test
  void testFechaDiasTranscurridos1AñoNoBisiesto() {
    // Caso: Crea una fecha al 1/1/1901 y calcula el número de dias transcurridos
    // Resultado esperado: 365
    Fecha fecha = new Fecha(1, 1, 1901);
    assertEquals(365, fecha.diasTranscurridos());
  }

  @Test
  void testFechaDiasTranscurridos2AñoNoBisiesto() {
    // Caso: Crea una fecha al 1/1/1902 y calcula el número de dias transcurridos
    // Resultado esperado: 730
    Fecha fecha = new Fecha(1, 1, 1902);
    assertEquals(730, fecha.diasTranscurridos());
  }

  @Test
  void testFechaDiasTranscurridos3AñoNoBisiesto() {
    // Caso: Crea una fecha al 1/1/1903 y calcula el número de dias transcurridos
    // Resultado esperado: 1095
    Fecha fecha = new Fecha(1, 1, 1903);
    assertEquals(1095, fecha.diasTranscurridos());
  }

  @Test
  void testFechaDiasTranscurridos4AñoNoBisiesto() {
    // Caso: Crea una fecha al 1/1/1904 y calcula el número de dias transcurridos
    // Resultado esperado: 1460
    Fecha fecha = new Fecha(1, 1, 1904);
    assertEquals(1460, fecha.diasTranscurridos());
  }

  @Test
  void testFechaDiasTranscurridos5Año1Bisiesto() {
    // Caso: Crea una fecha al 1/1/1905 y calcula el número de dias transcurridos
    // Resultado esperado: 1826 (1904 es bisiesto)
    Fecha fecha = new Fecha(1, 1, 1905);
    assertEquals(1826, fecha.diasTranscurridos());
  }

  @Test
  void testFechaDiasEntreDosFechas1Dia() {
    // Caso: Crea dos fechas: 1/1/1904 y 2/1/1904 y calcula el número de dias
    //    transcurridos entre ellas 
    // Resultado esperado: 1
    Fecha fecha = new Fecha(1, 1, 1904);
    Fecha fecha2 = new Fecha(2, 1, 1904);
    assertEquals(1, fecha.diasEntre(fecha2));
  }

  @Test
  void testFechaDiasEntreDosFechas1Mes() {
    // Caso: Crea dos fechas: 1/1/1904 y 1/2/1904 y calcula el número de dias
    //    transcurridos entre ellas 
    // Resultado esperado: 31
    Fecha fecha = new Fecha(1, 1, 1904);
    Fecha fecha2 = new Fecha(1, 2, 1904);
    assertEquals(31, fecha.diasEntre(fecha2));
  }

  @Test
  void testFechaDiasEntreDosFechas2Mes1Bisiesto() {
    // Caso: Crea dos fechas: 1/1/1904 y 1/2/1904 y calcula el número de dias
    //    transcurridos entre ellas (Febrero de 1904 es bisiesto)
    // Resultado esperado: 60
    Fecha fecha = new Fecha(1, 1, 1904);
    Fecha fecha2 = new Fecha(1, 3, 1904);
    assertEquals(60, fecha.diasEntre(fecha2));
  }

  @Test
  void testFechaDiasEntreDosFechas1AnyoNoBisiesto() {
    // Caso: Crea dos fechas: 1/1/1903 y 1/1/1904 y calcula el número de dias
    //    transcurridos entre ellas
    // Resultado esperado: 365
    Fecha fecha = new Fecha(1, 1, 1903);
    Fecha fecha2 = new Fecha(1, 1, 1904);
    assertEquals(365, fecha.diasEntre(fecha2));
  }

  @Test
  void testFechaDiasEntreDosFechasError() {
    // Caso: Crea dos fechas: 1/1/1904 y 1/1/1903 y calcula el número de dias
    //    transcurridos entre ellas
    // Resultado esperado: Se debe lanzar una excepción FechaException
    Fecha fecha = new Fecha(1, 1, 1904);
    Fecha fecha2 = new Fecha(1, 1, 1903);
    assertThrows(FechaException.class, ()->fecha.diasEntre(fecha2));
  }
  @Test
  void testFechaDiasEntreDosFechas1AnyoBisiesto() {
    // Caso: Crea dos fechas: 1/1/1904 y 1/1/1905 y calcula el número de dias
    //    transcurridos entre ellas (1904 es bisiesto)
    // Resultado esperado: 366
    Fecha fecha = new Fecha(1, 1, 1904);
    Fecha fecha2 = new Fecha(1, 1, 1905);
    assertEquals(366, fecha.diasEntre(fecha2));
  }

  @Test
  void testFechaComparaFechasMenor() {
    // Caso: Crea dos fechas: 1/1/1904 y 2/1/1904 y determina si la primera es
    //   menor, igual o mayor que la segunda
    // Resultado esperado: negativo
    Fecha fecha = new Fecha(1, 1, 1904);
    Fecha fecha2 = new Fecha(2, 1, 1904);
    assertTrue(fecha.compara(fecha2) < 0);
  }

  @Test
  void testFechaComparaFechasIgual() {
    // Caso: Crea dos fechas: 1/1/1904 y 1/1/1904 y determina si la primera es
    //   menor mayor o igual que la segunda
    // Resultado esperado: 0
    Fecha fecha = new Fecha(1, 1, 1904);
    Fecha fecha2 = new Fecha(1, 1, 1904);
    assertTrue(fecha.compara(fecha2) == 0);
  }

  @Test
  void testFechaComparaFechasMayor() {
    // Caso: Crea dos fechas: 2/1/1904 y 1/1/1904 y determina si la primera es
    //   menor, mayor o igual que la segunda
    // Resultado esperado: positivo
    Fecha fecha = new Fecha(2, 1, 1904);
    Fecha fecha2 = new Fecha(1, 1, 1904);
    assertTrue(fecha.compara(fecha2) > 0);
  }

  @Test
  void testFechaATexto() {
    // Caso: Crea una fecha y la convierte a texto
    // Resultado esperado: la fecha en texto
   Fecha fecha = new Fecha(2, 2, 1904);
    assertEquals("2 de febrero de 1904", fecha.toString());
  }
}

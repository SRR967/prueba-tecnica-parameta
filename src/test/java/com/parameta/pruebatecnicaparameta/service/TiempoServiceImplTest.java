package com.parameta.pruebatecnicaparameta.service;

import com.parameta.pruebatecnicaparameta.service.implementation.TiempoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TiempoServiceImplTest {

    private TiempoServiceImpl tiempoService;

    @BeforeEach
    void setUp() {
        tiempoService = new TiempoServiceImpl();
    }

    @Test
    @DisplayName("Debe calcular correctamente el tiempo entre una fecha pasada y hoy")
    void testCalcularTiempoCorrecto() throws Exception {
        // Arrange
        String fecha = LocalDate.now().minusYears(2).minusMonths(5).minusDays(3).toString();

        // Act
        String resultado = tiempoService.calcularTiempo(fecha);

        // Assert
        assertTrue(resultado.contains("2 años"));
        assertTrue(resultado.contains("5 meses"));
        assertTrue(resultado.contains("3 días"));
    }

    @Test
    @DisplayName("Debe retornar 0 años 0 meses 0 días si la fecha es hoy")
    void testCalcularTiempoHoy() throws Exception {
        // Arrange
        String fecha = LocalDate.now().toString();

        // Act
        String resultado = tiempoService.calcularTiempo(fecha);

        // Assert
        assertEquals("0 años - 0 meses - 0 días", resultado);
    }

    @Test
    @DisplayName("Debe lanzar excepción si la fecha tiene formato inválido")
    void testCalcularTiempoFormatoInvalido() {
        // Arrange
        String fechaInvalida = "2025/01/01";

        // Act & Assert
        assertThrows(Exception.class, () -> tiempoService.calcularTiempo(fechaInvalida));
    }

    @Test
    @DisplayName("Debe lanzar excepción si la fecha es nula")
    void testCalcularTiempoFechaNula() {
        String fechaNula = null;

        assertThrows(NullPointerException.class, () -> tiempoService.calcularTiempo(fechaNula));
    }

}

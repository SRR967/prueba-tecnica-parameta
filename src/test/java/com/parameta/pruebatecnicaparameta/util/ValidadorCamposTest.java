package com.parameta.pruebatecnicaparameta.util;

import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoRequestDTO;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("ValidadorCampos Unit Tests")
public class ValidadorCamposTest {

    private ValidadorCampos validador;
    private EmpleadoRequestDTO dtoValido;


    @BeforeEach
    void setUp() {
        validador = new ValidadorCampos();
        dtoValido = new EmpleadoRequestDTO(
                "Juan Carlos",
                "Pérez González",
                "CC",
                "12345678",
                "1990-05-15",
                "2020-01-10",
                "Desarrollador",
                2500000.0
        );
    }

    @Test
    @Order(1)
    @DisplayName("Valida correctamente un DTO válido")
    void debeValidarEmpleadoCorrectamente() {
        EmpleadoRequestDTO dto = new EmpleadoRequestDTO(
                "Santiago", "Ramón", "CC", "123456789",
                "2000-01-01", "2020-01-01", "Ingeniero", 5000.0
        );

        assertDoesNotThrow(() -> validador.validar(dto));
    }

    @Test
    @Order(2)
    @DisplayName("Lanza excepción si algún campo obligatorio está vacío")
    void debeLanzarErrorPorCampoVacio() {
        EmpleadoRequestDTO dto = new EmpleadoRequestDTO(
                "", "Ramón", "CC", "123456789",
                "2000-01-01", "2020-01-01", "Ingeniero", 5000.0
        );

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> validador.validar(dto));
        assertEquals("Todos los campos son obligatorios.", ex.getMessage());
    }

    @Test
    @Order(3)
    @DisplayName("Lanza excepción si la fecha de nacimiento es futura")
    void debeLanzarErrorPorFechaFuturaNacimiento() {
        String fechaFutura = java.time.LocalDate.now().plusDays(1).toString();

        EmpleadoRequestDTO dto = new EmpleadoRequestDTO(
                "Santiago", "Ramón", "CC", "123456789",
                fechaFutura, "2020-01-01", "Ingeniero", 5000.0
        );

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> validador.validar(dto));
        assertEquals("La fecha de nacimiento no puede ser una fecha futura.", ex.getMessage());
    }

    @Test
    @Order(4)
    @DisplayName(" Lanza excepción si el empleado es menor de edad")
    void debeLanzarErrorPorMenorEdad() {
        String fechaMenor = java.time.LocalDate.now().minusYears(17).toString();

        EmpleadoRequestDTO dto = new EmpleadoRequestDTO(
                "Santiago", "Ramón", "CC", "123456789",
                fechaMenor, "2020-01-01", "Ingeniero", 5000.0
        );

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> validador.validar(dto));
        assertEquals("El empleado debe ser mayor de edad.", ex.getMessage());
    }

    @Test
    @Order(5)
    @DisplayName(" Lanza excepción si la fecha de nacimiento es posterior a la de vinculacion")
    void debeLanzarErrorSiNacimientoEsMayorAVinculacion() {
        EmpleadoRequestDTO dto = new EmpleadoRequestDTO(
                "Santiago", "Ramón", "CC", "123456789",
                "2021-01-01", "2020-01-01", "Ingeniero", 5000.0
        );

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> validador.validar(dto));
        assertEquals("La fecha de nacimiento no puede ser posterior a la de vinculación.", ex.getMessage());
    }






}

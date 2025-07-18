package com.parameta.pruebatecnicaparameta.util;

import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoRequestDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

@Component
public class ValidadorCampos {

    public void validar(EmpleadoRequestDTO dto) {
        validarCamposObligatorios(dto);
        LocalDate nacimiento = parseFecha(dto.fechaNacimiento(), "fechaNacimiento");
        LocalDate vinculacion = parseFecha(dto.fechaVinculacion(), "fechaVinculacion");
        validarFechas(nacimiento, vinculacion);
        validarMayorDeEdad(nacimiento);
    }

    private void validarCamposObligatorios(EmpleadoRequestDTO dto) {
        if (isBlank(dto.nombres()) || isBlank(dto.apellidos()) || isBlank(dto.tipoDocumento())
                || isBlank(dto.numeroDocumento()) || isBlank(dto.fechaNacimiento())
                || isBlank(dto.fechaVinculacion()) || isBlank(dto.cargo()) || dto.salario() == null) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
    }

    private LocalDate parseFecha(String fechaStr, String campo) {
        try {
            return LocalDate.parse(fechaStr);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato inválido para " + campo + ". Use yyyy-MM-dd.");
        }
    }

    private void validarFechaNoFutura(LocalDate fecha, String campo) {
        if (fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La " + campo + " no puede ser una fecha futura.");
        }
    }

    private void validarFechas(LocalDate nacimiento, LocalDate vinculacion) {
        validarFechaNoFutura(nacimiento, "fecha de nacimiento");
        validarFechaNoFutura(vinculacion, "fecha de vinculación");

        if (nacimiento.isAfter(vinculacion)) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser posterior a la de vinculación.");
        }
    }


    private void validarMayorDeEdad(LocalDate nacimiento) {
        if (Period.between(nacimiento, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("El empleado debe ser mayor de edad.");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}

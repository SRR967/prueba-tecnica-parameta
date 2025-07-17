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
        validarFormatoFechas(dto.fechaNacimiento(), dto.fechaVinculacion());
        validarMayorDeEdad(dto.fechaNacimiento());
    }

    private void validarCamposObligatorios(EmpleadoRequestDTO dto) {
        if (isBlank(dto.nombres()) || isBlank(dto.apellidos()) || isBlank(dto.tipoDocumento())
                || isBlank(dto.numeroDocumento()) || isBlank(dto.fechaNacimiento())
                || isBlank(dto.fechaVinculacion()) || isBlank(dto.cargo()) || dto.salario()==null) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
    }

    private void validarFormatoFechas(String fechaNacimiento, String fechaVinculacion) {
        try {
            LocalDate.parse(fechaNacimiento);
            LocalDate.parse(fechaVinculacion);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha incorrecto. Use yyyy-MM-dd.");
        }
    }

    private void validarMayorDeEdad(String fechaNacimiento) {
        LocalDate nacimiento = LocalDate.parse(fechaNacimiento);
        if (Period.between(nacimiento, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("El empleado debe ser mayor de edad.");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }


}

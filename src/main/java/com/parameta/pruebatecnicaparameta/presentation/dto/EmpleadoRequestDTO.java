package com.parameta.pruebatecnicaparameta.presentation.dto;

import java.time.LocalDate;

public record EmpleadoRequestDTO(
        String nombres, String apellidos, String tipoDocumento, String numeroDocumento,
        LocalDate fechaNacimiento, LocalDate fechaVinculacion, String cargo, double salario

) {
}

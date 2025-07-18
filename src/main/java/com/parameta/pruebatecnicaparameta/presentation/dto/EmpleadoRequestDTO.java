package com.parameta.pruebatecnicaparameta.presentation.dto;


public record EmpleadoRequestDTO(
        String nombres, String apellidos, String tipoDocumento, String numeroDocumento,
        String fechaNacimiento, String fechaVinculacion, String cargo, Double salario

) {
}

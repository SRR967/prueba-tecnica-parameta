package com.parameta.pruebatecnicaparameta.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@RequiredArgsConstructor
@Data
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String nombres;

    @NonNull
    private String apellidos;

    @NonNull
    private String tipoDocumento;

    @NonNull
    private String numeroDocumento;

    @NonNull
    private LocalDate fechaNacimiento;

    @NonNull
    private LocalDate fechaVinculacion;

    @NonNull
    private String cargo;

    @NonNull
    private Double salario;
}

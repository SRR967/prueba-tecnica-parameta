package com.parameta.pruebatecnicaparameta.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombres;

    @Column(nullable = false, length = 50)
    private String apellidos;

    @Column(nullable = false, length = 3)
    private String tipoDocumento;

    @Column(nullable = false, unique = true, length = 12)
    private String numeroDocumento;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private LocalDate fechaVinculacion;

    @Column(nullable = false, length = 100)
    private String cargo;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double salario;
}

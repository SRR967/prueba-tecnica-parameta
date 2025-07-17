package com.parameta.pruebatecnicaparameta.presentation.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@XmlRootElement(name = "EmpleadoRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmpleadoSoapResponse {

    @XmlElement(required = true)
    private String nombres;

    @XmlElement(required = true)
    private String apellidos;

    @XmlElement(required = true)
    private String tipoDocumento;

    @XmlElement(required = true)
    private String numeroDocumento;

    @XmlElement(required = true)
    private LocalDate fechaNacimiento;

    @XmlElement(required = true)
    private LocalDate fechaVinculacion;

    @XmlElement(required = true)
    private String cargo;

    @XmlElement(required = true)
    private Double salario;

}

package com.parameta.pruebatecnicaparameta.util.mapper;


import com.parameta.pruebatecnicaparameta.persistence.entity.Empleado;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoSoapResponse;
import com.parameta.pruebatecnicaparameta.wsdl.EmpleadoRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmpleadoMapper {

    public Empleado SoapToEntity(EmpleadoRequest soap) {
        return new Empleado(soap.getNombres(), soap.getApellidos(), soap.getTipoDocumento(),
                soap.getNumeroDocumento(), LocalDate.parse(soap.getFechaNacimiento()), LocalDate.parse(soap.getFechaVinculacion()),
                soap.getCargo(), soap.getSueldo());
    }
}

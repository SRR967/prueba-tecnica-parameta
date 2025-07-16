package com.parameta.pruebatecnicaparameta.util.mapper;


import com.parameta.pruebatecnicaparameta.persistence.entity.Empleado;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoSoapResponse;

public class EmpleadoMapper {

    public Empleado SoapToEntity(EmpleadoSoapResponse soap) {
        return new Empleado(soap.getNombres(), soap.getApellidos(), soap.getTipoDocumento(),
                soap.getNumeroDocumento(),soap.getFechaNacimiento(), soap.getFechaVinculacion(),
                soap.getCargo(), soap.getSalario());
    }
}

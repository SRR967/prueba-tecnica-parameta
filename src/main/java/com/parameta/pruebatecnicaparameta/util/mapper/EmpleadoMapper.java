package com.parameta.pruebatecnicaparameta.util.mapper;


import com.parameta.pruebatecnicaparameta.persistence.entity.Empleado;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoRequestDTO;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoResponseDTO;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoSoapResponse;
import com.parameta.pruebatecnicaparameta.wsdl.EmpleadoRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmpleadoMapper {

    public Empleado soapToEntity(EmpleadoRequest soap) {
        return new Empleado(soap.getNombres(), soap.getApellidos(), soap.getTipoDocumento(),
                soap.getNumeroDocumento(), LocalDate.parse(soap.getFechaNacimiento()), LocalDate.parse(soap.getFechaVinculacion()),
                soap.getCargo(), soap.getSalario());
    }

    public EmpleadoRequest dtoToSoap(EmpleadoRequestDTO dto) {
        EmpleadoRequest soapRequest = new EmpleadoRequest();
        soapRequest.setNombres(dto.nombres());
        soapRequest.setApellidos(dto.apellidos());
        soapRequest.setTipoDocumento(dto.tipoDocumento());
        soapRequest.setNumeroDocumento(dto.numeroDocumento());
        soapRequest.setFechaNacimiento(dto.fechaNacimiento());
        soapRequest.setFechaVinculacion(dto.fechaVinculacion());
        soapRequest.setCargo(dto.cargo());
        soapRequest.setSalario(dto.salario());
        return soapRequest;
    }

}

package com.parameta.pruebatecnicaparameta.util.mapper;


import com.parameta.pruebatecnicaparameta.persistence.entity.Empleado;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoRequestDTO;
import com.parameta.pruebatecnicaparameta.wsdl.EmpleadoRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmpleadoMapper {

    public Empleado soapToEntity(EmpleadoRequest soap) {
        Empleado empleado = Empleado.builder()
                .nombres(soap.getNombres())
                .apellidos(soap.getApellidos())
                .tipoDocumento(soap.getTipoDocumento())
                .numeroDocumento(soap.getNumeroDocumento())
                .fechaNacimiento(LocalDate.parse(soap.getFechaNacimiento()))
                .fechaVinculacion(LocalDate.parse(soap.getFechaVinculacion()))
                .cargo(soap.getCargo())
                .salario(soap.getSalario())
                .build();
        return empleado;
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

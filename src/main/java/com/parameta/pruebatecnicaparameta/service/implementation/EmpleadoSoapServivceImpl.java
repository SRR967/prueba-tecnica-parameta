package com.parameta.pruebatecnicaparameta.service.implementation;

import com.parameta.pruebatecnicaparameta.persistence.repository.EmpleadoRepository;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoSoapResponse;
import com.parameta.pruebatecnicaparameta.service.interfaces.EmpleadoSoapService;
import com.parameta.pruebatecnicaparameta.util.mapper.EmpleadoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmpleadoSoapServivceImpl implements EmpleadoSoapService {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper empleadoMapper;

    @Override
    public String registrarEmpleado(EmpleadoSoapResponse request) {
        empleadoRepository.save(empleadoMapper.SoapToEntity(request));
        return request.getNumeroDocumento();
    }
}

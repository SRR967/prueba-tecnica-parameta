package com.parameta.pruebatecnicaparameta.service.implementation;

import com.parameta.pruebatecnicaparameta.persistence.repository.EmpleadoRepository;
import com.parameta.pruebatecnicaparameta.service.interfaces.EmpleadoSoapService;
import com.parameta.pruebatecnicaparameta.util.mapper.EmpleadoMapper;
import com.parameta.pruebatecnicaparameta.wsdl.EmpleadoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoSoapServivceImpl implements EmpleadoSoapService {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper empleadoMapper;

    @Override
    public String registrarEmpleado(EmpleadoRequest request)throws  Exception {
        empleadoRepository.save(empleadoMapper.soapToEntity(request));
        return request.getNumeroDocumento();
    }
}

package com.parameta.pruebatecnicaparameta.service.interfaces;

import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoRequestDTO;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoSoapResponse;
import org.springframework.stereotype.Service;

@Service
public interface EmpleadoSoapService {

    String registrarEmpleado(EmpleadoSoapResponse request);
}

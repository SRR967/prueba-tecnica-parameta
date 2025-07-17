package com.parameta.pruebatecnicaparameta.service.interfaces;

import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoRequestDTO;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoSoapResponse;
import com.parameta.pruebatecnicaparameta.wsdl.EmpleadoRequest;
import org.springframework.stereotype.Service;

public interface EmpleadoSoapService {

    String registrarEmpleado(EmpleadoRequest request);
}

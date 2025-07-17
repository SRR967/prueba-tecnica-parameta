package com.parameta.pruebatecnicaparameta.service.interfaces;

import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoRequestDTO;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoResponseDTO;

public interface EmpleadoService {

    EmpleadoResponseDTO procesarEmpleado(EmpleadoRequestDTO dto)throws  Exception;

}

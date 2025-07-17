package com.parameta.pruebatecnicaparameta.service.implementation;

import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoRequestDTO;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoResponseDTO;
import com.parameta.pruebatecnicaparameta.service.client.EmpleadoSoapClient;
import com.parameta.pruebatecnicaparameta.service.interfaces.EmpleadoService;
import com.parameta.pruebatecnicaparameta.service.interfaces.TiempoService;
import com.parameta.pruebatecnicaparameta.util.ValidadorCampos;
import com.parameta.pruebatecnicaparameta.util.mapper.EmpleadoMapper;
import com.parameta.pruebatecnicaparameta.wsdl.EmpleadoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService{

    private final TiempoService tiempoService;
    private final ValidadorCampos validadorCampos;
    private final EmpleadoSoapClient empleadoSoapClient;
    private final EmpleadoMapper empleadoMapper;


    @Override
    public EmpleadoResponseDTO procesarEmpleado(EmpleadoRequestDTO dto)throws Exception{
        validarYEnviar(dto);
        return construirRespuesta(dto);
    }
    private void validarYEnviar(EmpleadoRequestDTO dto) {
        validadorCampos.validar(dto);
        EmpleadoRequest empleadoRequest = empleadoMapper.dtoToSoap(dto);
        empleadoSoapClient.enviarEmpleado(empleadoRequest);
    }

    private EmpleadoResponseDTO construirRespuesta(EmpleadoRequestDTO dto) throws Exception {
        String edad = tiempoService.calcularTiempo(dto.fechaNacimiento());
        String tiempoVinc = tiempoService.calcularTiempo(dto.fechaVinculacion());
        return new EmpleadoResponseDTO(dto, edad, tiempoVinc);
    }

}

package com.parameta.pruebatecnicaparameta.service.implementation;

import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoRequestDTO;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoResponseDTO;
import com.parameta.pruebatecnicaparameta.service.interfaces.EmpleadoService;
import com.parameta.pruebatecnicaparameta.service.interfaces.TiempoService;
import com.parameta.pruebatecnicaparameta.util.ValidadorCampos;
import com.parameta.pruebatecnicaparameta.util.mapper.EmpleadoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService{

    private final TiempoService tiempoService;
    private final ValidadorCampos validadorCampos;
    private final EmpleadoMapper empleadoMapper;


    @Override
    public EmpleadoResponseDTO procesarEmpleado(EmpleadoRequestDTO dto){
        validadorCampos.validar(dto);
        //llamar servicio soap

        String anios= tiempoService.calcularTiempo(dto.fechaNacimiento());
        String tiempoVinculacion= tiempoService.calcularTiempo(dto.fechaVinculacion());
        return new EmpleadoResponseDTO(dto,anios,tiempoVinculacion);


    }
}

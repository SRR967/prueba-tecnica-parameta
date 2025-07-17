package com.parameta.pruebatecnicaparameta.presentation.controller;

import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoRequestDTO;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoResponseDTO;
import com.parameta.pruebatecnicaparameta.presentation.dto.ResponseDTO;
import com.parameta.pruebatecnicaparameta.service.interfaces.EmpleadoService;
import com.parameta.pruebatecnicaparameta.service.interfaces.TiempoService;
import com.parameta.pruebatecnicaparameta.util.mapper.EmpleadoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping("/empleado")
    public ResponseEntity<ResponseDTO<EmpleadoResponseDTO>>
    procesarEmpleado(@RequestParam String nombres,
                     @RequestParam String apellidos,
                     @RequestParam String tipoDocumento,
                     @RequestParam String numeroDocumento,
                     @RequestParam String fechaNacimiento,
                     @RequestParam String fechaVinculacion,
                     @RequestParam String cargo,
                     @RequestParam Double salario){
        EmpleadoRequestDTO request = new EmpleadoRequestDTO(
                nombres, apellidos, tipoDocumento, numeroDocumento,
                fechaNacimiento, fechaVinculacion, cargo, salario
        );

        return ResponseEntity.ok().body(new ResponseDTO<>(false, empleadoService.procesarEmpleado(request)));
    }



}

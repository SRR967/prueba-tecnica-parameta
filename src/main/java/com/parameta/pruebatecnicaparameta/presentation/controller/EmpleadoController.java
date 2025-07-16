package com.parameta.pruebatecnicaparameta.presentation.controller;

import com.parameta.pruebatecnicaparameta.presentation.dto.ResponseDTO;
import com.parameta.pruebatecnicaparameta.service.interfaces.TiempoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmpleadoController {

    private final TiempoService tiempoService;


}

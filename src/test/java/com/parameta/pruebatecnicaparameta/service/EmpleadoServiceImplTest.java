package com.parameta.pruebatecnicaparameta.service;

import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoRequestDTO;
import com.parameta.pruebatecnicaparameta.presentation.dto.EmpleadoResponseDTO;
import com.parameta.pruebatecnicaparameta.service.client.EmpleadoSoapClient;
import com.parameta.pruebatecnicaparameta.service.implementation.EmpleadoServiceImpl;
import com.parameta.pruebatecnicaparameta.service.interfaces.TiempoService;
import com.parameta.pruebatecnicaparameta.util.ValidadorCampos;
import com.parameta.pruebatecnicaparameta.util.mapper.EmpleadoMapper;
import com.parameta.pruebatecnicaparameta.wsdl.EmpleadoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EmpleadoServiceImplTest {
    @Mock
    private TiempoService tiempoService;

    @Mock
    private ValidadorCampos validadorCampos;

    @Mock
    private EmpleadoSoapClient empleadoSoapClient;

    @Mock
    private EmpleadoMapper empleadoMapper;

    @InjectMocks
    private EmpleadoServiceImpl empleadoService;

    private EmpleadoRequestDTO dto;
    private EmpleadoRequest soapRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dto = new EmpleadoRequestDTO(
                "Santiago", "Ramón", "CC", "123456789",
                "2000-01-01", "2020-01-01", "Desarrollador", 5000000.0
        );
        soapRequest = new EmpleadoRequest();
    }

    @Test
    @DisplayName("procesarEmpleado() deberia validar, enviar SOAP y esperar una respuesta")
    void testProcesarEmpleado() throws Exception {

        when(empleadoMapper.dtoToSoap(dto)).thenReturn(soapRequest);
        when(tiempoService.calcularTiempo("2000-01-01")).thenReturn("24 años - 0 meses - 0 días");
        when(tiempoService.calcularTiempo("2020-01-01")).thenReturn("4 años - 6 meses - 0 días");


        EmpleadoResponseDTO response = empleadoService.procesarEmpleado(dto);


        verify(validadorCampos).validar(dto);
        verify(empleadoSoapClient).enviarEmpleado(soapRequest);
        verify(tiempoService).calcularTiempo("2000-01-01");
        verify(tiempoService).calcularTiempo("2020-01-01");

        assertNotNull(response);
        assertEquals("24 años - 0 meses - 0 días", response.anios());
        assertEquals("4 años - 6 meses - 0 días", response.tiempoVinculacion());
    }



}

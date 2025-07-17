package com.parameta.pruebatecnicaparameta.service.interfaces;

import com.parameta.pruebatecnicaparameta.persistence.entity.Empleado;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

public interface TiempoService {
    String calcularTiempo(String fecha);
}

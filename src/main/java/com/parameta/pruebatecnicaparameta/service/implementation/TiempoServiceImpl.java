package com.parameta.pruebatecnicaparameta.service.implementation;

import com.parameta.pruebatecnicaparameta.service.interfaces.TiempoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class TiempoServiceImpl implements TiempoService {

    @Override
    public String calcularTiempo(String fecha) {
        LocalDate fechaConvertida = LocalDate.parse(fecha);
        return format(Period.between(fechaConvertida, LocalDate.now()));
    }

    private String format(Period periodo) {
        return periodo.getYears() + " años - " + periodo.getMonths() + " meses - " + periodo.getDays() + " días";
    }
}

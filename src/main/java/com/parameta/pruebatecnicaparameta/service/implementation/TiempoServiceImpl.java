package com.parameta.pruebatecnicaparameta.service.implementation;

import com.parameta.pruebatecnicaparameta.service.interfaces.TiempoService;

import java.time.LocalDate;
import java.time.Period;

public class TiempoServiceImpl implements TiempoService {
    @Override
    public String calcularTiempo(LocalDate fecha) {
        return format(Period.between(fecha, LocalDate.now()));
    }

    private String format(Period periodo) {
        return periodo.getYears() + "años -" + periodo.getMonths() + "meses -" + periodo.getDays() + "dias";
    }
}

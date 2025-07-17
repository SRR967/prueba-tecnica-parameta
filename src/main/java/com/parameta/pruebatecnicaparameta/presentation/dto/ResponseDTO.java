package com.parameta.pruebatecnicaparameta.presentation.dto;

public record ResponseDTO<T>(
        boolean error, T message
) {
}

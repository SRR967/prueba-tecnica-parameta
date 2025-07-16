package com.parameta.pruebatecnicaparameta.presentation.dto;

public record ResponseDTO<T>(
        T message, boolean error
) {
}

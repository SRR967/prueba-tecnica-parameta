package com.parameta.pruebatecnicaparameta.presentation.exception;

public record ResponseDTO<T>(
        boolean error, T message
) {
}

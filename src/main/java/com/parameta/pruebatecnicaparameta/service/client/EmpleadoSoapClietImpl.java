package com.parameta.pruebatecnicaparameta.service.client;

import com.parameta.pruebatecnicaparameta.wsdl.EmpleadoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
@RequiredArgsConstructor
public class EmpleadoSoapClietImpl implements EmpleadoSoapClient {

    private final WebServiceTemplate webServiceTemplate;

    @Override
    public void enviarEmpleado(EmpleadoRequest request) {
        webServiceTemplate.marshalSendAndReceive("http://localhost:8080/ws", request);

    }
}

package com.parameta.pruebatecnicaparameta.presentation.controller;

import com.parameta.pruebatecnicaparameta.service.interfaces.EmpleadoSoapService;
import com.parameta.pruebatecnicaparameta.wsdl.EmpleadoRequest;
import com.parameta.pruebatecnicaparameta.wsdl.EmpleadoResponse;
import com.parameta.pruebatecnicaparameta.wsdl.ObjectFactory;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@RequiredArgsConstructor
public class EmpleadoEndPoint {

    private static final String NAMESPACE_URI = "http://parameta.com/empleado";
    private final EmpleadoSoapService empleadoSoapService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmpleadoRequest")
    @ResponsePayload
    public EmpleadoResponse guardarEmpleado(@RequestPayload EmpleadoRequest request)throws  Exception {
        empleadoSoapService.registrarEmpleado(request);

        // Usar la clase EmpleadoResponse generada por JAXB
        ObjectFactory factory = new ObjectFactory();
        EmpleadoResponse response = factory.createEmpleadoResponse();
        response.setMensaje("Empleado guardado exitosamente");
        return response;
    }
}
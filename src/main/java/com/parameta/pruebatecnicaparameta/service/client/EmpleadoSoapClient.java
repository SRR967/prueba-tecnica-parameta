package com.parameta.pruebatecnicaparameta.service.client;

import com.parameta.pruebatecnicaparameta.wsdl.EmpleadoRequest;

public interface EmpleadoSoapClient {
    void enviarEmpleado(EmpleadoRequest request);
}

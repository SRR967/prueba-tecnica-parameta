package com.parameta.pruebatecnicaparameta.persistence.repository;

import com.parameta.pruebatecnicaparameta.persistence.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
}

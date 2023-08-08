package io.github.rodrigodante.clientes.model.repository;

import io.github.rodrigodante.clientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Long> {
}

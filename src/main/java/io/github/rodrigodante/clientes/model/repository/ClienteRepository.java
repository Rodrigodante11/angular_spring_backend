package io.github.rodrigodante.clientes.model.repository;

import io.github.rodrigodante.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

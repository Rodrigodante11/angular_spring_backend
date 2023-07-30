package io.github.rodrigodante.clientes.model.repository;

import io.github.rodrigodante.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}

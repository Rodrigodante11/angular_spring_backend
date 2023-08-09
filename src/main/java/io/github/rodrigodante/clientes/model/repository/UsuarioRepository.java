package io.github.rodrigodante.clientes.model.repository;

import io.github.rodrigodante.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

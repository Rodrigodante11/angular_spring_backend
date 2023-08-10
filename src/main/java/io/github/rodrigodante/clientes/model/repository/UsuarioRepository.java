package io.github.rodrigodante.clientes.model.repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import io.github.rodrigodante.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);
}

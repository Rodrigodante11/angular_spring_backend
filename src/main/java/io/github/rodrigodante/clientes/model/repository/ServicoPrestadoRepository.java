package io.github.rodrigodante.clientes.model.repository;

import io.github.rodrigodante.clientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Long> {

    @Query(" SELECT s FROM ServicoPrestado s " +
            " JOIN s.cliente c " +
            " WHERE upper( c.nome) " +
            " LIKE upper( :nome) AND  month(s.data) = :mes")
    List<ServicoPrestado> findByNomeClienteAndMes(
            @Param("nome") String nome,
            @Param("mes") Integer mes);
}

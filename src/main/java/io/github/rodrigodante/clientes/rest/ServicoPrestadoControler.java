package io.github.rodrigodante.clientes.rest;

import io.github.rodrigodante.clientes.model.entity.Cliente;
import io.github.rodrigodante.clientes.model.entity.ServicoPrestado;
import io.github.rodrigodante.clientes.model.repository.ClienteRepository;
import io.github.rodrigodante.clientes.model.repository.ServicoPrestadoRepository;
import io.github.rodrigodante.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.rodrigodante.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor  // cria um contrutor com os atributos final
public class ServicoPrestadoControler {


    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final BigDecimalConverter bigDecimalConverter;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Cliente cliente =
                clienteRepository.
                    findById(dto.getIdCliente())
                        .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.BAD_REQUEST , "Cliente inexistente"));



        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));

        return servicoPrestadoRepository.save(servicoPrestado);

    }
}

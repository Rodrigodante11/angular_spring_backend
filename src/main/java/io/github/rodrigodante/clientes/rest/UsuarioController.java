package io.github.rodrigodante.clientes.rest;

import io.github.rodrigodante.clientes.model.entity.Usuario;
import io.github.rodrigodante.clientes.rest.excetion.UsuarioCadastradoException;
import io.github.rodrigodante.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.xml.ws.Response;

@RestController
@RequestMapping("api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        try {
            usuarioService.salvar(usuario);
        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}

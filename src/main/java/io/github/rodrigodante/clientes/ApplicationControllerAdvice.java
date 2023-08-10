package io.github.rodrigodante.clientes;

import io.github.rodrigodante.clientes.rest.excetion.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // mapeando um bad request para as validacoes com o erro
    public ApiErrors handleValidationErrors(MethodArgumentNotValidException ex) { // MethodArgumentNotValidException serve para pegar erro feito pelo @Valid
        BindingResult bindingResult = ex.getBindingResult(); // resultado da validacao

        List<String> messages = bindingResult
                .getAllErrors()  //pegando todos erros
                .stream()
                .map( objectError -> objectError.getDefaultMessage() )
                .collect( Collectors.toList()); // tranformando o stream de stream  em um array de stream

        return new ApiErrors(messages);
    }

    @ExceptionHandler(ResponseStatusException.class) // Retorno dinamico para os HTTP STATUS
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex ){
        String mensagemErro = ex.getReason();
        HttpStatus codigoStatus = ex.getStatus();
        ApiErrors apiErros = new ApiErrors(mensagemErro);
        return new ResponseEntity(apiErros, codigoStatus);
    }
}

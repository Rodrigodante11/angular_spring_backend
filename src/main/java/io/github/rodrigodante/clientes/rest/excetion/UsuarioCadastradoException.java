package io.github.rodrigodante.clientes.rest.excetion;

public class UsuarioCadastradoException extends  RuntimeException{

    public UsuarioCadastradoException(String username){
        super("Usario ja cadasrado para o username: " +username);
    }
}

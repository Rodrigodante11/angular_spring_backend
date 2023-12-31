package io.github.rodrigodante.clientes.service;


import io.github.rodrigodante.clientes.model.entity.Usuario;
import io.github.rodrigodante.clientes.model.repository.UsuarioRepository;
import io.github.rodrigodante.clientes.rest.excetion.UsuarioCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        boolean exists = usuarioRepository.existsByUsername(usuario.getUsername());
        if (exists) {
            throw new UsuarioCadastradoException(usuario.getUsername());
        }
        return usuarioRepository.save(usuario);
    }
    @Override  // classe UserDetail ja tem varios metodo como isAccountNonExpired(), isAccountNonLocked
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login Inexistente"));

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }
}

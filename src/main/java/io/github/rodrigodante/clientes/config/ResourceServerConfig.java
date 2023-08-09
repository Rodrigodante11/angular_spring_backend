package io.github.rodrigodante.clientes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer // resouces sao as APIs
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/api/usuario").permitAll()  // para usuarios nao preciso de nenhuma role
                .antMatchers(
                        "/api/clientes/**",
                        "/api/servicos-prestados/**").authenticated() // precisa de autenticacao para acessar essa url
                .anyRequest().denyAll(); // para todas as outras neque todas
                //.hasAnyRole("USER", "ADMIN") // o usuario com regua "user" ou "ADMIN

    }
}

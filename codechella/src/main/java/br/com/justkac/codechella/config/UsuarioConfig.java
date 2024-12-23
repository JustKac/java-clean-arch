package br.com.justkac.codechella.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.justkac.codechella.application.gateways.RepositorioDeUsuario;
import br.com.justkac.codechella.application.usecases.CriarUsuario;
import br.com.justkac.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.justkac.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.justkac.codechella.infra.persistence.UsuarioRepository;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorio) {
        return new CriarUsuario(repositorio);
    }

    @Bean
    RepositorioDeUsuarioJpa criaRepositorioJpa(UsuarioRepository usuarioRepository, UsuarioEntityMapper mapper) {
        return new RepositorioDeUsuarioJpa(usuarioRepository, mapper);
    }

    @Bean
    UsuarioEntityMapper retornaMapper() {
        return new UsuarioEntityMapper();
    }
}

package br.com.justkac.codechella.application.usecases;

import br.com.justkac.codechella.application.gateways.RepositorioDeUsuario;
import br.com.justkac.codechella.domain.entities.usuario.Usuario;

public class AlterarUsuario {
    
    private final RepositorioDeUsuario repositorio;

    public AlterarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario alteraDadosUsuario(String cpf, Usuario usuario) {
        return repositorio.alteraUsuario(cpf, usuario);
    }
}

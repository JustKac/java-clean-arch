package br.com.justkac.codechella.application.usecases;

import java.util.List;

import br.com.justkac.codechella.application.gateways.RepositorioDeUsuario;
import br.com.justkac.codechella.domain.entities.usuario.Usuario;

public class ListarUsuarios {

    private final RepositorioDeUsuario repositorio;

    public ListarUsuarios(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> obterTodosUsuarios() {
        return this.repositorio.listarTodos();
    }
}

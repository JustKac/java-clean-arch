package br.com.justkac.codechella.application.gateways;

import java.util.List;

import br.com.justkac.codechella.domain.entities.usuario.Usuario;

public interface RepositorioDeUsuario {

    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}

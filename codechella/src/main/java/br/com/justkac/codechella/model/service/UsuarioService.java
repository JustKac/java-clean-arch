package br.com.justkac.codechella.model.service;

import java.util.List;

import br.com.justkac.codechella.model.entity.Usuario;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}

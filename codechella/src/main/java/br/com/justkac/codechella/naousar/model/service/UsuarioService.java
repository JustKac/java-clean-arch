package br.com.justkac.codechella.naousar.model.service;

import java.util.List;

import br.com.justkac.codechella.naousar.model.entity.Usuario;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}

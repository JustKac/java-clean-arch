package br.com.justkac.codechella.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.justkac.codechella.model.entity.Usuario;
import br.com.justkac.codechella.model.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }
}

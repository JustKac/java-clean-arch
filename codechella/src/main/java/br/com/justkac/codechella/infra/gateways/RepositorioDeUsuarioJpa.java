package br.com.justkac.codechella.infra.gateways;

import java.util.List;
import java.util.Optional;

import br.com.justkac.codechella.application.gateways.RepositorioDeUsuario;
import br.com.justkac.codechella.domain.entities.usuario.Usuario;
import br.com.justkac.codechella.infra.persistence.UsuarioEntity;
import br.com.justkac.codechella.infra.persistence.UsuarioRepository;
import jakarta.transaction.Transactional;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repositorio;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper) {
        this.repositorio = repositorio;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = mapper.toEntity(usuario);
        repositorio.save(usuarioEntity);
        return mapper.toDomain(usuarioEntity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repositorio.findAll().stream()
            .map(mapper::toDomain)
            .toList(); // Java 16 or later
    }

    @Override
    @Transactional
    public Usuario alteraUsuario(String cpf, Usuario usuario) {
        Optional<UsuarioEntity> entity = repositorio.findByCpf(cpf);
        if (entity.isPresent()) {
            UsuarioEntity usuarioEncontrado = entity.get();
            var atualizado = mapper.toEntity(usuario);
            atualizado.setId(usuarioEncontrado.getId());
            repositorio.save(atualizado);
            return mapper.toDomain(atualizado);
        }
        return null;
    }

    @Override
    @Transactional
    public void excluiUsuario(String cpf) {
        Optional<UsuarioEntity> entity = repositorio.findByCpf(cpf);
        entity.ifPresent(repositorio::delete);
    }

}

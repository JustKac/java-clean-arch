package br.com.justkac.codechella.infra.gateways;

import br.com.justkac.codechella.domain.entities.usuario.Usuario;
import br.com.justkac.codechella.infra.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario) {
        return new UsuarioEntity(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity usuarioEntity) {
        return new Usuario(usuarioEntity.getCpf(), usuarioEntity.getNome(), usuarioEntity.getNascimento(), usuarioEntity.getEmail());
    }
}

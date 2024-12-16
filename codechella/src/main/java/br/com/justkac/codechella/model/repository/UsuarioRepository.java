package br.com.justkac.codechella.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.justkac.codechella.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
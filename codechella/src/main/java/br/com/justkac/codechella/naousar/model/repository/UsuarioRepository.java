package br.com.justkac.codechella.naousar.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.justkac.codechella.naousar.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
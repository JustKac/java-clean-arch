package br.com.justkac.codechella.infra.controller;

import java.time.LocalDate;

public record UsuarioDTO(
    String cpf, 
    String nome, 
    LocalDate nascimento, 
    String email
    ) {

}
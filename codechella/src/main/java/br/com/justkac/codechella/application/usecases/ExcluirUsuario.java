package br.com.justkac.codechella.application.usecases;

import br.com.justkac.codechella.application.gateways.RepositorioDeUsuario;

public class ExcluirUsuario {
    
    private final RepositorioDeUsuario repositorio;

    public ExcluirUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public void excluirUsuario(String cpf) {
        repositorio.excluiUsuario(cpf);
    }
}
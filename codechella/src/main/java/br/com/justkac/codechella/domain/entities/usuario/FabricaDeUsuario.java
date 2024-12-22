package br.com.justkac.codechella.domain.entities.usuario;

import java.time.LocalDate;

import br.com.justkac.codechella.domain.Endereco;

public class FabricaDeUsuario {

    private Usuario usuario;

    public Usuario comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento) {
        usuario = new Usuario(cpf, nome, nascimento, "");
        return this.usuario;
    }

    public Usuario incluiEndereco(String cep, Integer numero, String complemento) {
        usuario.setEndereco(new Endereco(cep, numero, complemento));
        return this.usuario;
    }
}

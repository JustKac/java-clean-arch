package br.com.justkac.codechella.domain.entities.usuario;

import java.time.LocalDate;

import br.com.justkac.codechella.domain.Endereco;

public class FabricaDeUsuario {

    private Usuario usuario;

    public Usuario comNomeCpfNascimentoEmail(String nome, String cpf, LocalDate nascimento, String email) {
        usuario = new Usuario(cpf, nome, nascimento, email);
        return this.usuario;
    }

    public Usuario incluiEndereco(String cep, Integer numero, String complemento) {
        usuario.setEndereco(new Endereco(cep, numero, complemento));
        return this.usuario;
    }
}

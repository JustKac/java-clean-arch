package br.com.justkac.codechella.domain.entities.usuario;

import java.time.LocalDate;
import java.time.Period;

import br.com.justkac.codechella.domain.Endereco;

public class Usuario {

    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;

    private Endereco endereco;

    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {

        // Verifica se o CPF é nulo ou não possui o formato esperado e lança uma exceção se for
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("CPF inválido");
        }

        // Calcula a idade com base na data de nascimento e a data atual
        int idade = Period.between(nascimento, LocalDate.now()).getYears();

        // Verifica se a idade é inferior a 18 anos e lança uma exceção se for
        if (idade < 18) {
            throw new IllegalArgumentException("Usuário deve ter pelo menos 18 anos de idade!");
        }

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

        // Verifica se o e-mail é nulo ou não possui o formato esperado e lança uma exceção se for
        if (email == null || !email.matches(emailRegex)) {
            throw new IllegalArgumentException("E-mail inválido");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

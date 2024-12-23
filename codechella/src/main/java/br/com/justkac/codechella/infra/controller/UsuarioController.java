package br.com.justkac.codechella.infra.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.justkac.codechella.application.usecases.CriarUsuario;
import br.com.justkac.codechella.application.usecases.ListarUsuarios;
import br.com.justkac.codechella.domain.entities.usuario.Usuario;



@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;

    private final ListarUsuarios listarUsuarios;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
    }

    @PostMapping
    public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioDTO dto) {
        Usuario usuarioSalvo = criarUsuario.cadastrarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UsuarioDTO(usuarioSalvo.getCpf(), usuarioSalvo.getNome(), usuarioSalvo.getNascimento(), usuarioSalvo.getEmail());
    }

    @GetMapping()
    public List<UsuarioDTO> listarUsuarios() {
        return listarUsuarios.obterTodosUsuarios().stream()
            .map(usuario -> new UsuarioDTO(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail()))
            .toList(); // Java 16 or later
    }
    
    
}

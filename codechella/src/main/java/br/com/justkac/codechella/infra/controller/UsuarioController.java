package br.com.justkac.codechella.infra.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.justkac.codechella.application.usecases.AlterarUsuario;
import br.com.justkac.codechella.application.usecases.CriarUsuario;
import br.com.justkac.codechella.application.usecases.ExcluirUsuario;
import br.com.justkac.codechella.application.usecases.ListarUsuarios;
import br.com.justkac.codechella.domain.entities.usuario.Usuario;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;

    private final ListarUsuarios listarUsuarios;

    private final AlterarUsuario alteraUsuario;

    private final ExcluirUsuario excluiUsuario;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios, AlterarUsuario alteraUsuario, ExcluirUsuario excluiUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.alteraUsuario = alteraUsuario;
        this.excluiUsuario = excluiUsuario;
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

    @PutMapping("/{cpf}")
    public UsuarioDTO atualizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDTO dto) {
        Usuario atualizado = alteraUsuario.alteraDadosUsuario(cpf,new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UsuarioDTO(atualizado.getCpf(), atualizado.getNome(), atualizado.getNascimento(),atualizado.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void excluirUsuario(@PathVariable String cpf) {
        excluiUsuario.excluirUsuario(cpf);
    }

}

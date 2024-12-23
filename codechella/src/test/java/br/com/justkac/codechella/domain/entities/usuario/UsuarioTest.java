package br.com.justkac.codechella.domain.entities.usuario;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-00", "Fulano", LocalDate.parse("2000-01-01"), "dev@dev.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Fulano", LocalDate.parse("2000-01-01"), "dev@dev.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(null, "Fulano", LocalDate.parse("2000-01-01"), "dev@dev.com"));

    }

    @Test
    public void naoDeveCadastrarUsuarioComIdadeInferiorA18Anos() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456.789-00", "Fulano", LocalDate.parse("2020-01-01"), "dev@dev.com"));
    }

    @Test
    public void naoDeveCadastrarUsuarioComEmailInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456.789-00", "Fulano", LocalDate.parse("2000-01-01"), "dev@dev"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456.789-00", "Fulano", LocalDate.parse("2000-01-01"), "dev@dev."));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456.789-00", "Fulano", LocalDate.parse("2000-01-01"), "dev@dev.c"));
    }
    
    @Test
    public void deveCriarUsuarioUsandoFabridaDeUsuarii() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimentoEmail("Fulano", "123.456.789-00", LocalDate.parse("2000-01-01"), "dev@dev.com");

        Assertions.assertEquals("Fulano", usuario.getNome());
        Assertions.assertEquals("123.456.789-00", usuario.getCpf());
        Assertions.assertEquals(LocalDate.parse("2000-01-01"), usuario.getNascimento());

        usuario = fabrica.incluiEndereco("12345-678", 123, "Casa");
        
        Assertions.assertEquals("12345-678", usuario.getEndereco().getCep());
        Assertions.assertEquals(123, usuario.getEndereco().getNumero());
        Assertions.assertEquals("Casa", usuario.getEndereco().getComplemento());
    }

}

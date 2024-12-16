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

}

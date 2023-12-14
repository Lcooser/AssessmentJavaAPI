package test;// ServiceTest.java
import dto.UsuarioDTOInput;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.UsuarioService;




public class UsuarioServiceTest {

    @Test
    public void testInsercao() {
        UsuarioService usuarioService = new UsuarioService();
        UsuarioDTOInput usuarioDTOInput = new UsuarioDTOInput();
        usuarioDTOInput.setNome("John Doe");
        usuarioDTOInput.setSenha("password");

        usuarioService.inserir(usuarioDTOInput);

        Assertions.assertEquals(1, usuarioService.listar().size());
    }
}

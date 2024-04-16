import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestFilme {
    @Test
    public void testeCadastrarFuncionario(){

        Filme filme = new Filme("MAP", 2024);
        assertTrue(filme.cadastrarFuncionario("SABRINA", new ArrayList<>(List.of("Diretor", "Roteirista", "Ator"))));
        assertFalse(filme.cadastrarFuncionario("SABRINA", new ArrayList<>(List.of("Diretor", "Roteirista", "Ator"))));
    }
}

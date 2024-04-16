import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TesteGloboFilme {
    static GloboFilmes globoFilmes;
    static GloboFilmes filmeteste;

    @BeforeAll
    public static void setUp() {
        globoFilmes = new GloboFilmes();
        globoFilmes.cadastrarFilme("FILME 1", 2000, Map.ofEntries(
                        Map.entry("John G. Avildsen PESSOA 1", new ArrayList<>(List.of("Diretor"))),
                        Map.entry("Sylvester Stallone PESSOA 2", new ArrayList<>(List.of("Roteirista", "Ator"))),
                        Map.entry("Talia Shire PESSOA 3", new ArrayList<>(List.of("Ator"))),
                        Map.entry("Carl Weathers PESSOA 4", new ArrayList<>(List.of("Ator"))),
                        Map.entry("Garrett Brown PESSOA 5", new ArrayList<>(List.of("Cinegrafista")))),
                new ArrayList<>(List.of("MUSICA 1", "MUSICA 2", "MUSICA 3")));

        filmeteste = new GloboFilmes();
        filmeteste.cadastrarFilme("FILME 2", 2001, Map.ofEntries(
                        Map.entry("PESSOA 1", new ArrayList<>(List.of("Diretor"))),
                        Map.entry("PESSOA 2", new ArrayList<>(List.of("Roteirista", "Ator"))),
                        Map.entry("PESSOA 3", new ArrayList<>(List.of("Ator"))),
                        Map.entry("PESSOA 4", new ArrayList<>(List.of("Ator"))),
                        Map.entry("PESSOA 5", new ArrayList<>(List.of("Cinegrafista")))),
                new ArrayList<>(List.of("MUSICA 1", "MUSICA 2", "MUSICA 3")));
    }

    @Test
    public void testeCadastrarFilmeFail() {

        assertFalse(globoFilmes.cadastrarFilme("FILME 1", 2000, Map.ofEntries(
                        Map.entry("PESSOA 1", new ArrayList<>(List.of("Diretor"))),
                        Map.entry("PESSOA 2", new ArrayList<>(List.of("Roteirista", "Ator"))),
                        Map.entry("PESSOA 3", new ArrayList<>(List.of("Ator"))),
                        Map.entry("PESSOA 4", new ArrayList<>(List.of("Ator"))),
                        Map.entry("PESSOA 5", new ArrayList<>(List.of("Cinegrafista")))),
                new ArrayList<>(List.of("MUSICA 1", "MUSICA 2", "MUSICA 3"))));

    }

    @Test
    public void testeCadastrarFilmeSucess() {

        assertTrue(globoFilmes.cadastrarFilme("FILME 3", 2002, Map.ofEntries(
                        Map.entry("PESSOA 2", new ArrayList<>(List.of("Diretor", "Roteirista", "Ator"))),
                        Map.entry("PESSOA 3", new ArrayList<>(List.of("Ator"))),
                        Map.entry("PESSOA 4", new ArrayList<>(List.of("Ator"))),
                        Map.entry("PESSOA 6", new ArrayList<>(List.of("Cinegrafista")))),
                new ArrayList<>(List.of("MUSICA 1", "MUSICA 2", "MUSICA 3"))));
    }

    @Test
    public void testeMostrarFilmeEquals() throws ExceptionFilmeNaoExsite{
        assertEquals(globoFilmes.mostrarInformacoesFilme("FILME 1"), filmeteste.mostrarInformacoesFilme("FILME 1"));
    }

    @Test
    public void mostrarFilmografia(){
        assertEquals(filmeteste.mostrarFilmografia("PESSOA 4", "Ator"), globoFilmes.mostrarFilmografia("PESSOA 4", "Ator"));
    }

    @Test
    public void lancarExceptionFilme(){
        assertThrows(ExceptionFilmeNaoExsite.class, () -> {
            globoFilmes.mostrarInformacoesFilme("FILME 4");
        });
    }
}

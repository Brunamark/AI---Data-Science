

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.lpm.business.Genero;
import br.lpm.business.Pessoa;

public class PessoaTest {

    public static Pessoa pessoa;
    
    @BeforeEach
    public void setUp() throws Exception{
        pessoa = new Pessoa();
    }


    @Test
    void testSetGenero() {
        pessoa.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, pessoa.getGenero());
    }

    @Test
    void testSetName() {
        pessoa.setNome("Mikael Muniz");
        assertEquals("Mikael Muniz", pessoa.getNome(), "Atribuição de nome válido");
        pessoa.setNome("Mikael 123");
        assertEquals("undefined", pessoa.getNome(), "Atribuição de nome inválido");
        pessoa.setNome("Mikael");
        assertEquals("undefined", pessoa.getNome(), "Atribuição de nome inválido");
    }

    @Test
    void testSetData(){
        pessoa.setDataNascimento(LocalDate.of(2024, 8, 24));
        assertEquals(LocalDate.of(2024, 8, 24), pessoa.getDataNascimento(), "Atribuição válida");
        pessoa.setDataNascimento(LocalDate.of(2024, 12, 26 ));
        assertEquals(LocalDate.of(1,1,1), pessoa.getDataNascimento(), "Atribuição inválida");

    }
    @Test
    void testSetAltura(){
        pessoa.setAltura(1.80f);
        assertEquals(1.80f, pessoa.getAltura(), "Atribuição válida");
        pessoa.setAltura(-1.2f);
        assertEquals(0.01f, pessoa.getAltura(), "Atribuição inválida");
        pessoa.setAltura(2.61f);
        assertEquals(0.01f, pessoa.getAltura(), "Atribuição inválida");
    }

    @Test
    void testSetPeso(){
        pessoa.setPeso(65);
        assertEquals(65, pessoa.getPeso(), "Atribuição válida");
        pessoa.setPeso(-2);
        assertEquals(1, pessoa.getPeso(), "Atribuição inválida");
        pessoa.setPeso(601);
        assertEquals(1, pessoa.getPeso(), "Atribuição inválida");
    }


    @Test
    void testSetRenda(){
        pessoa.setRenda(0);
        assertEquals(0, pessoa.getRenda(), "Atribuição válida");
        pessoa.setRenda(-1.0f);
        assertEquals(0.01f, pessoa.getRenda(), "Atribuição inválida");
        
    }

    @Test
    void testSetNaturalidade(){
        pessoa.setNaturalidade("Guarulhos");
        assertEquals("Guarulhos", pessoa.getNaturalidade(), "Atribuição válida");
        pessoa.setNaturalidade("Minas Gerais");
        assertEquals("Minas Gerais", pessoa.getNaturalidade(), "Atribuição válida");
        pessoa.setNaturalidade(" ");
        assertEquals("undefined", pessoa.getNaturalidade(), "Atribuição válida");

    }
}

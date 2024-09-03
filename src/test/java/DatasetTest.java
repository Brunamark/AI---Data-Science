import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.lpm.business.Dataset;
import br.lpm.business.Escolaridade;
import br.lpm.business.EstadoCivil;
import br.lpm.business.Genero;
import br.lpm.business.Hobby;
import br.lpm.business.Moradia;
import br.lpm.business.Pessoa;

public class DatasetTest {

    public Dataset dataset;
    public static Pessoa pessoa1;
    public static Pessoa pessoa2;

    @BeforeEach
    public void setUp() throws Exception {
        dataset = new Dataset();
        pessoa1 = new Pessoa("Mikael", LocalDate.of(2001, 1, 17), Genero.MASCULINO, 1.80f, 65, 3000,
                "SP", Hobby.GAME, EstadoCivil.SOLTEIRO, Escolaridade.SUPERIOR, true,
                Moradia.COM_FAMILIA);
        pessoa2 = new Pessoa("Barbara", LocalDate.of(2002, 1, 22), Genero.FEMININO, 1.60f, 58, 2000,
                "MG", Hobby.CULINARIA, EstadoCivil.SOLTEIRO, Escolaridade.SUPERIOR, true,
                Moradia.COM_FAMILIA);
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
    }

    private int getNumPessoas(Pessoa[] pessoas) {
        int contPessoa = 0;
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null && pessoa.getNome() != null) {
                contPessoa++;
            }
        }
        return contPessoa;
    }

    @Test
    void testAddPessoa() {

        Pessoa[] pessoas = dataset.getAll();
        assertEquals(2, getNumPessoas(pessoas), "Valor valido de pessoa");
    }

    @Test
    void testAvgAltura() {

        assertEquals(1.7f, dataset.avgAltura(), "Valor valido de altura");

    }

    @Test
    void testAvgPeso() {

        assertEquals(62, dataset.avgPeso(), "Valor valido de altura");

    }

    @Test
    void testGetAll() {

        Pessoa[] pessoas = dataset.getAll();
        assertEquals(pessoa1, pessoas[0], "Valor valido de pessoas");
        assertEquals(pessoa2, pessoas[1], "Valor valido de pessoas");

    }

    @Test
    void testGetPessoaByName() {

    
        assertEquals("Mikael", dataset.getPessoaByName("mikael"), "Valor valido de pessoa");

    }

    @Test
    void testMaxAltura() {
        fail("Not yet implemented");

    }

    @Test
    void testMaxPeso() {
        fail("Not yet implemented");

    }

    @Test
    void testMinAltura() {
        fail("Not yet implemented");

    }

    @Test
    void testMinPeso() {
        fail("Not yet implemented");

    }

    @Test
    void testModeEscolaridade() {
        fail("Not yet implemented");

    }

    @Test
    void testModeEstadoCivil() {
        fail("Not yet implemented");

    }

    @Test
    void testModeMoradia() {
        fail("Not yet implemented");

    }

    @Test
    void testPercentAdult() {
        fail("Not yet implemented");

    }

    @Test
    void testPercentEscolaridade() {
        fail("Not yet implemented");

    }

    @Test
    void testPercentEstadoCivil() {
        fail("Not yet implemented");

    }

    @Test
    void testPercentFeliz() {
        fail("Not yet implemented");

    }

    @Test
    void testPercentHobby() {
        fail("Not yet implemented");

    }

    @Test
    void testPercentMoradia() {
        fail("Not yet implemented");

    }

    @Test
    void testRemoveAll() {
        fail("Not yet implemented");

    }

    @Test
    void testRemovePessoa() {
        fail("Not yet implemented");

    }

    @Test
    void testRemovePessoaByName() {
        fail("Not yet implemented");

    }

    @Test
    void testReplacePessoa() {
        fail("Not yet implemented");

    }

    @Test
    void testSize() {
        fail("Not yet implemented");

    }
}

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
    public static Pessoa pessoa3;
    public static Pessoa pessoa4;
    public static Pessoa pessoa5;



    @BeforeEach
    public void setUp() throws Exception {
        dataset = new Dataset();
        pessoa1 = new Pessoa("Mikael", LocalDate.of(2001, 1, 17), Genero.MASCULINO, 1.80f, 65, 3000,
                "SP", Hobby.GAME, EstadoCivil.SOLTEIRO, Escolaridade.SUPERIOR, true,
                Moradia.COM_FAMILIA);
        pessoa2 = new Pessoa("Barbara", LocalDate.of(2002, 1, 22), Genero.FEMININO, 1.60f, 58, 2000,
                "MG", Hobby.CULINARIA, EstadoCivil.SOLTEIRO, Escolaridade.SUPERIOR, true,
                Moradia.COM_FAMILIA);
        pessoa3 = new Pessoa("Raphael", LocalDate.of(1996, 6, 7), Genero.MASCULINO, 1.72f, 80, 5000,
                "MG", Hobby.GAME, EstadoCivil.CASADO, Escolaridade.MEDIO, false, Moradia.ALUGUEL);
        pessoa4 = new Pessoa("Ana", LocalDate.of(2023, 10, 15), Genero.FEMININO, 1.65f, 63, 1200,
                "GO", Hobby.ARTE, EstadoCivil.VIUVO, Escolaridade.NENHUMA, true,
                Moradia.COM_FAMILIA);
        pessoa5 = new Pessoa("Mikael", LocalDate.of(2001, 1, 17), Genero.MASCULINO, 1.80f, 65, 3000,
                "SP", Hobby.GAME, EstadoCivil.SOLTEIRO, Escolaridade.SUPERIOR, true,
                Moradia.COM_FAMILIA);
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa4);

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
        assertEquals(4, getNumPessoas(pessoas), "Valor valido de pessoa");
    }

    @Test
    void testAvgAltura() {
        float delta = 0.01f;
        assertEquals(1.69f, dataset.avgAltura(), delta, "Valor valido de altura");

    }

    @Test
    void testAvgPeso() {

        assertEquals(67, dataset.avgPeso(), "Valor valido de altura");

    }

    @Test
    void testGetAll() {

        Pessoa[] pessoas = dataset.getAll();
        assertEquals(pessoa1, pessoas[0], "Valor valido de pessoas");
        assertEquals(pessoa2, pessoas[1], "Valor valido de pessoas");
        assertEquals(pessoa3, pessoas[2], "Valor valido de pessoas");
        assertEquals(pessoa4, pessoas[3], "Valor valido de pessoas");


    }

    @Test
    void testGetPessoaByName() {


        assertEquals("Mikael", dataset.getPessoaByName("mikael"), "Valor valido de pessoa");

    }

    @Test
    void testMaxAltura() {
        assertEquals(1.80f, dataset.maxAltura(), "Valor valido para altura maxima");
    }

    @Test
    void testMinAltura() {
        assertEquals(1.60f, dataset.minAltura(), "Valor valido para altura minima");

    }

    @Test
    void testMaxPeso() {
        assertEquals(80, dataset.maxPeso(), "Valor valido para peso maximo");

    }


    @Test
    void testMinPeso() {
        assertEquals(58, dataset.minPeso(), "Valor valido para peso minimo");

    }

    @Test
    void testModeEscolaridade() {
        assertEquals(Escolaridade.SUPERIOR, dataset.modeEscolaridade(),
                "Valor valido para moda escolaridade");

    }

    @Test
    void testModeEstadoCivil() {
        assertEquals(EstadoCivil.SOLTEIRO, dataset.modeEstadoCivil(),
                "Valor valido para moda estado civil");

    }

    @Test
    void testModeMoradia() {
        assertEquals(Moradia.COM_FAMILIA, dataset.modeMoradia(), "Valor valido para moda moradia");

    }

    @Test
    void testPercentAdult() {
        assertEquals(80f, dataset.percentAdult(), "Valor valido para porcentagem adulto");

    }

    @Test
    void testPercentEscolaridade() {
        assertEquals(50f, dataset.percentEscolaridade(Escolaridade.SUPERIOR),
                "Valor valido para porcentagem escolaridade");

    }

    @Test
    void testPercentEstadoCivil() {
        assertEquals(25f, dataset.percentEstadoCivil(EstadoCivil.VIUVO),
                "Valor valido para porcentagem estado civil");
    }

    @Test
    void testPercentMoradia() {
        assertEquals(25f, dataset.percentEstadoCivil(EstadoCivil.VIUVO),
                "Valor valido para porcentagem moradia");

    }

    @Test
    void testPercentHobby() {
        assertEquals(50f, dataset.percentHobby(Hobby.GAME), "Valor valido para porcentagem hobby");

    }


    @Test
    void testPercentFeliz() {
        assertEquals(75f, dataset.percentFeliz(), "Valor valido para porcentagem feliz");

    }



    @Test
    void testReplacePessoa() {
        Pessoa[] pessoasAntes = dataset.getAll();
        dataset.replacePessoa(pessoa4, pessoa5);


        assertEquals(pessoa5, pessoasAntes[3], "Valor valido para alterar pessoa");

    }

    @Test
    void testSize() {

        assertEquals(4, dataset.size(), "Valor valido para tamanho");

    }

    @Test
    void testRemovePessoaByName() {
        
        dataset.removePessoaByName("Barbara");
        assertEquals(3, dataset.size(), "Valor valido para remocao");
       

    }

    @Test
    void testRemovePessoa() {
        dataset.removePessoa(pessoa2);
        assertEquals(3, dataset.size(), "Valor valido para remocao por pessoa");

    }

    @Test
    void testRemoveAll() {
        dataset.removeAll();
        assertEquals(0, dataset.size(), "Valor valido para remocao total");
    }



}

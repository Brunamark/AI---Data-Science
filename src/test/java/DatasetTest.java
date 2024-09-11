import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.lpm.business.Dataset;
import br.lpm.business.DistanceMeasure;
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
    public static Pessoa pessoa6;

    public DistanceMeasure distanceMeasure;



    @BeforeEach
    public void setUp() throws Exception {
        dataset = new Dataset();
        distanceMeasure = new DistanceMeasure(dataset);

        pessoa1 = new Pessoa("Mikael Muniz", LocalDate.of(2001, 1, 17), Genero.MASCULINO, 1.80f, 65,
                3000, "SP", Hobby.GAME, EstadoCivil.SOLTEIRO, Escolaridade.SUPERIOR, true,
                Moradia.COM_FAMILIA);
        pessoa2 = new Pessoa("Barbara Costa", LocalDate.of(2002, 1, 22), Genero.FEMININO, 1.60f, 58,
                2000, "MG", Hobby.CULINARIA, EstadoCivil.SOLTEIRO, Escolaridade.SUPERIOR, true,
                Moradia.COM_FAMILIA);
        pessoa3 = new Pessoa("Raphael Henrique", LocalDate.of(1996, 6, 7), Genero.MASCULINO, 1.72f,
                80, 5000, "MG", Hobby.GAME, EstadoCivil.CASADO, Escolaridade.MEDIO, false,
                Moradia.ALUGUEL);
        pessoa4 = new Pessoa("Ana Machado", LocalDate.of(2023, 10, 15), Genero.FEMININO, 1.65f, 63,
                1200, "GO", Hobby.ARTE, EstadoCivil.VIUVO, Escolaridade.NENHUMA, true,
                Moradia.COM_FAMILIA);
        pessoa5 = new Pessoa("Pedro Henrique", LocalDate.of(1995, 3, 25), Genero.MASCULINO, 1.88f,
                78, 1500, "PR", Hobby.LIVRO, EstadoCivil.CASADO, Escolaridade.POS_GRADUACAO, false,
                Moradia.COM_FAMILIA);
        pessoa6 = new Pessoa("Dante Miguel", LocalDate.of(2001, 1, 17), Genero.MASCULINO, 1.75f, 68,
                2800, "SP", Hobby.GAME, EstadoCivil.SOLTEIRO, Escolaridade.POS_GRADUACAO, true,
                Moradia.COM_FAMILIA);
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa4);

    }

    @Test
    void testAddPessoa() {
        dataset.addPessoa(pessoa5);

        Pessoa[] pessoas = dataset.getAll();
        assertEquals(5, dataset.size(), "Valor valido de pessoa");
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

        assertEquals(pessoa1, dataset.getPessoaByName("Mikael Muniz"), "Valor valido de pessoa");

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
    void testMaxRenda() {
        assertEquals(5000, dataset.maxRenda(), 0.01f, "Valor valido para maxima renda");
    }

    @Test
    void testMinRenda() {
        assertEquals(1200, dataset.minRenda(), 0.01f, "Valor valido para minima renda");
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
        assertEquals(75f, dataset.percentAdult(), "Valor valido para porcentagem adulto");

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

        dataset.removePessoaByName(pessoa2.getNome());
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

    @Test
    void testNormalizeField() {
        dataset.addPessoa(pessoa5);

        dataset.normalizeField("altura");
        dataset.normalizeField("peso");
        dataset.normalizeField("renda");
        assertEquals(0.71f, dataset.getPessoaByName("Mikael Muniz").getAltura(), 0.01f,
                "Valor valido para altura");
        assertEquals(0.32f, dataset.getPessoaByName("Mikael Muniz").getPeso(), 0.01f,
                "Valor valido para peso");
        assertEquals(0.47f, dataset.getPessoaByName("Mikael Muniz").getRenda(), 0.01f,
                "Valor valido para renda");

        assertEquals(0, dataset.getPessoaByName("Barbara Costa").getAltura(), 0.01f,
                "Valor valido para altura");
        assertEquals(0, dataset.getPessoaByName("Barbara Costa").getPeso(), 0.01f,
                "Valor valido para peso");
        assertEquals(0.21f, dataset.getPessoaByName("Barbara Costa").getRenda(), 0.01f,
                "Valor valido para renda");

    }

    @Test
    void testcalcDistanceVector() {
        dataset.addPessoa(pessoa5);

        dataset.normalizeField("altura");
        dataset.normalizeField("peso");
        dataset.normalizeField("renda");
        double[] distanceVector = dataset.calcDistanceVector(pessoa1);

        assertEquals(distanceVector[0], distanceMeasure.calcDistance(pessoa1, pessoa1),
                "Valor valido para distancia vetor");
        assertEquals(distanceVector[1], distanceMeasure.calcDistance(pessoa1, pessoa2),
                "Valor valido para distancia vetor");
        assertEquals(distanceVector[2], distanceMeasure.calcDistance(pessoa1, pessoa3),
                "Valor valido para distancia vetor");
    }

    @Test
    void testCalcDistanceMatrix() {
        dataset.addPessoa(pessoa5);

        dataset.normalizeField("altura");
        dataset.normalizeField("peso");
        dataset.normalizeField("renda");

        double[][] distances = dataset.calcDistanceMatrix();
        assertEquals(distances[0][1], distanceMeasure.calcDistance(pessoa1, pessoa2),
                "Valor valido para distancia linha 0 e coluna 1");
        assertEquals(distances[0][2], distanceMeasure.calcDistance(pessoa1, pessoa3),
                "Valor valido para distancia linha 0 e coluna 1");
        assertEquals(distances[0][3], distanceMeasure.calcDistance(pessoa1, pessoa4),
                "Valor valido para distancia linha 0 e coluna 1");

    }

    @Test
    void testGetSimilar() {
        dataset.addPessoa(pessoa5);
        dataset.addPessoa(pessoa6);


        dataset.normalizeField("altura");
        dataset.normalizeField("peso");
        dataset.normalizeField("renda");

        Pessoa[] pessoasSimilares = dataset.getSimilar(pessoa1, 1);

        assertEquals(pessoa6, pessoasSimilares[0], "Valor valido para pessoa similar");

    }

}

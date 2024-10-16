import static org.junit.jupiter.api.Assertions.*;
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
import java.time.LocalDate;


public class DistanceMeasureTest {

        public Dataset dataset;
        public static Pessoa pessoa1;
        public static Pessoa pessoa2;
        public static Pessoa pessoa3;
        public static Pessoa pessoa4;
        public static Pessoa pessoa5;
        public static Pessoa pessoa6;

        public DistanceMeasure distanceMeasure;


        @BeforeEach
        public void setUp() {
                dataset = new Dataset();
                distanceMeasure = new DistanceMeasure();

                pessoa1 = new Pessoa("Mikael Muniz", LocalDate.of(2001, 1, 17), Genero.MASCULINO,
                                1.80f, 65, 3000, "SP", Hobby.GAME, EstadoCivil.SOLTEIRO,
                                Escolaridade.SUPERIOR, true, Moradia.COM_FAMILIA);
                pessoa2 = new Pessoa("Barbara Costa", LocalDate.of(2002, 1, 22), Genero.FEMININO,
                                1.60f, 58, 2000, "MG", Hobby.CULINÁRIA, EstadoCivil.SOLTEIRO,
                                Escolaridade.SUPERIOR, true, Moradia.COM_FAMILIA);
                pessoa3 = new Pessoa("Raphael Henrique", LocalDate.of(1996, 6, 7), Genero.MASCULINO,
                                1.72f, 80, 5000, "MG", Hobby.GAME, EstadoCivil.CASADO,
                                Escolaridade.MEDIO, false, Moradia.ALUGUEL);
                pessoa4 = new Pessoa("Ana Machado", LocalDate.of(2023, 10, 15), Genero.FEMININO,
                                1.65f, 63, 1200, "GO", Hobby.ARTE, EstadoCivil.VIUVO,
                                Escolaridade.NENHUMA, true, Moradia.COM_FAMILIA);
                pessoa5 = new Pessoa("Pedro Henrique", LocalDate.of(1995, 3, 25), Genero.MASCULINO,
                                1.88f, 78, 1500, "PR", Hobby.LIVRO, EstadoCivil.CASADO,
                                Escolaridade.POS_GRADUACAO, false, Moradia.COM_FAMILIA);
                 pessoa6 = new Pessoa("Dante Miguel", LocalDate.of(2001, 1, 17),
                                Genero.MASCULINO, 1.75f, 68, 2800, "SP", Hobby.GAME,
                                EstadoCivil.SOLTEIRO, Escolaridade.POS_GRADUACAO, true,
                                Moradia.COM_FAMILIA);
                dataset.addPessoa(pessoa1);
                dataset.addPessoa(pessoa2);
                dataset.addPessoa(pessoa3);
                dataset.addPessoa(pessoa4);
                dataset.addPessoa(pessoa5);
                dataset.addPessoa(pessoa6);



        }

        @Test
        void testCalcDistance() {
         
        
                float[] alturaNormalizada = dataset.normalizeField("altura");
                float[] pesoNormalizado = dataset.normalizeField("peso");
                float[] rendaNormalizado = dataset.normalizeField("renda");
        
        
        
                
                int quantidadePessoa = dataset.size();
                Pessoa[] pessoas = dataset.getAll();
        
                for(int i=0; i<quantidadePessoa ; i++){
                    pessoas[i].setAltura(alturaNormalizada[i]);
                    pessoas[i].setPeso(pesoNormalizado[0]);
                    pessoas[i].setRenda(rendaNormalizado[0]);
                }

                assertEquals(0, distanceMeasure.calcDistance(pessoa1, pessoa1), 0.01f,
                                "Valor valido para calculo distancia");

                assertEquals(0.62f, distanceMeasure.calcDistance(pessoa1, pessoa2), 0.01f,
                                "Valor valido para calculo distancia");

                assertEquals(0.32f, distanceMeasure.calcDistance(pessoa1, pessoa6), 0.01f,
                                "Valor valido para calculo distancia");
        }
}

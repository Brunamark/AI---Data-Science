package br.lpm.main;

import br.lpm.business.Dataset;
import br.lpm.business.DistanceMeasure;
import br.lpm.business.Escolaridade;
import br.lpm.business.EstadoCivil;
import br.lpm.business.Genero;
import br.lpm.business.Hobby;
import br.lpm.business.Moradia;
import br.lpm.business.Pessoa;
import java.time.LocalDate;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.*;
import java.awt.*;


import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Main {
        public static void main(String[] args) throws Exception {
                Dataset dataset = new Dataset();
                DistanceMeasure distanceMeasure = new DistanceMeasure(dataset);

                Pessoa pessoa1 = new Pessoa("Mikael Muniz", LocalDate.of(2001, 1, 17),
                                Genero.MASCULINO, 1.80f, 65, 3000, "SP", Hobby.GAME,
                                EstadoCivil.SOLTEIRO, Escolaridade.SUPERIOR, true,
                                Moradia.COM_FAMILIA);
                Pessoa pessoa2 = new Pessoa("Barbara Costa", LocalDate.of(2002, 1, 22),
                                Genero.FEMININO, 1.60f, 58, 2000, "MG", Hobby.CULINARIA,
                                EstadoCivil.SOLTEIRO, Escolaridade.SUPERIOR, true,
                                Moradia.COM_FAMILIA);
                Pessoa pessoa3 = new Pessoa("Raphael Henrique", LocalDate.of(1996, 6, 7),
                                Genero.MASCULINO, 1.72f, 80, 5000, "MG", Hobby.GAME,
                                EstadoCivil.CASADO, Escolaridade.MEDIO, false, Moradia.ALUGUEL);
                Pessoa pessoa4 = new Pessoa("Ana Machado", LocalDate.of(2023, 10, 15),
                                Genero.FEMININO, 1.65f, 63, 1200, "GO", Hobby.ARTE,
                                EstadoCivil.VIUVO, Escolaridade.NENHUMA, true, Moradia.COM_FAMILIA);
                Pessoa pessoa5 = new Pessoa("Pedro Henrique", LocalDate.of(1995, 3, 25),
                                Genero.MASCULINO, 1.88f, 78, 1500, "PR", Hobby.LIVRO,
                                EstadoCivil.CASADO, Escolaridade.POS_GRADUACAO, false,
                                Moradia.COM_FAMILIA);
                Pessoa pessoa6 = new Pessoa("Dante Miguel", LocalDate.of(2001, 1, 17),
                                Genero.MASCULINO, 1.75f, 68, 2800, "SP", Hobby.GAME,
                                EstadoCivil.SOLTEIRO, Escolaridade.POS_GRADUACAO, true,
                                Moradia.COM_FAMILIA);

                dataset.addPessoa(pessoa1);
                dataset.addPessoa(pessoa2);
                dataset.addPessoa(pessoa3);
                dataset.addPessoa(pessoa4);
                dataset.addPessoa(pessoa5);
                dataset.addPessoa(pessoa6);

                histogramFormacaoAcademica(dataset);
                pieFormacaoAcademica(dataset);

                int n = 1;
                Pessoa[] pessoasSimilares = dataset.getSimilar(pessoa1, n);
 
                for (int i = 0; i < n; i++) {

                        System.out.println("A pessoa " + pessoa1.getNome()
                                        + " possui similiraidade entre " + pessoasSimilares[i].getNome()
                                        + ", sendo a distancia igual a "
                                        + distanceMeasure.calcDistance(pessoa1,
                                                        pessoasSimilares[i]));

                }

              


        }

        private static void histogramFormacaoAcademica(Dataset dataset) {
                DefaultCategoryDataset dataSet = new DefaultCategoryDataset();


                int fundamental = 0;
                int medio = 0;
                int superior = 0;
                int posGraduacao = 0;
                int nenhuma = 0;

                for (Pessoa pessoa : dataset.getAll()) {
                        if (pessoa != null) {
                                switch (pessoa.getEscolaridade()) {
                                        case FUNDAMENTAL:
                                                fundamental++;
                                                break;
                                        case MEDIO:
                                                medio++;
                                                break;
                                        case SUPERIOR:
                                                superior++;
                                                break;
                                        case POS_GRADUACAO:
                                                posGraduacao++;
                                                break;
                                        case NENHUMA:
                                                nenhuma++;
                                                break;
                                }
                        }
                }

                dataSet.addValue(fundamental, "Escolaridade", "Fundamental");
                dataSet.addValue(medio, "Escolaridade", "Médio");
                dataSet.addValue(superior, "Escolaridade", "Superior");
                dataSet.addValue(posGraduacao, "Escolaridade", "Pós-Graduação");
                dataSet.addValue(nenhuma, "Escolaridade", "Nenhuma");

                JFreeChart chart = ChartFactory.createBarChart("Distribuição de Escolaridade",
                                "Escolaridade", "Número de Pessoas", dataSet,
                                PlotOrientation.VERTICAL, true, true, false);

                JFrame frame = new JFrame("Histograma da Formação Acadêmica");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setLayout(new BorderLayout());
                ChartPanel chartPanel = new ChartPanel(chart);
                frame.add(chartPanel, BorderLayout.CENTER);
                frame.setVisible(true);
        }

        private static void pieFormacaoAcademica(Dataset dataset) {

                DefaultPieDataset datasetPie = new DefaultPieDataset();

                for (Escolaridade escolaridade : Escolaridade.values()) {
                        float percent = dataset.percentEscolaridade(escolaridade);
                        datasetPie.setValue(escolaridade.toString(), percent);
                }

                JFreeChart pieChart = ChartFactory.createPieChart("Distribuição de Escolaridade",
                                datasetPie, datasetPie, 0, true, true, false, false, false, false);

                ChartPanel chartPanel = new ChartPanel(pieChart);
                chartPanel.setPreferredSize(new Dimension(560, 370));


                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("Gráfico de Distribuição de Escolaridade");
                frame.add(chartPanel, BorderLayout.CENTER);
                frame.pack();
                frame.setVisible(true);

        }

}

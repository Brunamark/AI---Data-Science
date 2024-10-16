package br.lpm.main;

import br.lpm.business.Dataset;
import br.lpm.business.DistanceMeasure;
import br.lpm.business.Escolaridade;
import br.lpm.business.EstadoCivil;
import br.lpm.business.Genero;
import br.lpm.business.Hobby;
import br.lpm.business.Knn;
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

                dataset.loadDataFromCSV("src/main/java/br/lpm/resources/data/cadastro-pessoas.csv");

                float[] alturaNormalizada = dataset.normalizeField("altura");
                float[] pesoNormalizado = dataset.normalizeField("peso");
                float[] rendaNormalizado = dataset.normalizeField("renda");



                int quantidadePessoa = dataset.size();
                Pessoa[] pessoas = dataset.getAll();

                for (int i = 0; i < quantidadePessoa; i++) {
                        pessoas[i].setAltura(alturaNormalizada[i]);
                        pessoas[i].setPeso(pesoNormalizado[0]);
                        pessoas[i].setRenda(rendaNormalizado[0]);
                }
                Knn knn = new Knn(dataset, 3);
                System.out.println("Pessoa" + pessoas[0] + " eh feliz?" + knn.classifyFeliz(pessoas[0]));
                histogramFormacaoAcademica(dataset);
                pieFormacaoAcademica(dataset);



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

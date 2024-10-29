package br.lpm.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;


public class Dataset {



    private List<DataPoint> dataPoints;
    private List<String> attributeNames;
    private String stateName;


    public Dataset() {
        this.dataPoints = new ArrayList<>();
        this.attributeNames = new ArrayList<>();
    }

    public List<DataPoint> getDataPoints() {
        return this.dataPoints;
    }

    public int getLength() {
        return this.dataPoints.size();
    }

    public List<String> getAttributeNames() {
        return this.attributeNames;
    }

    public String getStateName() {
        return this.stateName;
    }




    public void loadDataFromCSV(String filename) throws Exception {

        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename))) {

            // Lê os nomes dos atributos (cabeçalho)
            String line = inputFile.readLine();
            String[] dataFields = line.split(";");
            for (int i = 0; i < dataFields.length - 1; i++) {
                this.attributeNames.add(dataFields[i].trim());
            }
            this.stateName = dataFields[dataFields.length - 1];
            line = inputFile.readLine();

            while (line != null) {
                dataFields = line.split(";");
                DataPoint dp = new DataPoint();
             
                for (int i = 0; i < dataFields.length - 1; i++) {
                    dp.addAttribute(new Attribute(dp.parse(dataFields[i].trim())));
                }

                dp.setState(dataFields[dataFields.length - 1].trim());

                this.dataPoints.add(dp);

                line = inputFile.readLine();
            }

        } catch (IOException e) {

        }

    }
    @Override
  public String toString() {
    StringBuffer output = new StringBuffer();
    output.append("[\n");

    output.append("[");
    for (String names: this.attributeNames) {
      output.append(names + ", ");
    }
    output.append(this.stateName);
    output.append("]\n");
    
    for (DataPoint dp: this.dataPoints) {
      output.append(dp + "\n");
    }
    
    
    output.append("]\n");
    return output.toString();
  }


}

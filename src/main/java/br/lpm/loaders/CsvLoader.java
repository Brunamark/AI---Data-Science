package br.lpm.loaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.lpm.data_structures.DataPoint;
import br.lpm.data_structures.Dataset;
import br.lpm.data_structures.Attribute;

public class CsvLoader implements DataLoader {
    private String filename;
    private String delimiter;

    
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

     public CsvLoader(String filename, String delimiter){
        this.setFilename(filename);
        this.setDelimiter(delimiter);
     }
     @Override
     public void load(Dataset dataset) {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(filename))) {

            // Lê os nomes dos atributos (cabeçalho)
            String line = inputFile.readLine();
            String[] dataFields = line.split(";");
            for (int i = 0; i < dataFields.length - 1; i++) {
                dataset.getAttributeNames().add(dataFields[i].trim());
            }
            dataset.setStateName(dataFields[dataFields.length - 1]);
            line = inputFile.readLine();

            while (line != null) {
                dataFields = line.split(";");
                DataPoint dp = new DataPoint();
             
                for (int i = 0; i < dataFields.length - 1; i++) {
                    dp.addAttribute(new Attribute(dp.parse(dataFields[i].trim())));
                }

                dp.setState(dataFields[dataFields.length - 1].trim());

                dataset.getDataPoints().add(dp);
                line = inputFile.readLine();
            }

        } catch (IOException e){}
     }


}

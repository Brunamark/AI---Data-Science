package br.lpm.data_structures;


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
        return attributeNames;
      }
      
      public void setAttributeNames(List<String> attributeNames) {
        this.attributeNames = attributeNames;
      }
    
      public void setDataPoints(List<DataPoint> dataPoints) {
        this.dataPoints = dataPoints;
      }
    
     
      public String getStateName() {
        return stateName;
      }
    
      public void setStateName(String stateName) {
        this.stateName = stateName;
      }


  
    @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
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

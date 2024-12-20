package br.lpm.data_structures;
import java.util.ArrayList;
import java.util.List;


public class DataPoint {
    private List<Attribute> attributes;
    private Object state;


    public DataPoint() {
        this.attributes = new ArrayList<>(); 
    }
    public DataPoint setState(String state){
       
        this.state = state;
        return this;
    }
    public List<Attribute> getAttributes(){
        return this.attributes;
    }

    @SuppressWarnings("unchecked")
    public <T>T getState(){
        return (T) this.state;
    }

    public void addAttribute(Attribute attribute){
        this.attributes.add(attribute);
    }

    public void addAttributes(List<Attribute> attributes){
        this.attributes.addAll(attributes);
    }

    
    public Object parse(String input){
        try {
            return Integer.parseInt(input);
          } catch (Exception e) {}
          try {
            return Double.parseDouble(input);
          } catch (Exception e) {
            
          }
          if (input.equalsIgnoreCase("sim") || input.equalsIgnoreCase("true")) {
             return true;
          }
          if (input.equalsIgnoreCase("não") || input.equalsIgnoreCase("false")) {
            return false;
          }
          return input;
    }
    @Override
    public String toString() {
      StringBuilder output = new StringBuilder();
      output.append("[");
  
      for (Attribute a : this.attributes) {
          output.append(a).append(", ");
      }
      output.append(this.state);
  
      output.append("]");
      return output.toString();
    }
}

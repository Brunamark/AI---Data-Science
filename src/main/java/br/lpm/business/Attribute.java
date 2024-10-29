package br.lpm.business;

public class Attribute {
    private Object value;

    public Attribute(Object value) {
        this.value = value;
      }

    public Attribute setValue(Object value){
        this.value = value;
        return this;
    }
    @SuppressWarnings("unchecked")
    public <T> T getValue(){
        return (T) value;
    }
    @Override
    public String toString(){
        return value.toString();
    }
}

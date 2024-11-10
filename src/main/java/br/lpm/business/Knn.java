package br.lpm.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.lpm.metrics.Metric;
import br.lpm.data_structures.*;;
public abstract class Knn {
  private Dataset dataset;
  private int k;
  private Metric metric;

  public Knn(Dataset dataset, int k, Metric metric) {
      this.dataset = dataset;
      this.k = k;
      this.metric = metric;
  }
  

  public Dataset getDataset() {
    return dataset;
  }


  public void setDataset(Dataset dataset) {
    this.dataset = dataset;
  }


  public int getK() {
    return k;
  }


  public void setK(int k) {
    this.k = k;
  }


  public Metric getMetric() {
    return metric;
  }


  public void setMetric(Metric metric) {
    this.metric = metric;
  }


  public abstract Attribute predict(DataPoint testPoint);

  protected List<Double> calculateDistances(DataPoint testPoint) {
    
    List<Double> distances = new ArrayList<Double>(dataset.getLength());
  
    List<DataPoint> dpList = dataset.getDataPoints();
    for (DataPoint dp: dpList) {
      distances.add(metric.distance(dp, testPoint));
    }
    return distances;
  }

   protected List<Integer> getNearest(List<Double> distances) {

    int size = this.dataset.getLength();
    List<Integer> indices = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      indices.add(i, i);
    }

    Collections.sort(indices, Comparator.comparingDouble(i -> distances.get(i)));

    return indices;
  }
  
  
  
}

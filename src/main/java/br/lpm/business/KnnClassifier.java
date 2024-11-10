package br.lpm.business;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import br.lpm.metrics.Metric;
import br.lpm.data_structures.Attribute;
import br.lpm.data_structures.Dataset;
import br.lpm.data_structures.DataPoint;


public class KnnClassifier extends Knn {
       public KnnClassifier(Dataset dataset, int k, Metric metric) {
        super(dataset, k, metric);
    }
 

     public Attribute predict(DataPoint testPoint) {

      
        List<DataPoint> dp = getDataset().getDataPoints();
        List<Double> distances = this.calculateDistances(testPoint);

        List<Integer> indexes = this.getNearest(distances);

        Map<Object, Integer> stateCount = new HashMap<Object, Integer>();

        for (int n = 0; n < getK(); n++) {
            Integer f = stateCount.get(dp.get(indexes.get(n)).getState());
            if (f == null) {
                stateCount.put(dp.get(indexes.get(n)).getState(), 1);
            } else {
                stateCount.put(dp.get(indexes.get(n)).getState(), f++);
            }
        }

        Set<Map.Entry<Object, Integer>> states = stateCount.entrySet();

        Map.Entry<Object, Integer> winner = states.stream()
                .max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .get();

        return new Attribute(winner.getKey());
    }

}

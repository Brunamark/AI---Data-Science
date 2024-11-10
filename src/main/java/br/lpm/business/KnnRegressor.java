package br.lpm.business;

import br.lpm.metrics.Metric;
import java.util.List;
import br.lpm.data_structures.*;

public class KnnRegressor extends Knn{
    
    public KnnRegressor(Dataset dataset, int k, Metric metric) {
        super(dataset, k, metric);
    }

       public Attribute predict(DataPoint testPoint) {

       
        List<DataPoint> dp = getDataset().getDataPoints();
        List<Double> distances = this.calculateDistances(testPoint);

        List<Integer> indexes = this.getNearest(distances);

        double sumState = 0;
        for (int n = 0; n < getK(); n++) {
            sumState += (Double) ((Attribute) dp.get(indexes.get(n)).getState()).getValue();
        }

        return new Attribute(sumState / getK());
    }
}

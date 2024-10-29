package br.lpm.business;

import java.util.List;

public class FelizMetric implements Metric {

    @Override
    public double distance(DataPoint p1, DataPoint p2) {
        List<Attribute> attributesP1 = p1.getAttributes();
        List<Attribute> attributesP2 = p2.getAttributes();
        double distance = 0;
        for (int i = 0; i < attributesP1.size(); i++) {
            Object valueP1 = attributesP1.get(i).getValue();
            Object valueP2 = attributesP2.get(i).getValue();
            if (i == 3) {
                distance += Math.abs((Double) valueP1 - (Double) valueP2) / 10000.00;
              } else if (i == 4) {
                distance += Math.abs((Integer) valueP1 - (Integer) valueP2) / 70.00;
              } else {
                distance += (valueP1.equals(valueP2)) ? 0 : 1;
              }
        }
        
          return distance;
    }

}

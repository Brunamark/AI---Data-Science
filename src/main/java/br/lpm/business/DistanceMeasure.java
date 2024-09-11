package br.lpm.business;

public class DistanceMeasure {
    private Dataset dataset;

    public DistanceMeasure(Dataset dataset) {
        this.dataset = dataset;
    }

    public float calcDistance(Pessoa first, Pessoa second) {
        if (first == null || second == null) {
            return -1;
        }
        if(first.equals(second)){
            return 0;
        }
        float distanceEnumBoolean = 0;
        float distanceHeight = 0;
        float distanceWeight = 0;
        float distanceIncome = 0;
        float distance = 0;

        if (!first.getEscolaridade().equals(second.getEscolaridade())) {
            distanceEnumBoolean += 1;
        }

        if (!first.getEstadoCivil().equals(second.getEstadoCivil())) {
            distanceEnumBoolean += 1;
        }
        if (!first.getGenero().equals(second.getGenero())) {
            distanceEnumBoolean += 1;
        }
        if (!first.getHobby().equals(second.getHobby())) {
            distanceEnumBoolean += 1;
        }
        if (!first.getMoradia().equals(second.getMoradia())) {
            distanceEnumBoolean += 1;
        }
        if (!first.isFeliz() == second.isFeliz()) {
            distanceEnumBoolean += 1;
        } else {
            distanceEnumBoolean += 0;
        }

        this.dataset.normalizeField("altura");
        this.dataset.normalizeField("peso");
        this.dataset.normalizeField("renda");

        distanceHeight = first.getAltura() - second.getAltura();
        distanceWeight = first.getPeso() - second.getPeso();
        distanceIncome = first.getRenda() - second.getRenda();


        distance =
                (float) Math.sqrt((distanceEnumBoolean + distanceHeight * distanceHeight
                        + distanceWeight * distanceWeight + distanceIncome * distanceIncome) / 9);
        return distance;
    }




}

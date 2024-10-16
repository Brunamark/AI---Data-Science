package br.lpm.business;

public class Knn {
    private Dataset dataset;
    private int k;

    public Knn(Dataset dataset, int k) {
        this.dataset = dataset;
        this.k = k;
    }

    
    public boolean classifyFeliz(Pessoa pessoa) {
        int quantidadePessoa = dataset.size();
        int quantidadeFeliz = 0;
        Pessoa[] pessoasParecidas = dataset.getSimilar(pessoa, this.k);

        for (int i = 0; i < pessoasParecidas.length; i++) {
            if(pessoasParecidas[i] != null && pessoasParecidas[i].isFeliz()){
                quantidadeFeliz++;
            }      
        }
        if(quantidadeFeliz>(quantidadePessoa/2)){
            return true;
        }
        return false;
    }
  
}

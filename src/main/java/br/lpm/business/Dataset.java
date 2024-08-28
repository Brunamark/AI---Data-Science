package br.lpm.business;

public class Dataset {
    static final int MAX_PESSOAS = 1000;

    private static Pessoa[] pessoas = new Pessoa[MAX_PESSOAS];

    public void addPessoa(Pessoa pessoa) {
        // need to implement

    }

    public void removePessoa(Pessoa pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].equals(pessoa)) {
                // need to implement
            }

        }
    }

    public void removePessoaByName(String pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getNome() == pessoa) {
                // need to implement

            }
        }
    }

    public void replacePessoa(Pessoa oldPessoa, Pessoa newPessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].equals(oldPessoa)) {
                pessoas[i] = newPessoa;
            }
        }
    }

    public Pessoa getPessoaByName(String pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getNome() == pessoa) {
                return pessoas[i];
            }
        }
        return null;

    }

    public Pessoa[] getAll() {
        return pessoas;
    }

    public void removeAll() {

        for (int i = 0; i < pessoas.length; i++) {
            pessoas[i] = new Pessoa();

        }

    }

}

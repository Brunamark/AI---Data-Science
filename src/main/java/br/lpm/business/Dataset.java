package br.lpm.business;

import java.util.Objects;

public class Dataset {
    static final int MAX_PESSOAS = 1000;

    private Pessoa[] pessoas = new Pessoa[MAX_PESSOAS];

    public void addPessoa(Pessoa pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                pessoas[i] = pessoa;
                System.out.println("Adicionou");
                break;
            }
        }

    }

    public void removePessoa(Pessoa pessoa) {
        if (pessoa == null) {
            return;
        }

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i] == pessoa) {
                for (int j = i; j < pessoas.length - 1; j++) {
                    pessoas[j] = pessoas[j + 1];
                }
                pessoas[pessoas.length - 1] = null;
                return;
            }
        }
    }

    public void removePessoaByName(String nome) {

        if (nome == null) {
            return;
        }
        for (int i = 0; i < pessoas.length; i++) {

            if (pessoas[i] != null && pessoas[i].getNome().equalsIgnoreCase(nome)) {
                for (int j = i; j < pessoas.length - 1; j++) {
                    pessoas[j] = pessoas[j + 1];
                }
                pessoas[pessoas.length - 1] = null;
                return;
            }
        }

    }

    public void replacePessoa(Pessoa oldPessoa, Pessoa newPessoa) {
        if(oldPessoa == null || newPessoa == null){
            return;
        }
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].equals(oldPessoa)) {
                pessoas[i] = newPessoa;
            }
        }
    }

    public Pessoa getPessoaByName(String nome) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equalsIgnoreCase(nome)) {
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
            pessoas[i] = null;
        }
    }

    public int size() {
        int count = 0;
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                count++;
            }
        }
        return count;
    }

    public float maxAltura() {
        float menor = 0;
        float maior = 0;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                menor = pessoas[i].getAltura();
                if (maior < menor) {
                    maior = menor;
                }
            }
        }
        return maior;
    }

    public float minAltura() {
        float menor = Float.MAX_VALUE;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                float alturaAtual = pessoas[i].getAltura();
                if (alturaAtual < menor) {
                    menor = alturaAtual;
                }
            }
        }
        return (menor == Float.MAX_VALUE) ? 0 : menor;
    }

    public float avgAltura() {
        float media = 0;
        int count = 0;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                media += pessoas[i].getAltura();
                count++;
            }
        }
        return (count == 0) ? 0 : media / count;
    }

    public int maxPeso() {
        float menor = 0;
        float maior = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                menor = pessoas[i].getPeso();
                if (maior < menor) {
                    maior = menor;
                }
            }
        }
        return Math.round(maior);
    }

    public int minPeso() {
        float menor = Float.MAX_VALUE;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                float pesoAtual = pessoas[i].getPeso();
                if (pesoAtual < menor) {
                    menor = pesoAtual;
                }
            }
        }
        return Math.round(menor);
    }

    public int avgPeso() {
        float media = 0;
        int contPeso = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                media += pessoas[i].getPeso();
                contPeso++;
            }
        }
        return (contPeso == 0) ? 0 : Math.round(media / contPeso);

    }

    public float percentAdult() {
        int contagemAdulto = 0;
        int totalPessoasValidas = 0;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                totalPessoasValidas++;
                if (pessoas[i].isAdulto()) {
                    contagemAdulto++;
                }
            }
        }

        if (totalPessoasValidas == 0) {
            return 0.0f;
        }

        return ((float) contagemAdulto / totalPessoasValidas) * 100;
    }

    public float percentEstadoCivil(EstadoCivil estadoCivil) {
        int contagemEstadoCivil = 0;
        int totalEstadoCivilValidos = 0;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                totalEstadoCivilValidos++;
                if (pessoas[i].getEstadoCivil() == estadoCivil) {
                    contagemEstadoCivil++;
                }
            }
        }
        if (totalEstadoCivilValidos == 0) {
            return 0.0f;
        }

        return ((float) contagemEstadoCivil / totalEstadoCivilValidos) * 100;
    }

    public EstadoCivil modeEstadoCivil() {
        int solteiro = 0;
        int casado = 0;
        int divorciado = 0;
        int separado = 0;
        int viuvo = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getEstadoCivil() != null) {
                switch (pessoas[i].getEstadoCivil()) {
                    case SOLTEIRO:
                        solteiro++;
                        break;
                    case CASADO:
                        casado++;
                        break;
                    case DIVORCIADO:
                        divorciado++;
                        break;
                    case SEPARADO:
                        separado++;
                        break;
                    case VIUVO:
                        viuvo++;
                        break;
                }
            }
        }
        EstadoCivil modo = EstadoCivil.SOLTEIRO;
        int contagemMaxima = solteiro;

        if (casado > contagemMaxima) {
            modo = EstadoCivil.CASADO;
            contagemMaxima = casado;
        }
        if (divorciado > contagemMaxima) {
            modo = EstadoCivil.DIVORCIADO;
            contagemMaxima = divorciado;
        }
        if (separado > contagemMaxima) {
            modo = EstadoCivil.SEPARADO;
            contagemMaxima = separado;
        }
        if (viuvo > contagemMaxima) {
            modo = EstadoCivil.VIUVO;
        }

        return modo;
    }

    public float percentEscolaridade(Escolaridade escolaridade) {
        int contagemEscolaridade = 0;
        int totalEscolaridadeValidos = 0;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                totalEscolaridadeValidos++;
                if (pessoas[i].getEscolaridade() == escolaridade) {
                    contagemEscolaridade++;
                }
            }
        }
        if (totalEscolaridadeValidos == 0) {
            return 0.0f;
        }

        return ((float) contagemEscolaridade / totalEscolaridadeValidos) * 100;
    }

    public Escolaridade modeEscolaridade() {
        int fundamental = 0;
        int medio = 0;
        int superior = 0;
        int posGraduacao = 0;
        int nenhuma = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getEscolaridade() != null) {
                Escolaridade escolaridadeAtual = pessoas[i].getEscolaridade();

                switch (escolaridadeAtual) {
                    case FUNDAMENTAL:
                        fundamental++;
                        break;
                    case MEDIO:
                        medio++;
                        break;
                    case SUPERIOR:
                        superior++;
                        break;
                    case POS_GRADUACAO:
                        posGraduacao++;
                        break;
                    case NENHUMA:
                        nenhuma++;
                        break;
                }
            }

        }
        Escolaridade escolaridade = Escolaridade.FUNDAMENTAL;
        int contagemMaxima = fundamental;

        if (medio > contagemMaxima) {
            escolaridade = Escolaridade.MEDIO;
            contagemMaxima = medio;
        }
        if (superior > contagemMaxima) {
            escolaridade = Escolaridade.SUPERIOR;
            contagemMaxima = superior;
        }
        if (posGraduacao > contagemMaxima) {
            escolaridade = Escolaridade.POS_GRADUACAO;
            contagemMaxima = posGraduacao;
        }
        if (nenhuma > contagemMaxima) {
            escolaridade = Escolaridade.NENHUMA;
        }


        return escolaridade;
    }

    public float percentMoradia(Moradia moradia) {
        int contagemMoradia = 0;
        int totalMoradiaValidos = 0;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                totalMoradiaValidos++;
                if (pessoas[i].getMoradia() == moradia) {
                    contagemMoradia++;
                }
            }
        }

        if (totalMoradiaValidos == 0) {
            return 0.0f;
        }

        return ((float) contagemMoradia / totalMoradiaValidos) * 100;
    }

    public Moradia modeMoradia() {
        int aluguel = 0;
        int casaPropria = 0;
        int comFamilia = 0;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                switch (pessoas[i].getMoradia()) {
                    case ALUGUEL:
                        aluguel++;
                        break;
                    case CASA_PROPRIA:
                        casaPropria++;
                        break;
                    case COM_FAMILIA:
                        comFamilia++;
                        break;
                }
            }
        }
        Moradia moradia = Moradia.ALUGUEL;
        int contagemMaxima = aluguel;

        if (casaPropria > contagemMaxima) {
            moradia = Moradia.CASA_PROPRIA;
            contagemMaxima = casaPropria;
        }
        if (comFamilia > contagemMaxima) {
            moradia = Moradia.COM_FAMILIA;
        }

        return moradia;
    }

    public float percentHobby(Hobby hobby) {
        int contagemHobby = 0;
        int totalHobbyValidos = 0;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                totalHobbyValidos++;
                if (pessoas[i].getHobby() == hobby) {
                    contagemHobby++;
                }
            }
        }

        if (totalHobbyValidos == 0) {
            return 0.0f;
        }

        return ((float) contagemHobby / totalHobbyValidos) * 100;
    }


    public float percentFeliz() {
        int contagemFeliz = 0;
        int totalFelizValidos = 0;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                totalFelizValidos++;
                if (pessoas[i].isFeliz()) {
                    contagemFeliz++;
                }
            }
        }

        if (totalFelizValidos == 0) {
            return 0.0f;
        }

        return ((float) contagemFeliz / totalFelizValidos) * 100;
    }


}

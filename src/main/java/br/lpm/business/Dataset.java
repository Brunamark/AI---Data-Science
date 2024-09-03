package br.lpm.business;

import java.util.Objects;

public class Dataset {
    static final int MAX_PESSOAS = 1000;

    private  Pessoa[] pessoas = new Pessoa[MAX_PESSOAS];

    public  void addPessoa(Pessoa pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                pessoas[i] = pessoa;
                break;
            }
        }

    }

    public  void removePessoa(Pessoa pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && Objects.equals(pessoas[i], pessoa)) {
                pessoas[i] = new Pessoa();
            }
        }
    }

    public  void removePessoaByName(String pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && Objects.equals(pessoas[i].getNome(), pessoa)) {
                pessoas[i] = new Pessoa();
            }
        }
    }

    public  void replacePessoa(Pessoa oldPessoa, Pessoa newPessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].equals(oldPessoa)) {
                pessoas[i] = newPessoa;
            }
        }
    }
    
    public  Pessoa getPessoaByName(String pessoa) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null &&  pessoas[i].getNome().equalsIgnoreCase(pessoa)) {
                return pessoas[i];
            }
        }
        return null;
    }
    

    public  Pessoa[] getAll() {
        return pessoas;
    }

    public  void removeAll() {

        for (int i = 0; i < pessoas.length; i++) {
            pessoas[i] = new Pessoa();
        }
    }

    public  int size() {
        return pessoas.length;
    }

    public  float maxAltura() {
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

    public  float minAltura() {
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
        return menor;
    }

    public  float avgAltura() {
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

    public  int maxPeso() {
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

    public  int minPeso() {
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
        return Math.round(menor);
    }

    public  int avgPeso() {
        float media = 0;
        int contPeso = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                media += pessoas[i].getPeso();
                contPeso++;
            }
        }
        return (contPeso == 0) ? 0 : Math.round(media / contPeso) ;

    }

    public  float percentAdult() {
        int contagemAdulto = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null &&  pessoas[i].isAdulto()) {
                contagemAdulto++;
            }
        }
        return ((float) contagemAdulto / pessoas.length) * 100;
    }

    public  float percentEstadoCivil(EstadoCivil estadoCivil) {
        int contagemEstadoCivil = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getEstadoCivil() == estadoCivil) {
                contagemEstadoCivil++;
            }
        }
        return ((float) contagemEstadoCivil / pessoas.length) * 100;
    }

    public  EstadoCivil modeEstadoCivil() {
        int solteiro = 0;
        int casado = 0;
        int divorciado = 0;
        int separado = 0;
        int viuvo = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getEstadoCivil() == EstadoCivil.SOLTEIRO) {
                solteiro++;
            } else if (pessoas[i].getEstadoCivil() == EstadoCivil.CASADO) {
                casado++;
            } else if (pessoas[i].getEstadoCivil() == EstadoCivil.DIVORCIADO) {
                divorciado++;
            } else if (pessoas[i].getEstadoCivil() == EstadoCivil.SEPARADO) {
                separado++;
            } else {
                viuvo++;
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

    public  float percentEscolaridade(Escolaridade escolaridade) {
        int contagemEscolaridade = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getEscolaridade() == escolaridade) {
                contagemEscolaridade++;
            }
        }
        return ((float) contagemEscolaridade / pessoas.length) * 100;
    }


    public  Escolaridade modeEscolaridade() {
        int fundamental = 0;
        int medio = 0;
        int superior = 0;
        int posGraduacao = 0;
        int nenhuma = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getEscolaridade() == Escolaridade.FUNDAMENTAL) {
                fundamental++;
            } else if (pessoas[i].getEscolaridade() == Escolaridade.MEDIO) {
                medio++;
            } else if (pessoas[i].getEscolaridade() == Escolaridade.SUPERIOR) {
                superior++;
            } else if (pessoas[i].getEscolaridade() == Escolaridade.POS_GRADUACAO) {
                posGraduacao++;
            } else {
                nenhuma++;
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

    public  float percentMoradia(Moradia moradia) {
        int contagemMoradia = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getMoradia() == moradia) {
                contagemMoradia++;
            }
        }
        return ((float) contagemMoradia / pessoas.length) * 100;
    }

    public  Moradia modeMoradia() {
        int aluguel = 0;
        int casaPropria = 0;
        int comFamilia = 0;

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getMoradia() == Moradia.ALUGUEL) {
                aluguel++;
            } else if (pessoas[i].getMoradia() == Moradia.CASA_PROPRIA) {
                casaPropria++;
            } else {
                comFamilia++;
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

    public  float percentHobby(Hobby hobby) {
        int contagemHobby = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getHobby() == hobby) {
                contagemHobby++;
            }
        }
        return ((float) contagemHobby / pessoas.length) * 100;
    }

    public  float percentFeliz() {
        int contagemFeliz = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].isFeliz()) {
                contagemFeliz++;
            }
        }
        return ((float) contagemFeliz / pessoas.length) * 100;
    }

}

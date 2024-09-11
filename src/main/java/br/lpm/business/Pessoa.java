package br.lpm.business;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {

    static final int MAIOR_IDADE = 18;
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;
    private float altura;
    private float peso;
    private float renda;
    private String naturalidade;
    private Hobby hobby;
    private EstadoCivil estadoCivil;
    private Escolaridade escolaridade;
    private boolean feliz;
    private Moradia moradia;



    public String getNome() {
        return this.nome;
    }

    private boolean isValidWord(String word, boolean requireSpace){
        boolean hasSpace = false;
        if(word == null || word.trim().isEmpty()){
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (Character.isDigit(currentChar)) {
                return false;
            }
           
            if(Character.isWhitespace(currentChar)){
                hasSpace = true;
            }
        }
        return !requireSpace || hasSpace;
    }
    public void setNome(String nome) {
        if(isValidWord(nome, true)){
            this.nome = nome;
            return;
        }
        this.nome = "undefined";
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        LocalDate dateNow = LocalDate.now();

        if (dateNow.isAfter(dataNascimento)) {
            this.dataNascimento = dataNascimento;
            return;
        }
        this.dataNascimento = LocalDate.of(1,1,1);

    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if (altura < 2.6 && altura >= 0) {
            this.altura = altura;
            return;
        }
        this.altura = 0.01f;


    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float pesoNormalizado) {
        if (pesoNormalizado >= 0 && pesoNormalizado < 600) {
            this.peso = pesoNormalizado;
            return;
        }
        this.peso = 1;

    }

    public float getRenda() {
        return renda;
    }

    public void setRenda(float renda) {
        if (renda >= 0) {
            this.renda = renda;
            return;
        }
        this.renda = 0.01f;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        if(isValidWord(naturalidade, false)){
            this.naturalidade = naturalidade;
            return;
        }
        this.naturalidade = "undefined";
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public boolean isFeliz() {
        return feliz;
    }

    public void setFeliz(boolean feliz) {
        this.feliz = feliz;
    }

    public Moradia getMoradia() {
        return moradia;
    }

    public void setMoradia(Moradia moradia) {
        this.moradia = moradia;
    }
    public boolean isAdulto() {
        if (this.dataNascimento == null) {
            return false;
        }
        LocalDate dataAtual = LocalDate.now();
        int idade = Period.between(this.dataNascimento, dataAtual).getYears();

        return idade >= MAIOR_IDADE;
    }

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero, float altura, float peso,
            float renda, String naturalidade, Hobby hobby, EstadoCivil estadoCivil,
            Escolaridade escolaridade, boolean feliz, Moradia moradia) {
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setGenero(genero);
        this.setAltura(altura);
        this.setPeso(peso);
        this.setRenda(renda);
        this.setNaturalidade(naturalidade);
        this.setHobby(hobby);
        this.setEstadoCivil(estadoCivil);
        this.setEscolaridade(escolaridade);
        this.setFeliz(feliz);
        this.setMoradia(moradia);
    }

    public Pessoa() {}
    

}

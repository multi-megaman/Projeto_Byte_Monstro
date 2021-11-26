package br.ufrpe.byte_monstro.Negocios.beans;

import java.io.Serializable;

public abstract class UsuarioGeral implements Serializable {
    private long id;
    private String nome;
    private int idade;
    private char genero;
    private double peso;
    private double altura;
    private double percentualGordura;

    public UsuarioGeral(long id, String nome, int idade, char genero, double peso, double altura, double percentualGordura) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
        this.percentualGordura = percentualGordura;
    }

    public UsuarioGeral() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(double percentualGordura) {
        this.percentualGordura = percentualGordura;
    }



    @Override
    public String toString(){
        return String.format("%-8d|%-40s", getId(), getNome());
    }
}

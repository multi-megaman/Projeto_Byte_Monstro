package br.ufrpe.byte_monstro.byte_monstro_fx.beans;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.EnumExercicios;

public class Exercicios {
    private EnumExercicios tipo;
    private int serie;
    private String repeticao;
    private int carga;

    public Exercicios(EnumExercicios tipo, int serie, String repeticao, int carga) {
        this.tipo = tipo;
        this.serie = serie;
        this.repeticao = repeticao;
        this.carga = carga;
    }

    public EnumExercicios getTipo() {
        return tipo;
    }

    public void setTipo(EnumExercicios tipo) {
        this.tipo = tipo;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(String repeticao) {
        this.repeticao = repeticao;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    @Override
    public String toString(){
        return String.format("%-25s|%dX|%-5s|%d Kg", tipo, serie, repeticao, carga);
    }
}

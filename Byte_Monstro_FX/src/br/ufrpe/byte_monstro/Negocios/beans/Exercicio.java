package br.ufrpe.byte_monstro.Negocios.beans;

import java.io.Serializable;

public class Exercicio implements Serializable {
    private EnumExercicio tipo;
    private int serie;
    private String repeticao;
    private int carga;

    public Exercicio(EnumExercicio tipo, int serie, String repeticao, int carga) {
        this.tipo = tipo;
        this.serie = serie;
        this.repeticao = repeticao;
        this.carga = carga;
    }

    public EnumExercicio getTipo() {
        return tipo;
    }

    public void setTipo(EnumExercicio tipo) {
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
        return String.format("%-25s | %3d Séries | %5s Repetições | Peso: %dKg", tipo, serie, repeticao, carga);
    }
}

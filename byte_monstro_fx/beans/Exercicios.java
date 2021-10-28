package br.ufrpe.byte_monstro.byte_monstro_fx.beans;

public class Exercicios {
    private EnumExercicios tipo;
    private int serie;
    private int repeticao;
    private int carga;

    public Exercicios(EnumExercicios tipo, int serie, int repeticao, int carga) {
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

    public int getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(int repeticao) {
        this.repeticao = repeticao;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
}

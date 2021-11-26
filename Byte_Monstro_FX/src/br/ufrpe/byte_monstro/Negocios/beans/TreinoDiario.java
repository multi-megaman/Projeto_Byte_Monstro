package br.ufrpe.byte_monstro.Negocios.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class TreinoDiario implements Serializable {
    public ArrayList<Exercicio> exercicios;

    public TreinoDiario() {

        exercicios = new ArrayList<Exercicio>();
    }

    public ArrayList<Exercicio> getExercicios() {

        return exercicios;
    }

    public void adicionarExercicio(Exercicio exercicio) {
        exercicios.add(exercicio);
    }
    public void retirarExercicio(Exercicio exercicio) {
        exercicios.remove(exercicio);
    }

    @Override
    public String toString() {
        return exercicios.toString();
    }
}

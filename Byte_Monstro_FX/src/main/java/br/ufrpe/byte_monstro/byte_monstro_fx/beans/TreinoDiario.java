package br.ufrpe.byte_monstro.byte_monstro_fx.beans;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Exercicios;
import java.util.ArrayList;

public class TreinoDiario {
    public ArrayList<Exercicios> exercicios;

    public TreinoDiario() {

        exercicios = new ArrayList<Exercicios>();
    }

    public ArrayList<Exercicios> getExercicios() {

        return exercicios;
    }

    public void adicionarExercicio(Exercicios exercicio) {
        exercicios.add(exercicio);
    }
    public void retirarExercicio(Exercicios exercicio) {
        exercicios.remove(exercicio);
    }

    @Override
    public String toString() {
        return exercicios.toString();
    }
}

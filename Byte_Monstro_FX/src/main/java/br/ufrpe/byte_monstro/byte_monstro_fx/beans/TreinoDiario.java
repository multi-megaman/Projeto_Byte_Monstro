package br.ufrpe.byte_monstro.byte_monstro_fx.beans;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Exercicios;
import java.util.ArrayList;

public class TreinoDiario {
    public ArrayList<Exercicios> exercicios;

    public TreinoDiario() {
        this.exercicios = exercicios;
    }

    public void adicionarExercicio(Exercicios exercicio) {
        exercicios.add(exercicio);
    }
    public void retirarExercicio(Exercicios exercicio) {
        exercicios.remove(exercicio);
    }

}

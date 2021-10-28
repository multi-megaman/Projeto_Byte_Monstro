package br.ufrpe.byte_monstro.byte_monstro_fx.beans;

import java.util.ArrayList;

public class TreinoDiario {
    public ArrayList<Exercicios> exercicios;

    public void adicionarExercicio(Exercicios exercicio) {
        exercicios.add(exercicio);
    }
    public void retirarExercicio(Exercicios exercicio) {
        exercicios.remove(exercicio);
    }


    public void printExercicio(){
        for (Exercicios exAtual : exercicios) {
            System.out.println(exAtual.getTipo() +" | "+ exAtual.getSerie() + " | " + exAtual.getRepeticao() + " | ");
        }
    }
}

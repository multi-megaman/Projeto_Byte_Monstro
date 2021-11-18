package br.ufrpe.byte_monstro.byte_monstro_fx.beans;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.UsuarioGeral;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.TreinoDiario;
import java.time.LocalDate;
import java.util.ArrayList;

public class Aluno extends UsuarioGeral {
    private LocalDate dataMatricula;

    private int qntMaximaDeSequencia;
    private int qntTreinosPercorridos;
    private String relatoriosDisponiveis;
    private boolean pedirTrocaDoTreino;
    private long professor;
    protected ArrayList<TreinoDiario> sequenciaDeTreinos;

    public Aluno(long id, String nome, int idade, char genero, double peso, double altura, double percentualGordura, LocalDate dataMatricula, long idProf) {
        super(id, nome, idade, genero, peso, altura, percentualGordura);
        this.dataMatricula = dataMatricula;
        this.qntMaximaDeSequencia = 0;
        this.qntTreinosPercorridos = 0;
        this.relatoriosDisponiveis = "NULL";
        this.pedirTrocaDoTreino = false;
        sequenciaDeTreinos = new ArrayList<TreinoDiario>();
        this.professor = idProf;
    }

    public TreinoDiario getTreinoDiarioEspecifico (int index) {
        return sequenciaDeTreinos.get(index);
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public int getQntMaximaDeSequencia() {
        return qntMaximaDeSequencia;
    }

    public void setQntMaximaDeSequencia(int qntMaximaDeSequencia) {
        this.qntMaximaDeSequencia = qntMaximaDeSequencia;
    }

    public int getQntTreinosPercorridos() {
        return qntTreinosPercorridos;
    }

    public void setQntTreinosPercorridos(int qntTreinosPercorridos) {
        this.qntTreinosPercorridos = qntTreinosPercorridos;
    }

    public String getRelatoriosDisponiveis() {
        return relatoriosDisponiveis;
    }

    public void setRelatoriosDisponiveis(String relatoriosDisponiveis) {
        this.relatoriosDisponiveis = relatoriosDisponiveis;
    }

    public boolean getPedirTrocaDoTreino() {
        return pedirTrocaDoTreino;
    }

    public void setPedirTrocaDoTreino(boolean pedirTrocaDoTreino) {
        this.pedirTrocaDoTreino = pedirTrocaDoTreino;
    }

    public long getProfessor() {
        return professor;
    }

    public void setProfessor(long professor) {
        this.professor = professor;
    }

    public ArrayList<TreinoDiario> getSequenciaDeTreinos() {
        return sequenciaDeTreinos;
    }

    public void setSequenciaDeTreinos(ArrayList<TreinoDiario> sequenciaDeTreinos) {
        this.sequenciaDeTreinos = sequenciaDeTreinos;
    }

    public void adicionarTreino(TreinoDiario treino) {
        sequenciaDeTreinos.add(treino);
    }

    public void removerTreino(TreinoDiario treino) {
        sequenciaDeTreinos.remove(treino);
    }

    public double calcularIMC(){
        return this.getPeso()/(this.getAltura()*this.getAltura());
    }

    //ALTERAR DEPOIS
    public TreinoDiario retornarTreinoAtual(int index) {
        return sequenciaDeTreinos.get(index);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

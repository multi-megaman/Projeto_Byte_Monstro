package br.ufrpe.byte_monstro.Negocios.beans;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Aluno extends UsuarioGeral implements Serializable, Cloneable{
    @Serial
    private static final long serialVersionUID = 65991862911207121L;
    private LocalDate dataMatricula;

    private int qntMaximaDeSequencia;
    private int qntTreinosPercorridos;
    private String relatoriosDisponiveis;
    private boolean pedirTrocaDoTreino;
    private long professor;
    protected ArrayList<TreinoDiario> sequenciaDeTreinos;

    //public static int quantidadeMaximaDeItensPorHistorico = 6;

    ArrayList<Double> historicoPeso;
    ArrayList<Double> historicoGordura ;


    public Aluno(long id, String nome, int idade, char genero, double peso, double altura, double percentualGordura, LocalDate dataMatricula, long idProf) {
        super(id, nome, idade, genero, peso, altura, percentualGordura);
        this.dataMatricula = dataMatricula;
        this.qntMaximaDeSequencia = 30;
        this.qntTreinosPercorridos = 0;
        this.relatoriosDisponiveis = "NULL";
        this.pedirTrocaDoTreino = false;
        sequenciaDeTreinos = new ArrayList<TreinoDiario>();
        this.professor = idProf;

        historicoPeso = new ArrayList<Double>();
        historicoGordura = new ArrayList<Double>();
        historicoPeso.add(peso);
        historicoGordura.add(percentualGordura);


    }

    public Aluno() {

    }

    public Aluno clone() throws  CloneNotSupportedException {
        Aluno novoAluno = new Aluno(this.getId(),this.getNome(),this.getIdade(),this.getGenero(),this.getPeso(),this.getAltura(),this.getPercentualGordura(),this.getDataMatricula(),this.getProfessor());
        return novoAluno;
    }

    public void adicionarPesoAoHistorico(double peso) {
        //if (historicoPeso.size() <= quantidadeMaximaDeItensPorHistorico){
        historicoPeso.add(peso);
        /*}
        else{//PARA FAZER COM QUE A LISTA TENHA UM LIMITE DE ITENS DEFINIDOS


            for (int i = 0; i < historicoPeso.size()-1; i++) {
                if(i < historicoPeso.size()-2){
                    historicoPeso.set(i,historicoPeso.get(i+1));
                }
                else{
                    historicoPeso.set(i+1,peso);
                }

            }
        }*/

    }

    public void adicionarGorudraAoHistorico(double gordura) {
        //if (historicoGordura.size() <= quantidadeMaximaDeItensPorHistorico){
        historicoGordura.add(gordura);
        /*}
        else{//PARA FAZER COM QUE A LISTA TENHA UM LIMITE DE ITENS DEFINIDOS


            for (int i = 0; i < historicoGordura.size()-1; i++) {
                if(i < historicoGordura.size()-2){
                    historicoGordura.set(i,historicoGordura.get(i+1));
                }
                else{
                    historicoGordura.set(i+1,gordura);
                }

            }
        }*/

    }

    //PARA TESTES APENAS
    public void verHistoricos(){

        System.out.println("Pesos:");
        for (double i : historicoPeso) {
            System.out.print(i + " ");
        }

        System.out.println("");

        System.out.println("Gordura:");
        for (double i : historicoGordura) {
            System.out.print(i + " ");
        }
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


    public void adicionarTreino(TreinoDiario treino) {
        sequenciaDeTreinos.add(treino);
    }

    public void removerTreino(TreinoDiario treino) {
        sequenciaDeTreinos.remove(treino);
    }

    public double calcularIMC(){
        return this.getPeso()/(this.getAltura()*this.getAltura());
    }

    public ArrayList<TreinoDiario> getTreinoDiario() {
        return sequenciaDeTreinos;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

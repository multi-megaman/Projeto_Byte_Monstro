package beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluno extends UsuarioGeral{
    private LocalDate dataMatricula;

    private int qntMaximaDeSequencia;
    private int qntTreinosPercorridos;
    private String relatoriosDisponiveis;
    private boolean pedirTrocaDoTreino;
    protected ArrayList<TreinoDiario> sequenciaDeTreinos;

    public Aluno(long id, String nome, int idade, char genero, double peso, double altura, double percentualGordura, LocalDate dataMatricula, int qntMaximaDeSequencia, int qntTreinosPercorridos, String relatoriosDisponiveis) {
        super(id, nome, idade, genero, peso, altura, percentualGordura);
        this.dataMatricula = dataMatricula;
        this.qntMaximaDeSequencia = qntMaximaDeSequencia;
        this.qntTreinosPercorridos = qntTreinosPercorridos;
        this.relatoriosDisponiveis = relatoriosDisponiveis;
        this.pedirTrocaDoTreino = false;
        sequenciaDeTreinos = new ArrayList<TreinoDiario>();
    }

    //ALTERAR DEPOIS
    public TreinoDiario retornarTreinoAtual() {
        return sequenciaDeTreinos.get(0);
    }
}

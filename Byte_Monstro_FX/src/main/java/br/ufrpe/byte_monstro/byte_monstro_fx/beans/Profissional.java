package br.ufrpe.byte_monstro.byte_monstro_fx.beans;

import java.util.ArrayList;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.EnumAcademias;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.UsuarioGeral;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.TreinoDiario;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Aluno;

public class Profissional extends UsuarioGeral{
    private String senha;
    private EnumAcademias unidadeAtual;
    private ArrayList<Aluno> alunosVinculados;

    public Profissional(long id, String nome, int idade, char genero, double peso, double altura, double percentualGordura, String senha, EnumAcademias unidadeAtual) {
        super(id, nome, idade, genero, peso, altura, percentualGordura);
        this.senha = senha;
        this.unidadeAtual = unidadeAtual;
        this.alunosVinculados = new ArrayList<Aluno>();
    }
    
    public Profissional() {
        
    }

    public String getSenha() {
        return senha;
    }
    public void adicionarAlunoNaLista(Aluno aluno) {
        alunosVinculados.add(aluno);
    }

    public void removerAlunoNaLista(Aluno aluno) {
        alunosVinculados.remove(aluno);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunosVinculados;
    }

    public EnumAcademias getUnidadeAtual() {
        return unidadeAtual;
    }

    public void setUnidadeAtual(EnumAcademias unidadeAtual) {
        this.unidadeAtual = unidadeAtual;
    }

    @Override
	public String toString() {
		return super.toString() + " [senha (NÃO MOSTRAR A SENHA NO PROGRAMA FINAL)=" + senha + ", unidadeAtual=" + unidadeAtual + "]";
	}

	public TreinoDiario criarFichasDeExercicio() {
        return new TreinoDiario();
    }

    public void adicionarFichaDeExercicioAoAluno(Aluno a, TreinoDiario td) {
        a.sequenciaDeTreinos.add(td);
    }

    public ArrayList<Aluno> procuarAlunosParaTrocaDoTreino() {
        ArrayList<Aluno> solicitaramTroca = new ArrayList<Aluno>();
        for (Aluno i : alunosVinculados){
            if (i.getPedirTrocaDoTreino()){
                solicitaramTroca.add(i);
            }
        }
        return solicitaramTroca;
    }

    //public void gerarRelatorio(Aluno a) { }

    //public void editarFichaDeTreino (Aluno a, TreinoDiario t) { }

    //public void editarDadosDoAluno (Aluno a) { }

    //public void editarQntMaxima(Aluno a) { }
}

package br.ufrpe.byte_monstro.byte_monstro_fx.beans;

import java.util.ArrayList;

public class Profissional extends UsuarioGeral{
    private String senha;
    private String unidadeAtual;
    private ArrayList<Aluno> alunosVinculados;

    public Profissional(long id, String nome, int idade, char genero, double peso, double altura, double percentualGordura, String senha, String unidadeAtual) {
        super(id, nome, idade, genero, peso, altura, percentualGordura);
        this.senha = senha;
        this.unidadeAtual = unidadeAtual;
        this.alunosVinculados = new ArrayList<Aluno>();
    }
    
    public Profissional() {
        
    }

	@Override
	public String toString() {
		return "Profissional [senha=" + senha + ", unidadeAtual=" + unidadeAtual + ", alunosVinculados="
				+ alunosVinculados + "   " + this.getAltura() + "]";
	}

	public TreinoDiario criarFichasDeExercicio() {
        return new TreinoDiario();
    }

    public void adicionarFichaDeExercicioAoAluno(Aluno a) {

    }

    public void editarFichaDeTreino (Aluno a, TreinoDiario t) {

    }

    public void editarDadosDoAluno (Aluno a) {

    }

    public void editarQntMaxima(Aluno a) {

    }

    public ArrayList<Aluno> procuarAlunosParaTrocaDoTreino() {
        return new ArrayList<Aluno>();
    }

    public void gerarRelatorio(Aluno a) {

    }

    public void listarAlunosDoProfessor() {

    }
}

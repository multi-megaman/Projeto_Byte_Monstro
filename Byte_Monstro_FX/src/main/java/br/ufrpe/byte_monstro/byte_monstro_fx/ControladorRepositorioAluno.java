package br.ufrpe.byte_monstro.byte_monstro_fx;

import br.ufrpe.byte_monstro.byte_monstro_dados.IRepositorioUsuario;
import br.ufrpe.byte_monstro.byte_monstro_dados.RepositorioUsuario;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Aluno;

import java.util.List;

public class ControladorRepositorioAluno {

    private IRepositorioUsuario<Aluno> repositoAluno;


    public ControladorRepositorioAluno() {
        this.repositoAluno = new RepositorioUsuario<>("Alunos.dat");
    }

    public void adicionarAluno(Aluno aluno) {
        repositoAluno.inserir(aluno);
    }
    public void removerAluno(Aluno aluno) {
        repositoAluno.remover(aluno);
    }

    public void atualizarAluno(Aluno aluno) {
        repositoAluno.atualizar(aluno);
    }

    public List<Aluno> listarAlunos() {
        return repositoAluno.listar();
    }
}

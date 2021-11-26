package br.ufrpe.byte_monstro.Negocios;

import br.ufrpe.byte_monstro.Dados.IRepositorioUsuario;
import br.ufrpe.byte_monstro.Dados.RepositorioUsuario;
import br.ufrpe.byte_monstro.Negocios.beans.Aluno;

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

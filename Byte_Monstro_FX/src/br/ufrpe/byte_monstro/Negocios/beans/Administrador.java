package br.ufrpe.byte_monstro.Negocios.beans;

import java.io.Serial;
import java.io.Serializable;

public class Administrador extends UsuarioGeral implements Serializable {

    @Serial
    private static final long serialVersionUID = 4487982067962303534L;

    private String senha;

    public Administrador(long id, String nome, int idade, char genero, double peso, double altura, double percentualGordura, String senha) {
        super(id, nome, idade, genero, peso, altura, percentualGordura);
        this.senha = senha;
    }

    public Administrador(){

    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return super.toString() + " [senha (NÃO MOSTRAR A SENHA NO PROGRAMA FINAL)=" + senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void associarAlunoAoProfessor(Aluno a, Profissional p){
        a.setProfessor(p.getId());
    }

    public void realocarProfissional(Profissional p, EnumAcademia a) {
        p.setUnidadeAtual(a);
    }

}

package br.ufrpe.byte_monstro.byte_monstro_fx.beans;

import Byte_Monstro_FX.src.main.java.br.ufrpe.byte_monstro.byte_monstro_fx.beans.EnumAcademias;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Aluno;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Profissional;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.UsuarioGeral;

public class Administrador extends UsuarioGeral {
    private String senha;

    public Administrador(long id, String nome, int idade, char genero, double peso, double altura, double percentualGordura, String senha) {
        super(id, nome, idade, genero, peso, altura, percentualGordura);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void associarAlunoAoProfessor(Aluno a, Profissional p){
        a.setProfessor(p.getId());
    }

    public void realocarProfissional(Profissional p, EnumAcademias a) {
        p.setUnidadeAtual(a);
    }

}

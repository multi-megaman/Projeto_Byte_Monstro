package br.ufrpe.byte_monstro.byte_monstro_fx.beans;

public class Administrador extends UsuarioGeral{
    private String senha;

    public Administrador(long id, String nome, int idade, char genero, double peso, double altura, double percentualGordura, String senha) {
        super(id, nome, idade, genero, peso, altura, percentualGordura);
        this.senha = senha;
    }

    public void realocarProfissional(Profissional p) {

    }
    public void realocarAluno(Aluno a) {

    }
}

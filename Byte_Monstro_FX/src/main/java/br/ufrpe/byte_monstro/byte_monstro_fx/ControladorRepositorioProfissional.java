package br.ufrpe.byte_monstro.byte_monstro_fx;

import br.ufrpe.byte_monstro.byte_monstro_dados.IRepositorioUsuario;
import br.ufrpe.byte_monstro.byte_monstro_dados.RepositorioUsuario;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Aluno;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Profissional;

import java.util.List;

public class ControladorRepositorioProfissional {

    private IRepositorioUsuario<Profissional> repositorioProfissional;


    public ControladorRepositorioProfissional() {
        this.repositorioProfissional = new RepositorioUsuario<>("Profissionais.dat");


    }

    public void adicionarProfissional(Profissional profissional) {
        repositorioProfissional.inserir(profissional);
    }
    public void removerProfissional(Profissional profissional) {
        repositorioProfissional.remover(profissional);
    }

    public void atualizarProfissional(Profissional profissional) {
        repositorioProfissional.atualizar(profissional);
    }

    public List<Profissional> listarProfissionais() {
        return repositorioProfissional.listar();
    }
}

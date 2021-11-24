package br.ufrpe.byte_monstro.byte_monstro_fx;

import br.ufrpe.byte_monstro.byte_monstro_dados.IRepositorioUsuario;
import br.ufrpe.byte_monstro.byte_monstro_dados.RepositorioUsuario;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Administrador;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Profissional;

import java.util.List;

public class ControladorRepositorioAdministrador {

    private IRepositorioUsuario<Administrador> repositorioAdministrador;


    public ControladorRepositorioAdministrador() {
        this.repositorioAdministrador = new RepositorioUsuario<>("Administradores.dat");
    }

    public void adicionarAdministrador(Administrador administrador) {
        repositorioAdministrador.inserir(administrador);
    }
    public void removerAdministrador(Administrador administrador) {
        repositorioAdministrador.remover(administrador);
    }

    public void atualizarAdministrador(Administrador administrador) {
        repositorioAdministrador.atualizar(administrador);
    }

    public List<Administrador> listarAdministradores() {
        return repositorioAdministrador.listar();
    }
}

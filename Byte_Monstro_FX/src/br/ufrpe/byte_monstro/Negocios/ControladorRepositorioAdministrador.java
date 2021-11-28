package br.ufrpe.byte_monstro.Negocios;

import br.ufrpe.byte_monstro.Dados.IRepositorioUsuario;
import br.ufrpe.byte_monstro.Dados.RepositorioUsuario;
import br.ufrpe.byte_monstro.Exceptions.UsuarioJaCadastrado;
import br.ufrpe.byte_monstro.Exceptions.UsuarioNaoExiste;
import br.ufrpe.byte_monstro.Negocios.beans.Administrador;

import java.util.List;

public class ControladorRepositorioAdministrador {

    private IRepositorioUsuario<Administrador> repositorioAdministrador;


    public ControladorRepositorioAdministrador() {
        this.repositorioAdministrador = new RepositorioUsuario<>("Administradores.dat");
    }

    public void adicionarAdministrador(Administrador administrador) throws UsuarioJaCadastrado {
        repositorioAdministrador.inserir(administrador);
    }
    public void removerAdministrador(Administrador administrador) throws UsuarioNaoExiste {
        repositorioAdministrador.remover(administrador);
    }

    public void atualizarAdministrador(Administrador administrador) throws UsuarioNaoExiste {
        repositorioAdministrador.atualizar(administrador);
    }

    public List<Administrador> listarAdministradores() {
        return repositorioAdministrador.listar();
    }
}

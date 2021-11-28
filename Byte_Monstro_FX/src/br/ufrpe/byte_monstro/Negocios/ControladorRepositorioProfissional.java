package br.ufrpe.byte_monstro.Negocios;

import br.ufrpe.byte_monstro.Dados.IRepositorioUsuario;
import br.ufrpe.byte_monstro.Dados.RepositorioUsuario;
import br.ufrpe.byte_monstro.Exceptions.UsuarioJaCadastrado;
import br.ufrpe.byte_monstro.Exceptions.UsuarioNaoExiste;
import br.ufrpe.byte_monstro.Negocios.beans.Profissional;

import java.util.List;

public class ControladorRepositorioProfissional {

    private IRepositorioUsuario<Profissional> repositorioProfissional;


    public ControladorRepositorioProfissional() {
        this.repositorioProfissional = new RepositorioUsuario<>("Profissionais.dat");
    }

    public void adicionarProfissional(Profissional profissional) throws UsuarioJaCadastrado {
        repositorioProfissional.inserir(profissional);
    }
    public void removerProfissional(Profissional profissional) throws UsuarioNaoExiste {
        repositorioProfissional.remover(profissional);
    }

    public void atualizarProfissional(Profissional profissional) throws UsuarioNaoExiste {
        repositorioProfissional.atualizar(profissional);
    }

    public List<Profissional> listarProfissionais() {
        return repositorioProfissional.listar();
    }
}

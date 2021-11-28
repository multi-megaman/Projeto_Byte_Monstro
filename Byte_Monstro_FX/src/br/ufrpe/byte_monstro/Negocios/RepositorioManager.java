package br.ufrpe.byte_monstro.Negocios;


import br.ufrpe.byte_monstro.Exceptions.UsuarioJaCadastrado;
import br.ufrpe.byte_monstro.Exceptions.UsuarioNaoExiste;
import br.ufrpe.byte_monstro.Negocios.beans.Administrador;
import br.ufrpe.byte_monstro.Negocios.beans.Aluno;
import br.ufrpe.byte_monstro.Negocios.beans.Profissional;

import java.util.List;

public class RepositorioManager {
    private static RepositorioManager instance;

    private ControladorRepositorioAluno controladorRepositorioAluno;
    private ControladorRepositorioProfissional controladorRepositorioProfissional ;
    private ControladorRepositorioAdministrador controladorRepositorioAdministrador;

    public static RepositorioManager getInstance() {
        if (instance == null) {
            instance = new RepositorioManager();
        }

        return instance;
    }

    private RepositorioManager() {
        // Construtor privado para evitar instanciação
        controladorRepositorioAluno = new ControladorRepositorioAluno();
        controladorRepositorioProfissional = new ControladorRepositorioProfissional();
        controladorRepositorioAdministrador = new ControladorRepositorioAdministrador();

    }

    public void adicionarAluno(Aluno aluno) throws UsuarioJaCadastrado {
        controladorRepositorioAluno.adicionarAluno(aluno);
    }

    public void adicionarProfissional(Profissional profissional) throws UsuarioJaCadastrado {
        controladorRepositorioProfissional.adicionarProfissional(profissional);
    }

    public void adicionarAdministrador(Administrador administrador) throws UsuarioJaCadastrado {
        controladorRepositorioAdministrador.adicionarAdministrador(administrador);
    }

    public void removerAluno(Aluno aluno) throws UsuarioNaoExiste {
        controladorRepositorioAluno.removerAluno(aluno);
    }

    public void removerProfissional(Profissional profissional) throws UsuarioNaoExiste {
        controladorRepositorioProfissional.removerProfissional(profissional);
    }

    public void removerAdministrador(Administrador administrador) throws UsuarioNaoExiste {
        controladorRepositorioAdministrador.removerAdministrador(administrador);
    }

    public void atualizarAluno(Aluno aluno) throws UsuarioNaoExiste {
        controladorRepositorioAluno.atualizarAluno(aluno);
    }

    public void atualizarProfissional(Profissional profissional) throws UsuarioNaoExiste {
        controladorRepositorioProfissional.atualizarProfissional(profissional);
    }

    public void atualizarAdministrador(Administrador administrador) throws UsuarioNaoExiste {
        controladorRepositorioAdministrador.atualizarAdministrador(administrador);
    }

    public List<Aluno> listarAlunos() {
        return controladorRepositorioAluno.listarAlunos();
    }

    public List<Profissional> listarProfissionais() {
        return controladorRepositorioProfissional.listarProfissionais();
    }

    public List<Administrador> listarAdministradores() {
        return controladorRepositorioAdministrador.listarAdministradores();
    }
}

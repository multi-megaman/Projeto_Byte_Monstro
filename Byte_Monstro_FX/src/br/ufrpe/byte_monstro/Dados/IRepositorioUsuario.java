package br.ufrpe.byte_monstro.Dados;

import br.ufrpe.byte_monstro.Exceptions.UsuarioJaCadastrado;
import br.ufrpe.byte_monstro.Exceptions.UsuarioNaoExiste;

import java.util.List;

public interface IRepositorioUsuario<T> {

	void inserir(T obj) throws UsuarioJaCadastrado;

	List<T> listar();

	void remover(T obj) throws UsuarioNaoExiste;

	void atualizar(T newObj) throws UsuarioNaoExiste;

}
	


package br.ufrpe.byte_monstro.Dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.byte_monstro.Negocios.beans.*;

public interface IRepositorioUsuario<T> {

	void inserir(T obj);

	List<T> listar();

	void remover(T obj) ;

	void atualizar(T newObj);

}
	


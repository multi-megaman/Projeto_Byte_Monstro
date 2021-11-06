package br.ufrpe.byte_monstro.byte_monstro_dados;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.UsuarioGeral;

public interface IRepositorioUsuario<T> {

	void inserir(T obj);

	//List<T> listar();

	void remover(T obj) ;

	void atualizar(T newObj);

}
	


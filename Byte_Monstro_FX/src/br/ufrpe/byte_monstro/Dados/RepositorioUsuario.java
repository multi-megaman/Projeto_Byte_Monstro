package br.ufrpe.byte_monstro.Dados;

import br.ufrpe.byte_monstro.Exceptions.UsuarioJaCadastrado;
import br.ufrpe.byte_monstro.Exceptions.UsuarioNaoExiste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioUsuario<T> implements IRepositorioUsuario<T> {

	protected List<T> elementos;
	private String filename;

	@SuppressWarnings("unchecked")
	public RepositorioUsuario(String filename) {
		this.filename = filename;
		this.elementos = new ArrayList<>();

		Object listaElementos = RepositorioFileUtil.lerDoArquivo(this.filename);
		if (listaElementos != null && listaElementos instanceof List<?>){
			this.elementos = (List<T>) listaElementos;
		}
	}
	
	@Override
	public void inserir(T ug) throws UsuarioJaCadastrado {
		
		if(!elementos.contains(ug) && !ug.equals(null)) {
			elementos.add(ug);
		}
		else {
			throw new UsuarioJaCadastrado();
		}
		RepositorioFileUtil.salvarArquivo(elementos,this.filename);
		
	}

	@Override
	public void remover(T ug) throws UsuarioNaoExiste {
		
		if(elementos.contains(ug) && !ug.equals(null)) {
			this.elementos.remove(ug);
		}
		else {
			throw new UsuarioNaoExiste();
		}
		RepositorioFileUtil.salvarArquivo(elementos,this.filename);

	}

	@Override
	public void atualizar(T usuario) throws UsuarioNaoExiste{
		
		if(elementos.contains(usuario)) {
			int posUsuario = this.elementos.indexOf(usuario);
			this.elementos.set(posUsuario, usuario);
		}
		else {
			throw new UsuarioNaoExiste();
		}
		RepositorioFileUtil.salvarArquivo(elementos,this.filename);

	}

	@Override
	public List<T> listar() {
		return (Collections.unmodifiableList(this.elementos));
	}
	
	@Override
	public String toString() {
		return "RepositorioUsuario [usuarios=" + elementos + "]";
	}

}
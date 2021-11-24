package br.ufrpe.byte_monstro.byte_monstro_dados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Aluno;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Profissional;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.UsuarioGeral;

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
	public void inserir(T ug){
		
		if(elementos.contains(ug) || ug.equals(null)) {
			
			System.out.println("N foi possível cadastrar o usuário");
			return;
			
		}
		
		else {

			elementos.add(ug);
	
		}

		RepositorioFileUtil.salvarArquivo(elementos,this.filename);
		
}

	@Override
	public List<T> listar() {
		return (this.elementos);
	}

	@Override
	public void remover(T ug){
		
		if(elementos.contains(ug) && !ug.equals(null)) {
			
			
			this.elementos.remove(ug);
			
		}
		
		else {
			
			System.out.println("N foi possível remover o usuário");
			return;
	
		}

		RepositorioFileUtil.salvarArquivo(elementos,this.filename);
	}

	@Override
	public void atualizar(T usuario) {
		
		if(elementos.contains(usuario)) {
			
			int posUsuario = this.elementos.indexOf(usuario);
			this.elementos.set(posUsuario, usuario);
			
		}
		
		else {
			
			
			System.out.println("N foi possível atualizar o usuário");
			
		}

		RepositorioFileUtil.salvarArquivo(elementos,this.filename);
	}

	
	
	@Override
	public String toString() {
		return "RepositorioUsuario [usuarios=" + elementos + "]";
	}



}
package br.ufrpe.byte_monstro.byte_monstro_dados;

import java.util.ArrayList;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Aluno;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Profissional;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.UsuarioGeral;

public class RepositorioUsuario<T> implements IRepositorioUsuario<T> {
	
	ArrayList <T> usuarios = new ArrayList<>();
	
	
	public void inserir(T ug){
		
		if(usuarios.contains(ug) || ug.equals(null)) {
			
			System.out.println("N foi possível cadastrar o usuário");
			return;
			
		}
		
		else {
			
			usuarios.add(ug);
	
		}
		
}
	
	
	public void remover(T ug){
		
		if(usuarios.contains(ug) && !ug.equals(null)) {
			
			
			this.usuarios.remove(ug);
			
		}
		
		else {
			
			System.out.println("N foi possível remover o usuário");
			return;
	
		}
		
	}
	
	public void atualizar(T usuario) {
		
		if(usuarios.contains(usuario) || usuario.equals(null)) {
			
			int posUsuario = this.usuarios.indexOf(usuario);
			this.usuarios.set(posUsuario, usuario);
			
		}
		
		else {
			
			
			System.out.println("N foi possível atualizar o usuário");
			
		}	
		
	}
	
	
	/*public T VerificaRetornaUsuario(long ID) {
		
		for(T u : this.usuarios) {
			if(u.getId() == ID) {
				return u;
			}
		}
		
		return null;
	}*/
	
	/*public boolean verificarExistenciaUsuario(long ID) {
		
		for(UsuarioGeral u : this.usuarios) {
			if(u.getId() == ID) {
				return true;
			}
		}
		
		return false;
		
	}*/
	
	
	@Override
	public String toString() {
		return "RepositorioUsuario [usuarios=" + usuarios + "]";
	}


	public static void main(String[] args) {
		
		RepositorioUsuario ru = new RepositorioUsuario<Profissional>();
		
		Profissional p = new Profissional();
		
		p.setAltura(42);
		
		ru.inserir(p);
		
		System.out.println(ru);
		
		
		

		
	}


}
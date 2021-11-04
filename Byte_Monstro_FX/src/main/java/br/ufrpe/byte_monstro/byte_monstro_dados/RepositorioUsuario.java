package br.ufrpe.byte_monstro.byte_monstro_dados;

import java.util.ArrayList;

import br.ufrpe.byte_monstro.byte_monstro_fx.beans.Profissional;
import br.ufrpe.byte_monstro.byte_monstro_fx.beans.UsuarioGeral;

public class RepositorioUsuario {
	
	ArrayList <UsuarioGeral> usuarios = new ArrayList<>();
	
	
	private void cadastrarUsuario(UsuarioGeral ug){
		
		if(usuarios.contains(ug) || ug.equals(null)) {
			
			System.out.println("N foi possível cadastrar o usuário");
			return;
			
		}
		
		else {
			
			usuarios.add(ug);
	
		}
		
}
	
	
	private void removerUsuario(UsuarioGeral ug){
		
		if(usuarios.contains(ug) && !ug.equals(null)) {
			
			
			this.usuarios.remove(ug);
			
		}
		
		else {
			
			System.out.println("N foi possível remover o usuário");
			return;
	
		}
		
	}
	
	public void atualizar(UsuarioGeral usuario) {
		
		if(usuarios.contains(usuario) || usuario.equals(null)) {
			
			int posUsuario = this.usuarios.indexOf(usuario);
			this.usuarios.set(posUsuario, usuario);
			
		}
		
		else {
			
			
			System.out.println("N foi possível atualizar o usuário");
			
		}	
		
	}
	
	
	public UsuarioGeral VerificaRetornaUsuario(long ID) {
		
		for(UsuarioGeral u : this.usuarios) {
			if(u.getId() == ID) {
				return u;
			}
		}
		
		return null;
	}
	
	public boolean verificarExistenciaUsuario(long ID) {
		
		for(UsuarioGeral u : this.usuarios) {
			if(u.getId() == ID) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
	@Override
	public String toString() {
		return "RepositorioUsuario [usuarios=" + usuarios + "]";
	}


	public static void main(String[] args) {
		
		RepositorioUsuario ru = new RepositorioUsuario();
		
		Profissional p = new Profissional();
		
		p.setAltura(42);
		
		ru.cadastrarUsuario(p);
		
		System.out.println(ru.verificarExistenciaUsuario(p.getId()));
		
		
		

		
	}


}
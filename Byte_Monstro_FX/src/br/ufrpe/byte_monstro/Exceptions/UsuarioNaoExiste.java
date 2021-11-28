package br.ufrpe.byte_monstro.Exceptions;

public class UsuarioNaoExiste extends Exception{

    public UsuarioNaoExiste() {
        super("Usuário inexistente. (Verifique se os campos não estão nulos)");
    }

}

package br.ufrpe.byte_monstro.Exceptions;

public class UsuarioJaCadastrado extends Exception{

    public UsuarioJaCadastrado() {
        super("Este unuário já está cadastrado.");
    }
}

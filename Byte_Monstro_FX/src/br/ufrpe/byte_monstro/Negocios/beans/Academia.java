package br.ufrpe.byte_monstro.Negocios.beans;

public class Academia {

    private String endereco;
    private String numTelefone;

    public Academia(String endereco, String numTelefone) {
        this.endereco = endereco;
        this.numTelefone = numTelefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }
}

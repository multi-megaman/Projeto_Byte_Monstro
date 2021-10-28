import beans.UsuarioGeral;

public interface IRepositorioUsuario {

    public void cadastrarUsuario();
    public void removerUsuario();
    public void editarUsuario();
    public void listarUsuarios();

}

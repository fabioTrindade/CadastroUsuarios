package cadastrousuarios.usuario;

import java.util.List;

import cadastrousuarios.util.DAOFactory;

public class UsuarioRN {

	private UsuarioDAOinterface usuarioDAOinterface;
	
	public UsuarioRN() {
		this.usuarioDAOinterface = DAOFactory.criarUsuarioDAO();	
	}
	
	public Usuario carregar(Integer codigo){
		return this.usuarioDAOinterface.carregar(codigo);
		
	}
	
	public Usuario buscarPorLogin(String login){
		return this.usuarioDAOinterface.buscaPorLogin(login);
	}
	
	public void salvar(Usuario usuario){
		Integer codigo = usuario.getCodigo();
		if(codigo==null || codigo ==0){
			this.usuarioDAOinterface.salvar(usuario);
		}else {
			this.usuarioDAOinterface.atualizar(usuario);
		}
	}
	public void excluir(Usuario usuario){
		this.usuarioDAOinterface.excluir(usuario);
	}
	public List<Usuario> listar(){
		return this.usuarioDAOinterface.listar();
	}
}




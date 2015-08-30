package cadastrousuarios.util;

import cadastrousuarios.usuario.UsuarioDAOhibernate;

public class DAOFactory {

	public static UsuarioDAOhibernate criarUsuarioDAO(){
	
	UsuarioDAOhibernate usuarioDAO = new UsuarioDAOhibernate();
	usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
	return usuarioDAO;
	
	}
}

package cadastrousuarios.util;

import cadastrousuarios.usuario.Usuario;
import cadastrousuarios.usuario.UsuarioRN;

public class TestInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Usuario u = new Usuario();
		
		
		u.setAtivo(true);
		u.setCelular("83838393");
		u.setNome("teste");
		u.setEmail("algo@alogo.com");
		u.setIdioma("pt_BR");
		u.setLogin("tesdedete");
		
		
		UsuarioRN usu = new UsuarioRN();
		usu.salvar(u);
		
		/*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(u);
		*/
		
		
	}

}

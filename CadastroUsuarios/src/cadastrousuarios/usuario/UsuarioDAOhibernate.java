package cadastrousuarios.usuario;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAOhibernate implements UsuarioDAOinterface {
	
	private Session session;
	
	public void setSession(Session sessaoAtiva){
		 this.session = sessaoAtiva;
	}
	

	@Override
	public void salvar(Usuario usuario) {
		// TODO Auto-generated method stub
		 {
				try {
					this.session.beginTransaction();
					this.session.save(usuario);
					this.session.getTransaction().commit();
				} catch (Exception e) {
					this.session.getTransaction().rollback();
					e.printStackTrace();
				}
			}
	}

	@Override
	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			this.session.beginTransaction();
			this.session.update(usuario);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			this.session.getTransaction().rollback();
			e.printStackTrace();
		}
	}


	@Override
	public void excluir(Usuario usuario) {
		// TODO Auto-generated method stub
		try {
			this.session.beginTransaction();
			this.session.delete(usuario);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			this.session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@Override
	public Usuario carregar(Integer codigo) {
		// TODO Auto-generated method stub
		Usuario retorno = new Usuario();
		try {
			this.session.beginTransaction();
			retorno = (Usuario) this.session.get(Usuario.class, codigo);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			this.session.getTransaction().rollback();
			e.printStackTrace();
		}
		return retorno;
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		// TODO Auto-generated method stub
		Usuario retorno = new Usuario();
		String hql = "select u from Usuario u where u.login = :login";
		try{
			this.session.beginTransaction();
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		retorno = (Usuario) consulta.uniqueResult();
		this.session.getTransaction().commit();
		}catch (Exception e) {
			this.session.getTransaction().rollback();
			e.printStackTrace();
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		List<Usuario> retorno = null;
		try {
			this.session.beginTransaction();
			retorno = this.session.createCriteria(Usuario.class).list();
		} catch (Exception e) {
			this.session.getTransaction().rollback();
			e.printStackTrace();
		}
		return retorno;
		
	}

}

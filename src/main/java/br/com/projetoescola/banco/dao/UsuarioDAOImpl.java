package br.com.projetoescola.banco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetoescola.banco.entidades.Usuario;

@Component
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {

	public UsuarioDAOImpl(Session session) {
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		Criteria c = getSession().createCriteria(Usuario.class);
		
		return c.list();
	}
	
	public Usuario buscaUsuarioPorEmailESenha(Usuario usuario) {
		Query query = getSession().createQuery("from Usuario where email = :email and senha = :senha") ;
			query.setParameter("email", usuario.getEmail()) ;
			query.setParameter("senha", usuario.getSenha()) ;
		
		return (Usuario) query.uniqueResult() ;
	}
	
	
	
}

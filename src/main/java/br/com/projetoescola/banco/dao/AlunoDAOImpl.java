package br.com.projetoescola.banco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetoescola.banco.entidades.Aluno;
import br.com.projetoescola.seguranca.UsuarioLogado;

@Component
public class AlunoDAOImpl extends GenericEntidadeEscolaDAOImpl<Aluno> implements AlunoDAO {

	public AlunoDAOImpl(Session session, UsuarioLogado usuarioLogado) {
		super(session, usuarioLogado);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> buscaTodos() {
		Criteria c = getSession().createCriteria(Aluno.class);
		
		return c.list();
	}
	
	public Aluno buscaPorUsuarioId(Long usuarioId) {
		Criteria criteria = createCriteria();
		criteria.createAlias("usuario", "usuario");
		Restrictions.eq("usuario.id", usuarioId);
		
		return (Aluno) criteria.uniqueResult();
	}
	
	
	
}

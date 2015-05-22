package br.com.projetoescola.banco.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetoescola.banco.entidades.Aluno;

@Component
public class AlunoDAOImpl extends GenericDAOImpl<Aluno> implements AlunoDAO {

	public AlunoDAOImpl(Session session) {
		super(session);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> buscaTodos() {
		Criteria c = getSession().createCriteria(Aluno.class);
		
		return c.list();
	}
	
	
	
}

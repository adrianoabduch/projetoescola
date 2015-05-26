package br.com.projetoescola.banco.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetoescola.banco.entidades.Colaborador;
import br.com.projetoescola.seguranca.UsuarioLogado;

@Component
public class ColaboradorDAOImpl extends GenericEntidadeEscolaDAOImpl<Colaborador> implements ColaboradorDAO {

	public ColaboradorDAOImpl(Session session, UsuarioLogado usuarioLogado) {
		super(session, usuarioLogado);
	}
	
	public Colaborador buscaPorUsuarioId(Long usuarioId) {
		Criteria criteria = createCriteria();
		criteria.createAlias("usuario", "usuario");
		Restrictions.eq("usuario.id", usuarioId);
		
		return (Colaborador) criteria.uniqueResult();
	}
	
}

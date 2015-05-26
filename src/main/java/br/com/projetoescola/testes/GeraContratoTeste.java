package br.com.projetoescola.testes;

import org.hibernate.Session;

import br.com.projetoescola.banco.dao.AlunoDAO;
import br.com.projetoescola.banco.dao.AlunoDAOImpl;
import br.com.projetoescola.banco.dao.ColaboradorDAO;
import br.com.projetoescola.banco.dao.ColaboradorDAOImpl;
import br.com.projetoescola.banco.dao.ContratoDAO;
import br.com.projetoescola.banco.dao.ContratoDAOImpl;
import br.com.projetoescola.banco.dao.EscolaDAO;
import br.com.projetoescola.banco.dao.EscolaDAOImpl;
import br.com.projetoescola.banco.dao.UsuarioDAO;
import br.com.projetoescola.banco.dao.UsuarioDAOImpl;
import br.com.projetoescola.banco.entidades.Aluno;
import br.com.projetoescola.banco.entidades.Colaborador;
import br.com.projetoescola.banco.entidades.Contrato;
import br.com.projetoescola.banco.entidades.Escola;
import br.com.projetoescola.banco.entidades.Usuario;
import br.com.projetoescola.tipo.TipoPerfil;

public class GeraContratoTeste {

	public static void main(String[] args) {
		
		//Abre a session e gera os DAOS
		Session s = CriadorDeSessionParaTeste.abreSession();
		ContratoDAO contratoDAO = new ContratoDAOImpl(s);
		EscolaDAO escolaDAO = new EscolaDAOImpl(s);
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl(s);
		ColaboradorDAO colaboradorDAO = new ColaboradorDAOImpl(s, null);
		AlunoDAO alunoDAO = new AlunoDAOImpl(s, null);
		
		//Cria o contrato
		Contrato c = new Contrato();
		c.setNomeFantasia("Colégio ABCdário");
		c.setRazaoSocial("ABCdário LTDA");
		c.setPrimeiroNome("Gerald");
		c.setSobreNome("de Rívia");
		c.setNumeroAlunosSolicitado(200);
		c.setNumeroAlunosContratado(200);
		c.setEmail("contato@colegioabcdario.com.br");
		
		//Cria a escola, por enquanto está manual.
		Escola e = new Escola();
		e.setNomeFantasia(c.getNomeFantasia());
		e.setRazaoSocial(c.getRazaoSocial());

		Colaborador colaborador = new Colaborador();
		colaborador.setPrimeiroNome("Cirilla");
		colaborador.setSobrenome("Fiona Elen Rianno");
		
		Aluno aluno = new Aluno();
		aluno.setPrimeiroNome("Triss");
		aluno.setSobrenome("Merigold de Maribor");
		
		Usuario u = new Usuario();
		u.setEmail("ciri@colegioabcdario.com.br");
		u.setSenha("123");
		u.setPerfil(TipoPerfil.ADMINISTADOR);
		
		
//		Salva o contrato
		contratoDAO._salvar(c);
		
//		Adiciona o contrato na escola e salva a escola
		e.setContrato(c);
		escolaDAO._salvar(e);
		
//		Adiciona a escola no usuário administrativo e salva o usuário
		u.setEscola(e);
		usuarioDAO._salvar(u);
		
//		Adiciona o usuário administrativo e a escola
//		no colaborador que contratou e salva o colaborador 
		colaborador.setEscola(e);
		colaborador.setUsuario(u);
		colaboradorDAO._salvar(colaborador);
		
//		Adiciona a escola no aluno e salva o aluno
		aluno.setEscola(e);
		alunoDAO._salvar(aluno);
	}
	
}

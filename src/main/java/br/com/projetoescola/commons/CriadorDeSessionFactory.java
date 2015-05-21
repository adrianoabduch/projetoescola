package br.com.projetoescola.commons;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

//@Component
//@ApplicationScoped
public class CriadorDeSessionFactory { //implements ComponentFactory<SessionFactory> {

//	private SessionFactory factory;
//	
//	@PostConstruct
//	public void abre() {
//		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//
//		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
//	    serviceRegistryBuilder.applySettings(configuration.getProperties());
//
//	    ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
//
//		this.factory = configuration.buildSessionFactory(serviceRegistry);
//	}
//	
//	public SessionFactory getInstance() {
//		return this.factory;
//	}
//	
//	@PreDestroy
//	private void fecha() {
//		this.factory.close();
//	}
	

}
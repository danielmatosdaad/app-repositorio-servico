package br.app.repositorio.dao.facede;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.app.barramento.infra.persistencia.dao.AbstractFacade;
import br.app.respositorio.dao.model.Servico;


@Stateless
public class ServicoFacede extends AbstractFacade<Servico> {

	public ServicoFacede() {
		super(Servico.class);
	}

	public ServicoFacede(Class<Servico> entityClass) {
		super(entityClass);
	}
	

	@PersistenceContext(unitName = "persistencia-contexto-respositorio")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}


	public List<Servico> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Servico> criteria = cb.createQuery(Servico.class);
		Root<Servico> root = criteria.from(Servico.class);
		CriteriaQuery<Servico> todos = criteria.select(root);
		TypedQuery<Servico> allQuery = em.createQuery(todos);
		
		List<Servico> resultado = allQuery.getResultList();
		
		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}

}
	
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
import br.app.respositorio.dao.model.Repositorio;


@Stateless
public class RepositorioFacede extends AbstractFacade<Repositorio> {

	public RepositorioFacede() {
		super(Repositorio.class);
	}

	public RepositorioFacede(Class<Repositorio> entityClass) {
		super(entityClass);
	}
	

	@PersistenceContext(unitName = "app-contexto-respositorio")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}


	public List<Repositorio> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Repositorio> criteria = cb.createQuery(Repositorio.class);
		Root<Repositorio> root = criteria.from(Repositorio.class);
		CriteriaQuery<Repositorio> todos = criteria.select(root);
		TypedQuery<Repositorio> allQuery = em.createQuery(todos);
		
		List<Repositorio> resultado = allQuery.getResultList();
		
		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}

}
	
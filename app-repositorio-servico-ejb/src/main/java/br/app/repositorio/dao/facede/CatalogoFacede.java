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
import br.app.respositorio.dao.model.Catalogo;


@Stateless
public class CatalogoFacede extends AbstractFacade<Catalogo> {

	public CatalogoFacede() {
		super(Catalogo.class);
	}

	public CatalogoFacede(Class<Catalogo> entityClass) {
		super(entityClass);
	}
	

	@PersistenceContext(unitName = "persistencia-contexto-respositorio")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}


	public List<Catalogo> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Catalogo> criteria = cb.createQuery(Catalogo.class);
		Root<Catalogo> root = criteria.from(Catalogo.class);
		CriteriaQuery<Catalogo> todos = criteria.select(root);
		TypedQuery<Catalogo> allQuery = em.createQuery(todos);
		
		List<Catalogo> resultado = allQuery.getResultList();
		
		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}

}
	
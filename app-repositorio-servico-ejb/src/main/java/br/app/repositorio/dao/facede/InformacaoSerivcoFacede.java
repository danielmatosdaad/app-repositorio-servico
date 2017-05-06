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
import br.app.respositorio.dao.model.InformacaoServico;


@Stateless
public class InformacaoSerivcoFacede extends AbstractFacade<InformacaoServico> {

	public InformacaoSerivcoFacede() {
		super(InformacaoServico.class);
	}

	public InformacaoSerivcoFacede(Class<InformacaoServico> entityClass) {
		super(entityClass);
	}
	

	@PersistenceContext(unitName = "persistencia-contexto-respositorio")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}


	public List<InformacaoServico> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<InformacaoServico> criteria = cb.createQuery(InformacaoServico.class);
		Root<InformacaoServico> root = criteria.from(InformacaoServico.class);
		CriteriaQuery<InformacaoServico> todos = criteria.select(root);
		TypedQuery<InformacaoServico> allQuery = em.createQuery(todos);
		
		List<InformacaoServico> resultado = allQuery.getResultList();
		
		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}

}
	
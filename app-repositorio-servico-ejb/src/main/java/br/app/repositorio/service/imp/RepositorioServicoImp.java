package br.app.repositorio.service.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Startup;
import javax.ejb.Stateless;

import br.app.barramento.infra.persistencia.service.ServiceDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.repositorio.dao.facede.RepositorioFacede;
import br.app.repositorio.servico.integracao.IRepositorio;
import br.app.repositorio.servico.integracao.IServicoRepositorioLocal;
import br.app.repositorio.servico.integracao.IServicoRepositorioRemote;
import br.app.repositorio.servico.integracao.RepositorioDTO;
import br.app.repositorio.servico.integracao.RepositorioServicoDTO;
import br.app.respositorio.dao.model.Repositorio;

@Startup
@Stateless
@Remote(value = { IServicoRepositorioRemote.class })
@Local(value = { IServicoRepositorioLocal.class })
public class RepositorioServicoImp implements IServicoRepositorioRemote, IServicoRepositorioLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private RepositorioFacede repositorioFacade;

	@Override
	public IRepositorio getRespositorio() throws InfraEstruturaException, NegocioException {

		System.out.println("buscando todos os repositorios");
		System.out.println(RepositorioFacede.class.getName() + " : " + repositorioFacade);
		List<RepositorioServicoDTO> repositoriosRegistrados = this.bustarTodos();
		RepositorioDTO rep = new RepositorioDTO();
		System.out.println("Repositorios buscados:" + repositoriosRegistrados);
		if (repositoriosRegistrados != null) {
			System.out.println(repositoriosRegistrados.size());

			rep.setRepositorioServico(repositoriosRegistrados);
		}

		return rep;
	}


	@Override
	public RepositorioServicoDTO adiconar(RepositorioServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.adiconar(getRepositorioFacade(), Repositorio.class, dto);

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<RepositorioServicoDTO> adiconar(List<RepositorioServicoDTO> listaDto)
			throws InfraEstruturaException, NegocioException {
		try {

			for (RepositorioServicoDTO dto : listaDto) {

				adiconar(dto);
			}

			return listaDto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public RepositorioServicoDTO alterar(RepositorioServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.alterar(this.getRepositorioFacade(), Repositorio.class, dto);
			return dto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public void remover(RepositorioServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(this.getRepositorioFacade(), Repositorio.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
	}

	@Override
	public List<RepositorioServicoDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {

			return (List<RepositorioServicoDTO>) ServiceDAO.bustarTodos(this.getRepositorioFacade(),
					RepositorioServicoDTO.class);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public RepositorioServicoDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorID(this.getRepositorioFacade(), RepositorioServicoDTO.class, id);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public List<RepositorioServicoDTO> bustarPorIntervaloID(int[] range)
			throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(this.getRepositorioFacade(), RepositorioServicoDTO.class, range);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public RepositorioFacede getRepositorioFacade() {
		return repositorioFacade;
	}

	public void setRepositorioFacade(RepositorioFacede repositorioFacade) {
		this.repositorioFacade = repositorioFacade;
	}

}

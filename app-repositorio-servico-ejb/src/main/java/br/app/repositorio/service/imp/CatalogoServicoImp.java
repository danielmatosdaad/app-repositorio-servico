package br.app.repositorio.service.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Startup;
import javax.ejb.Stateless;

import br.app.barramento.infra.persistencia.service.ServiceDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoLocalDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.repositorio.dao.facede.CatalogoFacede;
import br.app.repositorio.servico.integracao.CatalogoServicoDTO;
import br.app.repositorio.servico.integracao.IServicoCatalogoLocal;
import br.app.repositorio.servico.integracao.IServicoCatalogoRemote;
import br.app.repositorio.servico.integracao.IServicoRepositorioLocal;
import br.app.repositorio.servico.integracao.IServicoRepositorioRemote;
import br.app.respositorio.dao.model.Catalogo;

@Startup
@Stateless
@Remote(value = { IServicoRepositorioRemote.class, IServicoRemoteDAO.class })
@Local(value = { IServicoRepositorioLocal.class, IServicoLocalDAO.class })
public class CatalogoServicoImp implements IServicoCatalogoRemote, IServicoCatalogoLocal,
		IServicoLocalDAO<CatalogoServicoDTO>, IServicoRemoteDAO<CatalogoServicoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private CatalogoFacede catalogoFacade;

	@Override
	public CatalogoServicoDTO adiconar(CatalogoServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.adiconar(getCatalogoFacade(), Catalogo.class, dto);

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<CatalogoServicoDTO> adiconar(List<CatalogoServicoDTO> listaDto)
			throws InfraEstruturaException, NegocioException {
		try {

			for (CatalogoServicoDTO dto : listaDto) {

				adiconar(dto);
			}

			return listaDto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public CatalogoServicoDTO alterar(CatalogoServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.alterar(this.getCatalogoFacade(), Catalogo.class, dto);
			return dto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public void remover(CatalogoServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(this.getCatalogoFacade(), Catalogo.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
	}

	@Override
	public List<CatalogoServicoDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {

			return (List<CatalogoServicoDTO>) ServiceDAO.bustarTodos(this.getCatalogoFacade(),
					CatalogoServicoDTO.class);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public CatalogoServicoDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorID(this.getCatalogoFacade(), CatalogoServicoDTO.class, id);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public List<CatalogoServicoDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(this.getCatalogoFacade(), CatalogoServicoDTO.class, range);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public CatalogoFacede getCatalogoFacade() {
		return catalogoFacade;
	}

	public void setCatalogoFacade(CatalogoFacede catalogoFacade) {
		this.catalogoFacade = catalogoFacade;
	}

}

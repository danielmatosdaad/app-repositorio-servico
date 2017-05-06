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
import br.app.repositorio.dao.facede.ServicoFacede;
import br.app.repositorio.servico.integracao.IServicoLocal;
import br.app.repositorio.servico.integracao.IServicoRemote;
import br.app.repositorio.servico.integracao.ServicoDTO;
import br.app.respositorio.dao.model.Catalogo;

@Startup
@Stateless
@Remote(value = { IServicoRemote.class, IServicoRemoteDAO.class })
@Local(value = { IServicoLocal.class, IServicoLocalDAO.class })
public class ServicoImp
		implements IServicoRemote, IServicoLocal, IServicoLocalDAO<ServicoDTO>, IServicoRemoteDAO<ServicoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ServicoFacede servicoFacede;

	@Override
	public ServicoDTO adiconar(ServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.adiconar(getServicoFacede(), Catalogo.class, dto);

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<ServicoDTO> adiconar(List<ServicoDTO> listaDto) throws InfraEstruturaException, NegocioException {
		try {

			for (ServicoDTO dto : listaDto) {

				adiconar(dto);
			}

			return listaDto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public ServicoDTO alterar(ServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.alterar(getServicoFacede(), Catalogo.class, dto);
			return dto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public void remover(ServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(getServicoFacede(), Catalogo.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
	}

	@Override
	public List<ServicoDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {

			return (List<ServicoDTO>) ServiceDAO.bustarTodos(getServicoFacede(), ServicoDTO.class);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public ServicoDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorID(getServicoFacede(), ServicoDTO.class, id);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public List<ServicoDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(getServicoFacede(), ServicoDTO.class, range);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public ServicoFacede getServicoFacede() {
		return servicoFacede;
	}

	public void setServicoFacede(ServicoFacede servicoFacede) {
		this.servicoFacede = servicoFacede;
	}

}

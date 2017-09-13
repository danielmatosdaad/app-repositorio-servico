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
import br.app.repositorio.dao.facede.InformacaoServicoFacede;
import br.app.repositorio.servico.integracao.IInformacaoServicoLocal;
import br.app.repositorio.servico.integracao.IInformacaoServicoRemote;
import br.app.repositorio.servico.integracao.InformacaoServicoDTO;
import br.app.respositorio.dao.model.Catalogo;

@Startup
@Stateless
@Remote(value = { IInformacaoServicoRemote.class, IServicoRemoteDAO.class })
@Local(value = { IInformacaoServicoLocal.class, IServicoLocalDAO.class })
public class InformacaoServicoImp implements IInformacaoServicoRemote, IInformacaoServicoLocal,
		IServicoLocalDAO<InformacaoServicoDTO>, IServicoRemoteDAO<InformacaoServicoDTO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private InformacaoServicoFacede informacaoSerivcoFacede;

	@Override
	public InformacaoServicoDTO adiconar(InformacaoServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.adiconar(getInformacaoSerivcoFacede(), Catalogo.class, dto);

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<InformacaoServicoDTO> adiconar(List<InformacaoServicoDTO> listaDto)
			throws InfraEstruturaException, NegocioException {
		try {

			for (InformacaoServicoDTO dto : listaDto) {

				adiconar(dto);
			}

			return listaDto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public InformacaoServicoDTO alterar(InformacaoServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.alterar(getInformacaoSerivcoFacede(), Catalogo.class, dto);
			return dto;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public void remover(InformacaoServicoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(getInformacaoSerivcoFacede(), Catalogo.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
	}

	@Override
	public List<InformacaoServicoDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {

			return (List<InformacaoServicoDTO>) ServiceDAO.bustarTodos(getInformacaoSerivcoFacede(),
					InformacaoServicoDTO.class);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public InformacaoServicoDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorID(getInformacaoSerivcoFacede(), InformacaoServicoDTO.class, id);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public List<InformacaoServicoDTO> bustarPorIntervaloID(int[] range)
			throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(getInformacaoSerivcoFacede(), InformacaoServicoDTO.class, range);
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public InformacaoServicoFacede getInformacaoSerivcoFacede() {
		return informacaoSerivcoFacede;
	}

	public void setInformacaoSerivcoFacede(InformacaoServicoFacede informacaoSerivcoFacede) {
		this.informacaoSerivcoFacede = informacaoSerivcoFacede;
	}

}

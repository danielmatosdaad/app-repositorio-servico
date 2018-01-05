package br.app.repositorio.servico.integracao;

import java.util.List;

import br.app.barramento.integracao.dto.FiltroDTO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;

public interface IServicoRepositorio{

	public RepositorioServicoDTO adiconar(RepositorioServicoDTO dto) throws InfraEstruturaException, NegocioException;

	public List<RepositorioServicoDTO> adiconar(List<RepositorioServicoDTO> listaDto)
			throws InfraEstruturaException, NegocioException;

	public RepositorioServicoDTO alterar(RepositorioServicoDTO dto) throws InfraEstruturaException, NegocioException;

	public void remover(RepositorioServicoDTO dto) throws InfraEstruturaException, NegocioException;

	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException;

	public List<RepositorioServicoDTO> bustarTodos() throws InfraEstruturaException, NegocioException;

	public RepositorioServicoDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException;

	public List<RepositorioServicoDTO> bustarPorIntervaloID(int[] range)
			throws InfraEstruturaException, NegocioException;

	List<RepositorioServicoDTO> listaComFiltro(FiltroDTO filtroDTO, int results, int page)
			throws InfraEstruturaException, NegocioException;

	public IRepositorio getRespositorio() throws InfraEstruturaException, NegocioException;

	public List<RepositorioServicoDTO> filtrar(FiltroDTO filtro) throws InfraEstruturaException, NegocioException;
}

package br.app.repositorio.servico.integracao;

import java.util.Iterator;
import java.util.List;

import br.app.barramento.integracao.dto.DTO;
import br.app.barramento.integracao.exception.NegocioException;

public class RepositorioDTO implements IRepositorio, DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	boolean ativo;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	private List<RepositorioServicoDTO> repositorioServico;

	public List<RepositorioServicoDTO> getRepositorioServico() {
		return repositorioServico;
	}

	public void setRepositorioServico(List<RepositorioServicoDTO> repositorioServico) {
		this.repositorioServico = repositorioServico;
	}

	@Override
	public RepositorioServico buscar(String nomeRepositorio) throws NegocioException {

		if (nomeRepositorio == null || nomeRepositorio.trim().equals("")) {
			throw new RuntimeException("Nome Servico invalido");
		}
		if (repositorioServico != null) {
			for (Iterator<RepositorioServicoDTO> iterator = repositorioServico.iterator(); iterator.hasNext();) {
				RepositorioServicoDTO rp = (RepositorioServicoDTO) iterator.next();

				if (nomeRepositorio.equals(rp.getNome())) {
					return rp;
				}
			}
		}
		throw new NegocioException("Repositorio nao encontrado: " + nomeRepositorio, new RuntimeException());
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public InformacaoServico buscarInformacaoServico(String nomeRespositorio, String nomeCatalogo, String nomeAcao,
			String envio,String tokenAutorizaca) throws NegocioException {
		RepositorioServico repositorio = buscar(nomeRespositorio);
		if (repositorio != null) {
			CatalogoServico catalogo = repositorio.buscar(nomeCatalogo);
			if (catalogo != null) {
				return catalogo.buscarInformacaoServico(nomeAcao, envio,tokenAutorizaca);
			}
		}
		throw new NegocioException("Servico nao encontrado", new RuntimeException());
	}

}

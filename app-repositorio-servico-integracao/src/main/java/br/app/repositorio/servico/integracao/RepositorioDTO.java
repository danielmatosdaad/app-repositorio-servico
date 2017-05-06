package br.app.repositorio.servico.integracao;

import java.util.Iterator;
import java.util.List;

import br.app.barramento.integracao.dto.DTO;

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
	public RepositorioServico buscar(String name) {

		if (name == null || name.trim().equals("")) {
			throw new RuntimeException("Nome Servico invalido");
		}
		if (repositorioServico != null) {
			for (Iterator<RepositorioServicoDTO> iterator = repositorioServico.iterator(); iterator.hasNext();) {
				RepositorioServicoDTO rp = (RepositorioServicoDTO) iterator.next();

				if (name.equals(rp.getNome())) {
					return rp;
				}
			}
		}
		System.out.println("Repositorio nao achado");
		return null;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public InformacaoServico buscarInformacaoServico(String nomeRespositorio, String nomeCatalogo, String nomeAcao,String envio) {
		RepositorioServico repositorio = buscar(nomeRespositorio);
		if (repositorio != null) {
			CatalogoServico catalogo = repositorio.buscar(nomeCatalogo);
			if (catalogo != null) {
				return catalogo.buscarInformacaoServico(nomeAcao,envio);
			}
		}
		return null;
	}

}

package br.app.repositorio.servico.integracao;

import java.util.Iterator;
import java.util.List;

import br.app.barramento.integracao.dto.DTO;

public class RepositorioServicoDTO implements RepositorioServico, DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private boolean ativo;
	private List<CatalogoServicoDTO> catalogo;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

	@Override
	public CatalogoServico buscar(String name) {

		if (name == null || name.trim().equals("")) {
			throw new RuntimeException("Nome Servico invalido");
		}
		if (catalogo != null) {

			for (Iterator<CatalogoServicoDTO> iterator = catalogo.iterator(); iterator.hasNext();) {
				CatalogoServicoDTO catalaogo = (CatalogoServicoDTO) iterator.next();

				if (name.equals(catalaogo.getNome())) {
					return catalaogo;
				}
			}
		}

		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CatalogoServicoDTO> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<CatalogoServicoDTO> catalogo) {
		this.catalogo = catalogo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}

package br.app.repositorio.servico.integracao;

import br.app.barramento.integracao.dto.DTO;

public class ServicoDTO implements DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private CatalogoServicoDTO catalogo;
	private AcaoServicoDTO acaoServico;
	private InformacaoServicoDTO informacaoServico;
	private boolean ativo;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public AcaoServicoDTO getAcaoServico() {
		return acaoServico;
	}

	public void setAcaoServico(AcaoServicoDTO acaoServico) {
		this.acaoServico = acaoServico;
	}

	public InformacaoServicoDTO getInformacaoServico() {
		return informacaoServico;
	}

	public void setInformacaoServico(InformacaoServicoDTO informacaoServico) {
		this.informacaoServico = informacaoServico;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public CatalogoServicoDTO getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(CatalogoServicoDTO catalogo) {
		this.catalogo = catalogo;
	}

}

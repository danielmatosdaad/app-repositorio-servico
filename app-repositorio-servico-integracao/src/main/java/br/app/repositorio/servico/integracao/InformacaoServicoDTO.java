package br.app.repositorio.servico.integracao;

import java.util.List;

import br.app.barramento.integracao.dto.DTO;

public class InformacaoServicoDTO implements InformacaoServico, DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String interfaces;
	private String envio;
	private String reposta;
	private String delegate;
	private String tokenAutorizacao;
	private boolean ativo;
	private List<ServicoDTO> servicos;

	public InformacaoServicoDTO() {
	}

	public InformacaoServicoDTO(Long id, String nomeServico, String descricaoServico, String servico, String envio,
			String reposta, String delegate) throws ClassNotFoundException {
		this(servico, envio, reposta, delegate);
		this.id = id;

	}

	public InformacaoServicoDTO(String interfaces, String envio, String reposta, String delegate)
			throws ClassNotFoundException {
		super();
		this.interfaces = interfaces;
		this.envio = envio;
		this.reposta = reposta;
		this.delegate = delegate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnvio() {
		return envio;
	}

	public void setEnvio(String envio) {
		this.envio = envio;
	}

	public String getReposta() {
		return reposta;
	}

	public void setReposta(String reposta) {
		this.reposta = reposta;
	}

	public String getDelegate() {
		return delegate;
	}

	public void setDelegate(String delegate) {
		this.delegate = delegate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(String interfaces) {
		this.interfaces = interfaces;
	}

	@Override
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<ServicoDTO> getServicos() {
		return servicos;
	}

	public void setServicos(List<ServicoDTO> servicos) {
		this.servicos = servicos;
	}

	public String getTokenAutorizacao() {
		return tokenAutorizacao;
	}

	public void setTokenAutorizacao(String tokenAutorizacao) {
		this.tokenAutorizacao = tokenAutorizacao;
	}
	
	

}
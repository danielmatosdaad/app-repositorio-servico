package br.app.repositorio.servico.integracao;

import java.util.Iterator;
import java.util.List;

import br.app.barramento.integracao.dto.DTO;
import br.app.barramento.integracao.exception.NegocioException;

public class RepositorioServicoDTO implements RepositorioServico, DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String nomeArtefatoId;
	private String loginServidor;
	private String senhaServidor;
	private String ipServidor;
	private String portaServidor;
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
	public CatalogoServico buscar(String nameCatalogo) throws NegocioException {

		if (nameCatalogo == null || nameCatalogo.trim().equals("")) {
			throw new NegocioException("Nome Servico invalido", new RuntimeException());
		}
		if (catalogo != null) {

			for (Iterator<CatalogoServicoDTO> iterator = catalogo.iterator(); iterator.hasNext();) {
				CatalogoServicoDTO catalaogo = (CatalogoServicoDTO) iterator.next();

				if (nameCatalogo.equals(catalaogo.getNome())) {
					return catalaogo;
				}
			}
		}

		throw new NegocioException("Catalogo nao encontrado: " + nameCatalogo, new RuntimeException());
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

	public String getNomeArtefatoId() {
		return nomeArtefatoId;
	}

	public void setNomeArtefatoId(String nomeArtefatoId) {
		this.nomeArtefatoId = nomeArtefatoId;
	}

	public String getLoginServidor() {
		return loginServidor;
	}

	public void setLoginServidor(String loginServidor) {
		this.loginServidor = loginServidor;
	}

	public String getSenhaServidor() {
		return senhaServidor;
	}

	public void setSenhaServidor(String senhaServidor) {
		this.senhaServidor = senhaServidor;
	}

	public String getIpServidor() {
		return ipServidor;
	}

	public void setIpServidor(String ipServidor) {
		this.ipServidor = ipServidor;
	}

	public String getPortaServidor() {
		return portaServidor;
	}

	public void setPortaServidor(String portaServidor) {
		this.portaServidor = portaServidor;
	}

}

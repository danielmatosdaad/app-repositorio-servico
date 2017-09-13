package br.app.respositorio.dao.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.app.barramento.integracao.dao.interfaces.Entidade;

@Entity
@XmlRootElement
@Table(name = "repositorio")
public class Repositorio implements Entidade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String nomeArtefatoId;
	private String loginServidor;
	private String senhaServidor;
	private String ipServidor;
	private String portaServidor;
	private boolean ativo;

	@OneToMany(mappedBy = "repositorio", fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
	private List<Catalogo> catalogo;

	public List<Catalogo> getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(List<Catalogo> catalogo) {
		this.catalogo = catalogo;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {

		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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

	public String getNomeArtefatoId() {
		return nomeArtefatoId;
	}

	public void setNomeArtefatoId(String nomeArtefatoId) {
		this.nomeArtefatoId = nomeArtefatoId;
	}

}

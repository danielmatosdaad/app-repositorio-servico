package br.app.respositorio.dao.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.app.barramento.integracao.dao.interfaces.Entidade;

@Entity
@XmlRootElement
@Table(name = "servico")
public class Servico implements Entidade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private AcaoServico acaoServico;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private InformacaoServico informacaoServico;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Catalogo catalogo;

	private boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AcaoServico getAcaoServico() {
		return acaoServico;
	}

	public void setAcaoServico(AcaoServico acaoServico) {
		this.acaoServico = acaoServico;
	}

	public InformacaoServico getInformacaoServico() {
		return informacaoServico;
	}

	public void setInformacaoServico(InformacaoServico informacaoServico) {
		this.informacaoServico = informacaoServico;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}

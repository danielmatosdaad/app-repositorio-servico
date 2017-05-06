package br.app.respositorio.dao.model;

import java.io.Serializable;
import java.util.List;

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

	private boolean ativo;

	@OneToMany(mappedBy = "repositorio", fetch = FetchType.EAGER)
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

}

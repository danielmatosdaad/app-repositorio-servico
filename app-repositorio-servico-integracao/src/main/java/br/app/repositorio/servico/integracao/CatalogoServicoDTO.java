package br.app.repositorio.servico.integracao;

import java.util.Iterator;
import java.util.List;

import br.app.barramento.integracao.dto.DTO;

public class CatalogoServicoDTO implements CatalogoServico, DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private boolean ativo;
	private List<ServicoDTO> servicos;

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

	@Override
	public InformacaoServico buscarInformacaoServico(String name,String envio) {

		if (name == null || envio==null || name.trim().equals("") || envio.trim().equals("")) {
			throw new RuntimeException("dados obrigatorio do servico invalidos");
		}

		if (servicos != null) {
			for (Iterator<ServicoDTO> iterator = servicos.iterator(); iterator.hasNext();) {
				ServicoDTO servico = (ServicoDTO) iterator.next();

				System.out.println("Comparando: " + name + " " +servico.getAcaoServico().getNome());
				System.out.println("Comparando: " + envio + " " +servico.getInformacaoServico().getEnvio());
				if (name.equals(servico.getAcaoServico().getNome()) && envio.equals(servico.getInformacaoServico().getEnvio())) {
					return servico.getInformacaoServico();
				}
			}

		}

		return null;
	}

	public List<ServicoDTO> getServicos() {
		return servicos;
	}

	public void setServicos(List<ServicoDTO> servicos) {
		this.servicos = servicos;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
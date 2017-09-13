package br.app.repositorio.servico.integracao;

import java.util.Iterator;
import java.util.List;

import br.app.barramento.integracao.dto.DTO;
import br.app.barramento.integracao.exception.NegocioException;

public class CatalogoServicoDTO implements CatalogoServico, DTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String nomeArtefatoId;
	private boolean ativo;
	private RepositorioServicoDTO repositorio;

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
	public InformacaoServico buscarInformacaoServico(String acao, String envio, String tokenAutorizaca)
			throws NegocioException {

		if (acao == null || envio == null || acao.trim().equals("") || envio.trim().equals("")
				|| tokenAutorizaca == null || tokenAutorizaca.isEmpty()) {
			throw new NegocioException("dados obrigatorio do servico invalidos" + acao + envio + tokenAutorizaca,
					new RuntimeException());
		}

		if (servicos != null) {
			for (Iterator<ServicoDTO> iterator = servicos.iterator(); iterator.hasNext();) {
				ServicoDTO servico = (ServicoDTO) iterator.next();

				System.out.println("Comparando: " + acao + " " + servico.getAcaoServico().getNome());
				System.out.println("Comparando: " + envio + " " + servico.getInformacaoServico().getEnvio());
				if (acao.equals(servico.getAcaoServico().getNome())
						&& envio.equals(servico.getInformacaoServico().getEnvio())) {
					if (!servico.getInformacaoServico().getTokenAutorizacao().trim().equals(tokenAutorizaca.trim())) {
						throw new NegocioException("Servico nao autorizado", new RuntimeException());
					}

					return servico.getInformacaoServico();
				}
			}

		}
		throw new NegocioException("Acao " + acao + " nao encontrada para a requsicao: " + envio,
				new RuntimeException());
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

	@Override
	public String getNomeArtefatoId() {
		return this.nomeArtefatoId;
	}

	public void setNomeArtefatoId(String nomeArtefatoId) {
		this.nomeArtefatoId = nomeArtefatoId;
	}

	public RepositorioServicoDTO getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(RepositorioServicoDTO repositorio) {
		this.repositorio = repositorio;
	}

}
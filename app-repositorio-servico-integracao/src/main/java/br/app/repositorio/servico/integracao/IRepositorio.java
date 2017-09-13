package br.app.repositorio.servico.integracao;

import br.app.barramento.integracao.exception.NegocioException;

public interface IRepositorio {

	public RepositorioServico buscar(String name) throws NegocioException;
	
	public InformacaoServico buscarInformacaoServico(String nomeRespositorio,String nomeCatalogo,String nomeAcao,String envio,String tokenAutorizaca) throws NegocioException;
}

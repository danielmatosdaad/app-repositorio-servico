package br.app.repositorio.servico.integracao;


public interface IRepositorio {

	public RepositorioServico buscar(String name);
	
	public InformacaoServico buscarInformacaoServico(String nomeRespositorio,String nomeCatalogo,String nomeAcao,String envio);
}

package br.app.repositorio.servico.integracao;


public interface InformacaoServico {

	public String getInterfaces();

	public String getDelegate();

	public String getReposta();

	public String getEnvio();
	
	public String getTokenAutorizacao();
	
	public boolean isAtivo();

}

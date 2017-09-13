package br.app.repositorio.servico.integracao;

import br.app.barramento.integracao.exception.NegocioException;

public interface RepositorioServico {

	public static final String RESPOSITORIO_CORPORATIVO = RepositorioServicoEnum.RESPOSITORIO_CORPORATIVO.getValue();
	public static final String RESPOSITORIO_INFRA = RepositorioServicoEnum.RESPOSITORIO_INFRA.getValue();

	public boolean isAtivo();

	public String getNomeArtefatoId();

	public String getLoginServidor();

	public String getSenhaServidor();

	public String getIpServidor();

	public String getPortaServidor();

	CatalogoServico buscar(String name) throws NegocioException;
}

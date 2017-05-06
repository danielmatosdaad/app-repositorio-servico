package br.app.repositorio.servico.integracao;

public interface RepositorioServico {

	public static final String RESPOSITORIO_CORPORATIVO = RepositorioServicoEnum.RESPOSITORIO_CORPORATIVO.getValue();
	public static final String RESPOSITORIO_INFRA = RepositorioServicoEnum.RESPOSITORIO_INFRA.getValue();

	String getNome();

	CatalogoServico buscar(String name);
}

package br.app.repositorio.servico.integracao;

public enum RepositorioServicoEnum {

	RESPOSITORIO_CORPORATIVO("REPOSITORIO_CORPORATIVO"), RESPOSITORIO_INFRA("RESPOSITORIO_INFRA");

	private RepositorioServicoEnum(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

}

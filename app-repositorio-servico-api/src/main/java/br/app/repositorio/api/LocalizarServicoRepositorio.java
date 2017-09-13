package br.app.repositorio.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

@SuppressWarnings("hiding")
public class LocalizarServicoRepositorio<IServicoRepositorio> extends AbstractLocalizadorServico<IServicoRepositorio> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "local.repositorio";
	private static final String REGISTRO_NOME_REMOTO = "remote.repositorio";
	public static final String REGISTRO_NOME_LOCAL_DAO = "local.repositorio.dao";
	public static final String REGISTRO_NOME_REMOTO_DAO = "remote.repositorio.dao";

	public LocalizarServicoRepositorio(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao,  REGISTRO_NOME_LOCAL,REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoRepositorio() {
		super(TipoLocalizador.LOCAL,  REGISTRO_NOME_LOCAL,REGISTRO_NOME_REMOTO, LOCALIZACAO_SERVICO);
	}
	
	public LocalizarServicoRepositorio(String tipoLocalizacao, String registroNomeLocalDao,
			String registroNomeRemotoDao) {
		super(TipoLocalizador.getLocalizador(tipoLocalizacao), registroNomeLocalDao, registroNomeRemotoDao,
				LOCALIZACAO_SERVICO);
	}

}
